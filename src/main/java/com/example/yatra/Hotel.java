package com.example.yatra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class Hotel {
    @GetMapping("/hotel")
    public String getData() {
        return "Hotel Booking.......";
    }
}