package com.springboot.jobapp.company;

import com.springboot.jobapp.job.Job;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    //one company has many jobs
    @OneToMany
    private List<Job> jobs;

    //one company has (many)list of reviews
    // private List<Review> reviews;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
