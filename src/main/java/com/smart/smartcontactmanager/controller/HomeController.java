package com.smart.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;;

@Controller
public class HomeController {

   
    // private BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
    // @Bean
    // private BCryptPasswordEncoder encoder() {
    // return new BCryptPasswordEncoder();
    // }

    private BCryptPasswordEncoder bpass = new BCryptPasswordEncoder();

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
    @GetMapping("/signin")
    public String Login(Model model){
        model.addAttribute("title", "Registration Smart Contact manager");
        return "login";
    }
    // @GetMapping("/dashboard")
    // public String dashboard(){
       
    //     return "dashboard";
    // }

    @RequestMapping(value="do_register", method=RequestMethod.POST)

    public String registerUser(@Valid @ModelAttribute User user,BindingResult result,@RequestParam(name = "agreement", defaultValue = "false") boolean agreement,Model model, HttpSession session ){

        try {

            if(result.hasErrors()){
                model.addAttribute("validationResult", result); 
                model.addAttribute("user", user);
                return "signup";
            }
            if(!agreement){
                System.out.println("agreement not accepted");
                throw new Exception("throw exception because agreement not excepted" + agreement);
            }
            user.setEnable(true);
            user.setImage("default.png");
            user.setRole("USER");
            System.out.println(user.getPassword());
            
        
                user.setPassword(bpass.encode(user.getPassword()))  ;
                System.out.println(user.getPassword());
          
            session.setAttribute("message",new Message("this successful message","alert-type"));
            model.addAttribute("user",  new User());
            User saveUser = this.userrepository.save(user);
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
