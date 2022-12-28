package com.test.jobportal.repositories;

import com.test.jobportal.models.JobPost;

import java.util.Collection;

public interface JobSearchRepository {
    Collection<JobPost> findByText(String text);
}
