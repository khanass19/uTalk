package com.example.project.controller.FrontendController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class FrontendCotroller {
    @GetMapping("/page")
    public String getStartPage() throws IOException {
        return "/index.html";
    }
}
