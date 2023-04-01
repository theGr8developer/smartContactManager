package com.smart.smartcontactmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;

@Entity
@Table(name="contact_table")
public class Contact {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int cId;
    String name;
    String nickname;
    String email;
    String phone;
    String work;
    String image;
    // @Column(length=500)
    String about;
    @ManyToOne
    User user;
    public Contact(int cId, String name, String nickname, String email, String phone, String work, String image,
            String about, User user) {
        this.cId = cId;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.work = work;
        this.image = image;
        this.about = about;
        this.user = user;
    }
    public Contact() {
    }
    public int getcId() {
        return cId;
    }
    public String getName() {
        return name;
    }
    public String getNickname() {
        return nickname;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getWork() {
        return work;
    }
    public String getImage() {
        return image;
    }
    public String getAbout() {
        return about;
    }
    public User getUser() {
        return user;
    }
    public void setcId(int cId) {
        this.cId = cId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setWork(String work) {
        this.work = work;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
}
