package com.jali.repos.Cart;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;

import com.jali.repos.Customer.CustomerDataModel;
import com.jali.repos.Product.ProductDataModel;

@Entity
@Table(name = "Cart")
public class CartDataModel implements Serializable {


    @EmbeddedId
    CartId Id;

    @OneToMany
    ArrayList<ProductDataModel> products;

    @OneToOne
    CustomerDataModel customer;

    public CartDataModel() {}

    public CartDataModel(CustomerDataModel customer) {
        this.Id= new CartId(customer.getId(), null);
        this.customer=customer;
    }

    
    


    @Embeddable
    public static class CartId implements Serializable{

        String customerID;
        Long cartID;


        public CartId(String customerID, Long cartID){
            this.customerID = customerID;
            this.cartID = cartID;
        }


        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
            result = prime * result + ((cartID == null) ? 0 : cartID.hashCode());
            return result;
        }


        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            CartId other = (CartId) obj;
            if (customerID == null) {
                if (other.customerID != null)
                    return false;
            } else if (!customerID.equals(other.customerID))
                return false;
            if (cartID == null) {
                if (other.cartID != null)
                    return false;
            } else if (!cartID.equals(other.cartID))
                return false;
            return true;
        }


        public String getCustomerID() {
            return customerID;
        }


        public void setCustomerID(String customerID) {
            this.customerID = customerID;
        }


        public Long getCartID() {
            return cartID;
        }


        public void setCartID(Long cartID) {
            this.cartID = cartID;
        }

        
    }
}
