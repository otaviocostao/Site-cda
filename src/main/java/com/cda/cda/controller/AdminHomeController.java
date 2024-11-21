package com.cda.cda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @GetMapping
    public String loginAdmin(){
        return "admin/admin_login";
    }

    @GetMapping("/home")
    public String homeAdmin(){
        return "admin/admin_home";
    }
}
