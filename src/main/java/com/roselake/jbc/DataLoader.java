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

        repository.save(new Job("Data Analyst", "Job Co.", "This is a really long description... There will be some text here... And a disclaimer... " +
                "We are an awesome company... Come work for us!... This job is an entry-level data analyst position... You won't regret joining us!" +
                "Let's add one more line to really make sure the constructor works.", "2019-12-05", "Joe Schmoe Hiring Manager", "(301) 221-6107", "joe@jobco.com"));

        repository.save(new Job("Software Engineer", "Apple", "This is a really long description... There will be some text here... And a disclaimer... " +
                "We are an awesome company... Come work for us!... This is a position at Apple. You're going to rock! You get to come code with us." +
                "Good luck on the coding interview. We hope you do well. Our job comes with perks and benefits. These include stuff, stuff, and more stuff." +
                "More information, more info, more info.", "2019-11-25", "Steve Jobs Jr.", "(111) 111-1111", "stevejr@apple.com"));

        repository.save(new Job("Testing Guru", "IBM", "This is a really long description... There will be some text here... And a disclaimer... " +
                "We are an awesome company... Come work for us!... This is a position at IBM... We need a testing guru... You're going to come in and solve all our problems!..." +
                "No pressure!... This job comes with some perks and benefits to balance out the ridiculous amounts of responsibility we're putting on this position... " +
                "These include stuff, stuff, and more stuff. More information, more info, more info.", "2019-11-30", "Jane Doe Hiring Manager", "(222) 111-2345", "jane@ibm.com"));


    }


}
