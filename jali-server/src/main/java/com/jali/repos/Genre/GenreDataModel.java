package com.jali.repos.Genre;

import java.io.Serializable;

import org.hibernate.mapping.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.jali.repos.Category.CategoryDataModel;
import com.jali.repos.Product.ProductDataModel;
import java.util.*;;

@Entity
@Table(name = "Genre")
public class GenreDataModel implements Serializable {
    @Id
    String Id;
    String name;
    @OneToMany(mappedBy = "genre")
    private ArrayList<ProductDataModel> products;

    @OneToMany
    private ArrayList<CategoryDataModel> categorys;



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
