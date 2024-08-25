package com.jali.repos.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductDataModel {
    
    @Id
    String Id;
    String name;
    Integer price;

    public ProductDataModel(){}

    public ProductDataModel(String id, String name, Integer price) {
        Id = id;
        this.name = name;
        this.price = price;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    
}
