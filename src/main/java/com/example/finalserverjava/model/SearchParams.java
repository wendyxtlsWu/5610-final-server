package com.example.finalserverjava.model;

import javax.persistence.*;

@Entity

public class SearchParams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String size;
    private String age;
    private String photo;
    private String type;
    private String gender;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getAge() {
        return age;
    }

    public String getPhoto() {
        return photo;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }
}
