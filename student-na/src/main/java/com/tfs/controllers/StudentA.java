package com.tfs.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentA {
    @GetMapping("/getstudent")
    public String getStudent() {
        return "fuck you";
    }
}
