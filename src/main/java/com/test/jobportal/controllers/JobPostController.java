package com.test.jobportal.controllers;

import com.test.jobportal.models.JobPost;
import com.test.jobportal.repositories.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController("/jobs")
public class JobPostController {

    @Autowired
    private JobPostRepository jobPostRepository;

    @GetMapping("/getAll")
    public Collection<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    @PostMapping("/post")
    public JobPost addAJobPost(@RequestBody JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }

}
