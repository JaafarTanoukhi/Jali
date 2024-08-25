package com.jali.repos.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class CategoryDataModel implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long Id;
    String name;


    public CategoryDataModel(){}
    

    public CategoryDataModel(String name) {
        this.name = name;
    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
