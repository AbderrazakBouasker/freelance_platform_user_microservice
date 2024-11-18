package com.microservice.user.entity;

import lombok.Data;

//todo: Change int -> Long for jobProviderId and jobReceiverId
@Data
public class JobEntity {

    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private int jobProviderId;
    private int jobReceiverId;
}
