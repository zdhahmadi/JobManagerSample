package com.company.jobManager.ws;

import com.company.jobManager.dao.JobRepository;
import com.company.jobManager.dto.Job;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JobController.class)
public class JobControllerTest {
    @MockBean
    JobController jobController;
    @MockBean
    JobRepository jobRepository;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllJobs_success() throws Exception {
        Job job = new Job(5L, "job05", true);
        List<Job> jobs = Arrays.asList(job);

        given(jobController.getAllJobs()).willReturn(jobs);

        mockMvc.perform(get("http://localhost:8080/api/jobs")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("job05"));

    }

    @Test
    public void getJobById_success() throws Exception{
        Job job = new Job(1L, "job01", true);
        List<Job> jobs = Arrays.asList(job);

        given(jobController.getJob(job.getId())).willReturn(java.util.Optional.of(job));

        mockMvc.perform(get("http://localhost:8080/api/job/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("job01"));



    }
}
