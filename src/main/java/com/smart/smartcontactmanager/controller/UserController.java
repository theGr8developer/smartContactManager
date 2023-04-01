package com.smart.smartcontactmanager.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.smart.smartcontactmanager.dao.UserRepository;
import com.smart.smartcontactmanager.model.Contact;
import com.smart.smartcontactmanager.model.User;

import java.util.List;;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @ModelAttribute()
    public void getUser(Model model,Principal principal){

        String userName = principal.getName();
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    }
    @RequestMapping("/index")
   
    public String UserDashBoard(Model model){
           
            // String userName = principal.getName();
            // System.out.println(userName);

            // User user = userRepository.getUserByUserName(userName);

            // model.addAttribute("user", user);

            model.addAttribute("title", "personal dashboard");
        return "normal/user_dashboard";
    }

    //open add contact form 
    @RequestMapping(value="/add-contact",method=RequestMethod.GET)
    public String openAddContactForm(Model model){
        model.addAttribute("title", "add contacts");
        System.out.println("===================add-contact");
        return "normal/add_contact_form";
    }

    // add contact processing 

    @PostMapping("/process-contact")
    public String processContact(@ModelAttribute Contact contact,@RequestParam(name="file") MultipartFile file,Principal principal ){
        
        try{

            System.out.println(contact.getName() + "..." + contact.getEmail());
            
            String username = principal.getName();
            //image handling
            File saveFile = new ClassPathResource("static/img").getFile();
            Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("savefile==========" + saveFile.getPath() + "===" + saveFile.getAbsolutePath());


            System.out.println( "================" +path.toString());
          

            User user = userRepository.getUserByUserName(username);
            List<Contact> contacts = user.getUser_contacts();
            contacts.add(contact);
            user.setUser_contacts(contacts);
            contact.setUser(user);
            contact.setImage(path.toString());


            userRepository.save(user);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return  "normal/add_contact_form";
    }
}
    