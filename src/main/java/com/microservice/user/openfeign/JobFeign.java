package com.microservice.user.openfeign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-job")
public interface JobFeign {
}
