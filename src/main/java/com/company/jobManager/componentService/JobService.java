package com.company.jobManager.componentService;

import com.company.jobManager.dto.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> getAllJobs();
    Optional<Job> getJobById(Long id);
    Job updateJob (Long id, Job newJob);
    Job saveJob(Job newJob);
    void deleteJob(Long id);
}
