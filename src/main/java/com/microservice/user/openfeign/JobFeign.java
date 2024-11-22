package com.microservice.user.openfeign;

import com.microservice.user.dto.JobDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-job", url = "${microservice-job.url}")
public interface JobFeign {
    @GetMapping("/{jobId}")
    JobDto getJob(@PathVariable("jobId") Long jobId);

    @GetMapping("/")
    List<JobDto> getAllJobs();

    @GetMapping("/provider/{jobProviderId}")
    List<JobDto> getAllJobsByJobProvider(@PathVariable("jobProviderId") Long jobProviderId);

    @GetMapping("/receiver/{jobReceiverId}")
    List<JobDto> getAllJobsByJobReceiver(@PathVariable("jobReceiverId") Long jobReceiverId);

    @GetMapping("/provider/{jobProviderId}/receiver/{jobReceiverId}")
    List<JobDto> getAllJobsByJobProviderAndJobReceiver(@PathVariable("jobProviderId") Long jobProviderId, @PathVariable("jobReceiverId") Long jobReceiverId);

    @GetMapping("/user/{userId}")
    List<JobDto> getAllJobsByUser(@PathVariable("userId") Long userId);
}
