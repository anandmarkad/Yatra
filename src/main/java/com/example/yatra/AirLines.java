package com.example.yatra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirLines {
    @GetMapping("/AirLines")
    public String getData() {
        return "Airoplane mai CNG nahi hai....";
    }
}