package com.smart.smartcontactmanager.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.*;

@Entity
@Table(name="user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NotBlank(message = "Not should not be empty")
    String name;
    @Column(unique=true)
    @NotBlank
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="this is not valid email format")
    String email;

    @Size(min = 4,max = 6,message="size should be between 4 to 6")
    String password;
    String image;
    @Column(length=500)
    @NotBlank(message="about should not be empty")
    String About;
    String role;
    boolean enable;
    String phone;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="user")
    List<Contact>user_contacts = new ArrayList<>();
    public User(int id, String name, String email, String password, String image, String about, String role,
            boolean enable, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.image = image;
        About = about;
        this.role = role;
        this.enable = enable;
        this.phone = phone;
    }
    public User() {
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getImage() {
        return image;
    }
    public String getAbout() {
        return About;
    }
    public String getRole() {
        return role;
    }
    public boolean isEnable() {
        return enable;
    }

    public String getPhone(){
        return phone;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setAbout(String about) {
        About = about;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }



    
}
