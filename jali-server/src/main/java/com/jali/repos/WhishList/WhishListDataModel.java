package com.jali.repos.WhishList;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.*;

import com.jali.repos.Customer.CustomerDataModel;
import com.jali.repos.Product.ProductDataModel;

@Entity
@Table(name = "Whishlist")
public class WhishListDataModel implements Serializable {

    @EmbeddedId
    WhishlistId Id;

    @OneToMany
    ArrayList<ProductDataModel> products;

    @OneToOne
    @JoinColumn(insertable = false, updatable = false)
    CustomerDataModel customer;

    public WhishListDataModel() {}

    public WhishListDataModel(CustomerDataModel customer) {
        this.customer=customer;
        this.Id= new WhishlistId(customer.getId(), null);

    }
   


    @Embeddable
    public static class WhishlistId implements Serializable{

        String CustomerId;
        Long WhishlistId;

        public WhishlistId(String CustomerId, Long WhishlistId){
            this.CustomerId = CustomerId;
            this.WhishlistId = WhishlistId;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((CustomerId == null) ? 0 : CustomerId.hashCode());
            result = prime * result + ((WhishlistId == null) ? 0 : WhishlistId.hashCode());
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
            WhishlistId other = (WhishlistId) obj;
            if (CustomerId == null) {
                if (other.CustomerId != null)
                    return false;
            } else if (!CustomerId.equals(other.CustomerId))
                return false;
            if (WhishlistId == null) {
                if (other.WhishlistId != null)
                    return false;
            } else if (!WhishlistId.equals(other.WhishlistId))
                return false;
            return true;
        }

        public String getCustomerId() {
            return CustomerId;
        }

        public void setCustomerId(String customerId) {
            CustomerId = customerId;
        }

        public Long getWhishlistId() {
            return WhishlistId;
        }

        public void setWhishlistId(Long whishlistId) {
            WhishlistId = whishlistId;
        }

        

    }
    
}
