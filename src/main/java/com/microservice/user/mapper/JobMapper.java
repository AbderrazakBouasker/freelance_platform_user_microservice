package com.microservice.user.mapper;

import com.microservice.user.dto.JobDto;
import com.microservice.user.entity.JobEntity;

import java.util.ArrayList;
import java.util.List;

public class JobMapper {

    public static JobDto mapToJobDto(JobEntity jobEntity, JobDto jobDto) {
        jobDto.setJobTitle(jobEntity.getJobTitle());
        jobDto.setJobDescription(jobEntity.getJobDescription());
        jobDto.setJobProviderId(jobEntity.getJobProviderId());
        jobDto.setJobReceiverId(jobEntity.getJobReceiverId());
        return jobDto;
    }

    public static JobEntity mapToJobEntity(JobDto jobDto, JobEntity jobEntity) {
        jobEntity.setJobTitle(jobDto.getJobTitle());
        jobEntity.setJobDescription(jobDto.getJobDescription());
        jobEntity.setJobProviderId(jobDto.getJobProviderId());
        jobEntity.setJobReceiverId(jobDto.getJobReceiverId());
        return jobEntity;
    }

    public static List<JobDto> mapToJobDtoList(List<JobEntity> jobEntities) {
        List<JobDto> jobDtos = new ArrayList<>();
        for (JobEntity jobEntity : jobEntities) {
            jobDtos.add(mapToJobDto(jobEntity, new JobDto()));
        }
        return jobDtos;
    }

    public static List<JobEntity> mapToJobEntityList(List<JobDto> jobDtos) {
        List<JobEntity> jobEntities = new ArrayList<>();
        for (JobDto jobDto : jobDtos) {
            jobEntities.add(mapToJobEntity(jobDto, new JobEntity()));
        }
        return jobEntities;
    }
}
