package com.roselake.jbc;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    CloudinaryConfig cloudinaryConfig;

    /* root :: LIST of ALL JOBS */
    @GetMapping("/")
    public String jobList(Model model){
        model.addAttribute("jobs", jobRepository.findAll());
        return "joblist";
    }

    /* searchlist :: LIST of JOB SEARCH RESULTS */
    @PostMapping("/search")
    public String searchList(@RequestParam("input") String input, Model model){
        model.addAttribute("jobs", jobRepository.findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrDescriptionContainingIgnoreCase(input, input, input));
        return "searchlist";
    }

    /* jobform :: ADD a NEW JOB */
    @GetMapping("/add")
    public String addJob(Model model){
        model.addAttribute("job", new Job());
        return "jobform";
    }

    /* jobform :: EDIT an EXISTING JOB */
    @GetMapping("/edit/{id}")
    public String editJob(@PathVariable("id") long id, Model model){
        model.addAttribute("job", jobRepository.findById(id).get());
        return "jobform";
    }

    /* redirect / :: DELETE an EXISTING JOB */
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable("id") long id, Model model){
        jobRepository.deleteById(id);
        return "redirect:/";
    }

    /* jobdetail :: VIEW an EXISTING JOB */
    @GetMapping("/view/{id}")
    public String viewJob(@PathVariable("id") long id, Model model){
        model.addAttribute("job", jobRepository.findById(id).get());
        return "jobdetail";
    }


    /* redirect / :: IF successful save of job, with or without an image
     * jobform :: IF binding result has ERRORS */
    @PostMapping("/process")
    public String processJob(@Valid Job job, BindingResult result, @RequestParam("file") MultipartFile file){

        if (result.hasErrors()) {
            // redisplay jobform, this time with binding errors shown (via span th:if)
            return "jobform";
        }

        if (file.isEmpty()) {
            // no image entered
            // simply save and move on
            // NOTE: image field may have a value, or it may be "" (meaning no value was set)
            jobRepository.save(job);
            return "redirect:/";
        }

        // getting here indicates that a new image file was uploaded by the user
        try {
            Map uploadResult = cloudinaryConfig.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "file"));
            job.setImage(uploadResult.get("url").toString());
        } catch (IOException e) {
            // if something fails in the image upload...
            e.printStackTrace();
            job.setImage("");           // set image to default (any old image does not persist)
        }
        jobRepository.save(job);       // save the job, either with successful new url, or "" if upload failed
        return "redirect:/";           // redirect to root

    }

}
