package com.smart.smartcontactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
 
    public String Home(Model model){
        model.addAttribute("title", "Home Smart Contact manager");
        return "home";
    }
    @GetMapping("/about")
    public String About(Model model){
        model.addAttribute("title", "About Smart Contact manager");
        return "about";
    }
    @GetMapping("/signup")
    public String Signup(Model model){
        model.addAttribute("title", "Signup Smart Contact manager");
        return "signup";
    }
    @GetMapping("/login")
    public String Login(Model model){
        model.addAttribute("title", "Registration Smart Contact manager");
        return "login";
    }
    
}
