package com.springboot.jobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);


    Job getjobById(Long id);


    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
