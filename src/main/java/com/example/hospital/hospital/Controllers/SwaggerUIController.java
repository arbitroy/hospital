package com.example.hospital.hospital.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerUIController {

    @GetMapping("/swagger-ui")
    public String swaggerUI() {
        return "redirect:/swagger-ui/index.html";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/swagger-ui/index.html";
    }
}
