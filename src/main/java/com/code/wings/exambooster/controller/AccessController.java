package com.code.wings.exambooster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessController {
    @GetMapping("/")
    public String showWelcome() {
        return "welcome-page";
    }
}
