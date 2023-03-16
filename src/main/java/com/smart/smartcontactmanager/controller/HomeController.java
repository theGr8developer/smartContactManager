package com.smart.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.smartcontactmanager.dao.UserRepository;
import com.smart.smartcontactmanager.helper.Message;
import com.smart.smartcontactmanager.model.*;

import jakarta.servlet.http.HttpSession;;

@Controller
public class HomeController {

    @Autowired
    UserRepository userrepository;

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
        model.addAttribute("user",new User() );
        return "signup";
    }
    @GetMapping("/login")
    public String Login(Model model){
        model.addAttribute("title", "Registration Smart Contact manager");
        return "login";
    }

    @RequestMapping(value="do_register", method=RequestMethod.POST)

    public String registerUser(@ModelAttribute User user,@RequestParam(name = "agreement", defaultValue = "false") boolean agreement,Model model, HttpSession session){

        try {
            user.setEnable(true);
            user.setImage("default.png");
            user.setRole("role_model");
            session.setAttribute("message",new Message("this successful message","alert-type"));
            model.addAttribute("user",  new User());
            User result = this.userrepository.save(user);
            System.out.println(user);
            return "signup";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("message",new Message("something going wrong" + e.getMessage(),"alert-type"));
            model.addAttribute("user",user);
            return "signup";
        }
       
    }
    
}
