package com.microservice.user.entity;

import lombok.Data;

@Data
public class JobEntity {

    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private Long jobProviderId;
    private Long jobReceiverId;
}
