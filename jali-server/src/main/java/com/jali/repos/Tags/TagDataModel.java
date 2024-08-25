package com.jali.repos.Tags;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tag")
public class TagDataModel implements Serializable{
    
    String name;

    
    public TagDataModel(){}

    public TagDataModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    


}
