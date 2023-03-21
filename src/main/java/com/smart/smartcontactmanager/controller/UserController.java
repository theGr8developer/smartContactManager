package com.smart.smartcontactmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public class UserController {
    
    @RequestMapping("/dashboard")
    public String UserDashBoard(){

        return "/dashbord";
    }
}
    