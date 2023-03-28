package com.smart.smartcontactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.smartcontactmanager.dao.UserRepository;
import com.smart.smartcontactmanager.model.User;

public class UserDetailsServiceImp implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = userRepository.getUserByUserName(username);
        System.out.println("================="+ user.getEmail() +" " + user.getRole()+"=====================================");
        if(username == null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("username not found");
        }

        CustomUserDetail customUserDetail = new CustomUserDetail(user); 
        return customUserDetail ;
    }
    
}
