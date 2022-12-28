package com.test.jobportal.repositories;

import com.test.jobportal.models.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost, String>, JobSearchRepository {
}
