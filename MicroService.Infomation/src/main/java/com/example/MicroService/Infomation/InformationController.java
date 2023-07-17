package com.example.MicroService.Infomation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationController {
    @GetMapping("/information")
    public String getProductTitle() {
        return "Connect Micro Service Information Success - Milo";
    }
}
