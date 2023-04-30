package com.example.yatra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bus {
    @GetMapping("/Bus")
    public String getData() {
        return "Bus available nahiye bhava";
    }
}
