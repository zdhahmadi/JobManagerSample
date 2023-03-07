package com.company.jobManager.componentService;

import com.company.jobManager.dao.JobRepository;
import com.company.jobManager.dto.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements com.company.jobManager.componentService.JobService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs() {
        return (List<Job>)jobRepository.findAll();
    }

    @Override
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job updateJob(Long id, Job newJob) {
        return jobRepository.findById(id)
                .map(job -> {
                    job.setId(newJob.getId());
                    job.setName(newJob.getName());
                    job.setStarted(newJob.getStarted());
                    return jobRepository.save(job);
                })
                .orElseGet(() -> jobRepository.save(newJob));
    }

    @Override
    public Job saveJob(Job newJob) {
        return jobRepository.save(newJob);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
