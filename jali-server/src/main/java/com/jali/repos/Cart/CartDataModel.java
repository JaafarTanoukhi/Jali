package com.jali.repos.Cart;

import java.io.Serializable;
import java.util.List;

import com.jali.repos.Customer.CustomerDataModel;
import com.jali.repos.Product.ProductDataModel;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cart")
public class CartDataModel implements Serializable {


    @EmbeddedId
    CartId Id;

    @OneToMany
    List<ProductDataModel> products;

    public CartDataModel() {}

    public CartDataModel(CartId id) {
        this.Id = id;
    }

    public List<ProductDataModel> getProducts(){
        return this.products;
    }

    @Embeddable
    public static class CartId implements Serializable {
        
        @OneToOne
        @JoinColumn(name = "customer_id", insertable = false, updatable = false)
        private CustomerDataModel customer;
    
        @Column(name = "cart_id")
        private Long cartID;
    
        // Default constructor (required by JPA)
        public CartId() {}
    
        // Constructor for setting the composite key
        public CartId(CustomerDataModel customer, Long cartID) {
            this.customer = customer;
            this.cartID = cartID;
        }
    
        // Getters and setters
        public Long getCartID() {
            return cartID;
        }
    
        public void setCartID(Long cartID) {
            this.cartID = cartID;
        }
    
        public CustomerDataModel getCustomer() {
            return customer;
        }
    
        public void setCustomer(CustomerDataModel customer) {
            this.customer = customer;
        }
    
        // Equals and hashCode methods (correctly referencing fields)
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((customer == null) ? 0 : customer.hashCode());
            result = prime * result + ((cartID == null) ? 0 : cartID.hashCode());
            return result;
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            
            CartId other = (CartId) obj;
            if (cartID == null) {
                if (other.cartID != null)
                    return false;
            } else if (!cartID.equals(other.cartID))
                return false;
    
            if (customer == null) {
                return other.customer == null;
            } else return customer.equals(other.customer);
        }
    }
}
