package com.jali.repos.Order;

import java.io.Serializable;
import java.util.List;

import com.jali.repos.PaymentMethod.PaymentMethodDataModel;
import com.jali.repos.Product.ProductDataModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class OrderDataModel implements Serializable {

    @Id
    String Id;

    Integer fullTotal;

    @Embedded
    Address address;

    @OneToMany
    List<ProductDataModel> products;

    @OneToMany
    List<PaymentMethodDataModel> paymentMethods;

    public OrderDataModel() {
    }
    
    public OrderDataModel(String id, Integer fullTotal, Address address) {
        Id = id;
        this.fullTotal = fullTotal;
        this.address = address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Integer getFullTotal() {
        return fullTotal;
    }

    public void setFullTotal(Integer fullTotal) {
        this.fullTotal = fullTotal;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }    

    @Embeddable
    public class Address {

        String country;
        String city;
        String building;
        String extraDeliveryDetails;

        public Address(){}


        public Address(String country, String city, String building, String extraDeliveryDetails) {
            this.country = country;
            this.city = city;
            this.building = building;
            this.extraDeliveryDetails = extraDeliveryDetails;
        }


        public String getCountry() {
            return country;
        }


        public void setCountry(String country) {
            this.country = country;
        }


        public String getCity() {
            return city;
        }


        public void setCity(String city) {
            this.city = city;
        }


        public String getBuilding() {
            return building;
        }


        public void setBuilding(String building) {
            this.building = building;
        }


        public String getExtraDeliveryDetails() {
            return extraDeliveryDetails;
        }


        public void setExtraDeliveryDetails(String extraDeliveryDetails) {
            this.extraDeliveryDetails = extraDeliveryDetails;
        }
        
        
    
        
    }
   
    
}



