package com.test.jobportal.controllers;

import com.test.jobportal.models.JobPost;
import com.test.jobportal.repositories.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController("/jobs")
public class JobPostController {

    @Autowired
    private JobPostRepository jobPostRepository;

    @GetMapping("/getAll")
    public Collection<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    @GetMapping("/search/{text}")
    public Collection<JobPost> searchJobPosts(@PathVariable String text) {
        return jobPostRepository.findByText(text);
    }

    @PostMapping("/post")
    public JobPost addAJobPost(@RequestBody JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }

}
