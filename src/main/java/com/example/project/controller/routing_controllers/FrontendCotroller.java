package com.example.project.controller.routing_controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendCotroller {

    @GetMapping("/public/page")
    public String getStartPage() {
        return "/index.html";
    }

}
