package com.jali.repos.Tags;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class TagsDataModel implements Serializable{
    
    String name;

    
    public TagsDataModel(){}

    public TagsDataModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    


}
