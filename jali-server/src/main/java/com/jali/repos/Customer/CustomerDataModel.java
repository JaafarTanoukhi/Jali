package com.jali.repos.Customer;

import com.jali.repos.Account.AccountDataModel;
import com.jali.repos.Cart.CartDataModel;
import com.jali.repos.WhishList.WhishListDataModel;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@DiscriminatorValue("Customer")
public class CustomerDataModel extends AccountDataModel {


    @OneToOne
    WhishListDataModel whishlist;

    @OneToOne
    CartDataModel cart;

    public CustomerDataModel() {super();}

    
    
    
    public CustomerDataModel(String id) {
        Id = id;
    }




    public CustomerDataModel(String accountId, String email, String username, String hashedPassword) {
        super(accountId, email, username, hashedPassword);
    }
    
}
