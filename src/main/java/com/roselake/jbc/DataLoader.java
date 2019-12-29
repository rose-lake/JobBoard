package com.roselake.jbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    JobRepository repository;

    @Override
    public void run(String... strings) throws Exception {

        if (repository.count() == 0) {

            repository.save(new Job("Testing Guru", "IBM",
                    "This is a description... There will be some text here... And a disclaimer... " +
                            "We are an awesome company... Come work for us!... This is a position at IBM... " +
                            "We need a testing guru... Also you're going to do Data stuff for us! " +
                            "And... You're going to come in and solve all our problems!... No pressure!... " +
                            "This job comes with some perks and benefits to balance out the ridiculous amounts " +
                            "of responsibility we're putting on this position... " +
                            "These include stuff, stuff, and more stuff. More information, more info, more info.",
                    "2019-11-30", "Jane Hiring Manager", "(222) 111-3333", "jane@ibm.com",
                    "https://res.cloudinary.com/roselake/image/upload/v1574707587/nyc-skyline.png"));

            repository.save(new Job("Software Engineer", "Apple",
                    "This is a really sort of long description... " +
                            "There will be some text here... And a disclaimer... " +
                            "We are an awesome company... Come work for us!... This is a position at Apple. " +
                            "You're going to rock! You get to come code with us. " +
                            "Good luck on the coding interview. We hope you do well. " +
                            "Our job comes with perks and benefits. These include stuff, stuff, and more stuff. " +
                            "More information, more info, more info.",
                    "2019-11-25", "Steve Jobs Jr.", "(111) 111-1111", "stevejr@apple.com",
                    "https://res.cloudinary.com/roselake/image/upload/v1574713779/nature-purple-night.png"));

            repository.save(new Job("Software Developer", "Microsoft",
                    "We are an awesome company... Come work for us!... This is a position at Microsoft... " +
                            "We need a senior software developer... " +
                            "You're going to come in and solve all our problems!... No pressure!... " +
                            "This job comes with some perks and benefits to balance out the ridiculous amounts of " +
                            "responsibility we're putting on this position... " +
                            "These include stuff, stuff, and more stuff. " +
                            "More information, more info, more info.",
                    "2019-11-30", "Jill Hiring Manager", "(222) 111-5555", "jill@microsoft.com",
                    "https://res.cloudinary.com/roselake/image/upload/v1574707555/philly-skyline.png"));

            repository.save(new Job("Net Ninja", "Hollywood",
                    "You're going to be a net ninja in hollywood... " +
                            "This is a combination acting and coding job. You will be coding and acting every day. Have fun!",
                    "2019-11-30", "Rose Lake", "(555) 222-5555", "rose@lake.com",
                    "https://res.cloudinary.com/roselake/image/upload/v1574707798/la-hollywood.png"));

//            repository.save(new Job("Graphic Designer", "Apple",
//                    "You get to work with Pierz and be a Graphic Designer for Apple! Awesome!",
//                    "2019-12-02", "Pierz Barry", "(333) 222-4444", "pierz@apple.com",
//                    "https://res.cloudinary.com/roselake/image/upload/v1574712084/green-flare.png"));
//
//            repository.save(new Job("Data Analyst", "NIST",
//                    "This is a really long description... " +
//                            "There will be some text here... And a disclaimer... " +
//                            "We are an awesome company... Come work for us!... " +
//                            "This job is an entry-level data analyst position... Come work with us! " +
//                            "Let's add one more line to really make sure this is a rather lengthy description.",
//                    "2019-12-05", "Joe Hiring Manager", "(222) 111-7777", "joe@jobco.com"));

        }
    }

}
