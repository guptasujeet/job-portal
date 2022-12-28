package com.test.jobportal.models;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobPost")
public record JobPost(String profile, String desc, int experience, String[] skills) {
}