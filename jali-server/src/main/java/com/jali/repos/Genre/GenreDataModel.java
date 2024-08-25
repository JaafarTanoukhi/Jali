package com.jali.repos.Genre;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Genre")
public class GenreDataModel implements Serializable {
    @Id
    String Id;
    String name;


    public GenreDataModel(){}

    

    public GenreDataModel(String id, String name) {
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
