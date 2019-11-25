package com.roselake.jbc;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface JobRepository extends CrudRepository<Job, Long> {
    ArrayList<Job> findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String title, String company, String description);

    // OR SEARCH ON...
    // title Containing
    // company Containing
    // description Containing

    // CONTAINING == "tor" pulls up "Victor" and "notorious" and ...
    // CONTAINS == "tor" pulls up only "tor".

}
