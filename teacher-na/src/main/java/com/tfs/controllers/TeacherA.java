package com.tfs.controllers;

import com.tfs.feign.studentFeign;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TeacherA {

    private final LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate;
    private final studentFeign studentFeign;

    public TeacherA(LoadBalancerClient loadBalancerClient,
                    RestTemplate restTemplate,
                    studentFeign studentFeign) {
        this.loadBalancerClient = loadBalancerClient;
        this.restTemplate = restTemplate;
        this.studentFeign = studentFeign;
    }

    @GetMapping("/getteacher")
    public String getTeacher() {
//        final ServiceInstance student = loadBalancerClient.choose("student");
//        String forObject = restTemplate.getForObject("http://"
//                +student.getHost()
//                +":"+student.getPort()+"/getstudent",String.class);
//        String forObject = restTemplate.getForObject("http://student/getstudent",String.class);
        var forObject = studentFeign.getstudent();
        return forObject + " teacher";
    }
}
