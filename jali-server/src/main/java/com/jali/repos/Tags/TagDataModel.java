package com.jali.repos.Tags;

import com.jali.repos.Product.ProductDataModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class TagDataModel implements Serializable {


    @EmbeddedId
    private TagId Id;
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private ProductDataModel product;

    public TagDataModel(String name, ProductDataModel product){
        this.product=product;
        this.Id = new TagId(this.product.getId(),name);
    }


    @Embeddable
    public static class TagId implements Serializable {

        private Long productId;
        private String name;

        public TagId() {
        }

        public TagId(Long productId, String name) {
            this.productId = productId;
            this.name = name;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
            if (productId == null) {
                if (other.productId != null)
                    return false;
            } else if (!productId.equals(other.productId))
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
