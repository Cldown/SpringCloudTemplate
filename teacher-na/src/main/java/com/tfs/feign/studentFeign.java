package com.tfs.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("student")
public interface studentFeign {
    @GetMapping("/getstudent")
    String getstudent();
}
