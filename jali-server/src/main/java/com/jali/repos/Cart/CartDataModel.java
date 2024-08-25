package com.jali.repos.Cart;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Cart")
public class CartDataModel implements Serializable {

    @Id
    public String Id;

    public CartDataModel() {}

    public CartDataModel(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
    
}
