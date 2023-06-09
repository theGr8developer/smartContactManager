package com.smart.smartcontactmanager.config;

import java.util.Collection;
import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.smartcontactmanager.model.User;



public class CustomUserDetail implements UserDetails{

    User user;

    public CustomUserDetail(User user){
        super();
        System.out.println("=============custom user detail===============");
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());

        System.out.println("===============getauthority=== "+simpleGrantedAuthority.getAuthority()+"============");
       
        return List.of(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
