package com.jali.repos.Tags;

import java.io.Serializable;

import com.jali.repos.Product.ProductDataModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tag")
public class TagDataModel implements Serializable {


    @EmbeddedId
    private TagId Id;

    public TagDataModel(TagId id){
        this.Id = id;
    }


    @Embeddable
    public static class TagId implements Serializable {

        @ManyToOne
        @JoinColumn(insertable = false, updatable = false)
        private ProductDataModel product;

        private String name;

        public TagId() {
        }

        public TagId(ProductDataModel product, String name) {
            this.product = product;
            this.name = name;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((product == null || product.getId() == null) ? 0 : product.getId().hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
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
            TagId other = (TagId) obj;
            if (product == null) {
                if (other.product != null)
                    return false;
            } else if (!product.getId().equals(other.product.getId()))
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }

        public ProductDataModel getProduct() {
            return product;
        }

        public void setProduct(ProductDataModel product) {
            this.product = product;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
