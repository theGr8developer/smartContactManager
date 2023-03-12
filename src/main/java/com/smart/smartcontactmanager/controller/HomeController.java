package com.smart.smartcontactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
 
    public String Home(){

        return "home";
    }
    @GetMapping("/about")
    public String About(){

        return "about";
    }
    
}
