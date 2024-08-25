package com.jali.repos.WhishList;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Whishlist")
public class WhishListDataModel implements Serializable {

    @Id
    String Id;

    public WhishListDataModel() {}

    public WhishListDataModel(String id) {
        Id = id;
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
    
}
