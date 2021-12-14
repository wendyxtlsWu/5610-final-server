package com.example.finalserverjava.model;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private String username;
    private String petId;
    private String petTitle;
    private String content;
    private String petImageURL;

    public String getPetImageURL() {
        return petImageURL;
    }

    public void setPetImageURL(String petImageURL) {
        this.petImageURL = petImageURL;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetTitle() {
        return petTitle;
    }

    public void setPetTitle(String petTitle) {
        this.petTitle = petTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}



