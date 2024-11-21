package com.cda.cda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicStaticPagesController {

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }
}
