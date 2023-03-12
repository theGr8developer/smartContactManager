package com.smart.smartcontactmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    String work;
    String image;
    @Column(length=500)
    String about;
    @ManyToOne
    User user;
    public Contact(int cId, String name, String nickname, String email, String work, String image, String about) {
        this.cId = cId;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.work = work;
        this.image = image;
        this.about = about;
    }
    public Contact() {
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
    public void setWork(String work) {
        this.work = work;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setAbout(String about) {
        this.about = about;
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
    public String getWork() {
        return work;
    }
    public String getImage() {
        return image;
    }
    public String getAbout() {
        return about;
    }
    
    
}
