package com.jali.repos.Category;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class CategoryDataModel implements Serializable {
    @Id
    public String Id;
    public String name;


    public CategoryDataModel(){}


    public CategoryDataModel(String id, String name) {
        Id = id;
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
