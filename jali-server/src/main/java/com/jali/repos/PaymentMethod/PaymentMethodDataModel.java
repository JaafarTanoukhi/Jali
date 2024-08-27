package com.jali.repos.PaymentMethod;

import java.io.Serializable;

import com.jali.repos.Order.OrderDataModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payment Method")
public class PaymentMethodDataModel implements Serializable {

    @Id
    String Id;

    String name;


    @ManyToOne
    OrderDataModel order;

    public PaymentMethodDataModel() {
    }

    public PaymentMethodDataModel(String id, String name) {
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
