package com.microservice.user.dto;

import lombok.Data;

@Data
public class JobDto {
    private String jobTitle;
    private String jobDescription;
    private int jobProviderId;
    private int jobReceiverId;
}
