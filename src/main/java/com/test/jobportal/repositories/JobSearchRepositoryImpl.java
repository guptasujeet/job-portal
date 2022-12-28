package com.test.jobportal.repositories;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.test.jobportal.models.JobPost;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class JobSearchRepositoryImpl implements JobSearchRepository {


    @Autowired
    private MongoClient mongoClient;

    @Autowired
    private MongoConverter mongoConverter;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Override
    public Collection<JobPost> findByText(String text) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> jobPostCollection = mongoDatabase.getCollection("JobPost");

        Collection<JobPost> jobPosts = new ArrayList<>();

        AggregateIterable<Document> result = jobPostCollection.aggregate(
                Arrays.asList(
                        new Document("$search",
                                new Document("index", "default")
                                        .append("text", new Document("query", text)
                                                .append("path", Arrays.asList("profile", "desc")))),
                        new Document("$sort",
                                new Document("profile", -1L)),
                        new Document("$limit", 10L)
                ));

        result.forEach(doc -> jobPosts.add(mongoConverter.read(JobPost.class, doc)));

        return jobPosts;
    }
}
