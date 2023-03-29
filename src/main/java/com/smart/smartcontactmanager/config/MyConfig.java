package com.smart.smartcontactmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class MyConfig {
    @Bean
    public UserDetailsService getUserDetailService(){

        System.out.println("=============invoke user detail service");
        return new UserDetailsServiceImp();
    }

    public BCryptPasswordEncoder passwordEncoder(){

            return new BCryptPasswordEncoder();

    }

@Bean
 public DaoAuthenticationProvider authenticationProvider(){

    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(getUserDetailService());
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    System.out.println("=============================="+daoAuthenticationProvider.getUserCache());
    return daoAuthenticationProvider;
    }

    @Bean
    protected AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.authenticationProvider(authenticationProvider());
        return auth.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        System.out.println("==================i am inside configure===========================================");
        http.csrf().disable();
        http.authorizeHttpRequests()
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/user/**").hasRole("USER")
        .requestMatchers("/**").permitAll()
        .and().formLogin().loginPage("/signin")
        .loginProcessingUrl("/do-login")
        .failureUrl("/home").defaultSuccessUrl("/user/index");
        
        return http.build();
    }
}

// defaultSuccessUrl("/about").