package com.roselake.jbc;

import javax.persistence.*;
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
    @Column(columnDefinition = "VARCHAR(4096)")
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

    public Job(@NotNull @Size(min = 3) String title,
               @NotNull @Size(min = 3) String company,
               @NotNull @Size(min = 3) String description,
               @NotNull @Size(min = 10) String postedDate,
               @NotNull @Size(min = 2) String contactName,
               @NotNull @Size(min = 10) String contactPhone,
               @NotNull @Size(min = 5) String contactEmail,
               @NotNull String image) {
        this.title = title;
        this.company = company;
        this.description = description;
        this.postedDate = postedDate;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
