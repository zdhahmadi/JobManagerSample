package com.company.jobManager.ws;

import com.company.jobManager.componentService.JobService;
import com.company.jobManager.dto.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/job/{jobId}")
    public Optional<Job> getJob(@PathVariable("jobId") Long id){
        return jobService.getJobById(id);
    }

    @PostMapping("/job")
    public Object saveJob(@Validated @RequestBody Job newJob) {
        return jobService.saveJob(newJob);
    }

    @DeleteMapping("/job/{jobId}")
    private void deleteJob(@PathVariable("jobId") Long id)
    {
        jobService.deleteJob(id);
    }

    @PutMapping("/job/{jobId}")
    public void activeJob(@RequestBody Job newJob,  @PathVariable("jobId") Long id) {
        jobService.updateJob(id, newJob);
    }


}
