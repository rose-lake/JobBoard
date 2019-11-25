package com.roselake.jbc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=3)
    private String title;

    @NotNull
    @Size(min=3)
    private String company;

    @NotNull
    @Size(min=3)
    private String description;

    @NotNull
    @Size(min=10)
    private String postedDate;

    @NotNull
    @Size(min=2)
    private String contactName;

    @NotNull
    @Size(min=10)
    private String contactPhone;

    @NotNull
    @Size(min=5)
    private String contactEmail;

    @NotNull
    private String image;

    public Job() {
        this.image = "";
    }

    public Job(@NotNull @Size(min = 3) String title,
               @NotNull @Size(min = 3) String company,
               @NotNull @Size(min = 3) String description,
               @NotNull @Size(min = 10) String postedDate,
               @NotNull @Size(min = 2) String contactName,
               @NotNull @Size(min = 10) String contactPhone,
               @NotNull @Size(min = 5) String contactEmail) {
        this.title = title;
        this.company = company;
        this.description = description;
        this.postedDate = postedDate;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.image = "";
    }
}
