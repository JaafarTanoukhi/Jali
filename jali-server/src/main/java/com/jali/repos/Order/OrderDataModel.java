package com.jali.repos.Orders;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



public class OrdersDataModel implements Serializable  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    Integer fullTotal;
    @Embedded
    Address address;


    
    public OrdersDataModel(){}

    public OrdersDataModel(Integer fullTotal, Address address) {
        this.fullTotal = fullTotal;
        this.address = address;
    }







    @Embeddable
    public class Address {

        String country;
        String city;
        String building;
        String extraDeliveryDetails;


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



