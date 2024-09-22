package com.jali.repos.Category;

import java.io.Serializable;
import java.util.List;

import com.jali.repos.Genre.GenreDataModel;
import com.jali.repos.Product.ProductDataModel;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class CategoryDataModel implements Serializable {

    @EmbeddedId
    CategoryId Id;

    String name;

    @OneToMany
    List<ProductDataModel> products;


    public CategoryDataModel() {
    }

    public CategoryDataModel(CategoryId id, String name) {
        this.Id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryId getCategoryId(){
        return this.Id;
    }

    public void setCategoryId(CategoryId id){
        this.Id = id;
    }

    public List<ProductDataModel> getProducts(){
        return this.products;
    }

    @Embeddable
    public static class CategoryId implements Serializable {

        @ManyToOne
        @JoinColumn(name="genre_id", insertable = false, updatable = false)
        private GenreDataModel genre;

        @Column(name = "category_id")
        private Long categoryId;

        // Default constructor (required by JPA)
        public CategoryId() {
        }

        // Parameterized constructor
        public CategoryId(GenreDataModel genre, Long categoryId) {
            this.genre = genre;
            this.categoryId = categoryId;
        }

        // Getters and Setters
        public GenreDataModel getGenre() {
            return genre;
        }

        public void setGenre(GenreDataModel genre) {
            this.genre = genre;
        }

        public Long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        // Override equals and hashCode
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;

            CategoryId other = (CategoryId) obj;
            if (categoryId == null) {
                if (other.categoryId != null)
                    return false;
            } else if (!categoryId.equals(other.categoryId))
                return false;

            if (genre == null) {
                if (other.genre != null)
                    return false;
            } else if (!genre.equals(other.genre))
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
            result = prime * result + ((genre == null) ? 0 : genre.hashCode());
            return result;
        }
    }

}
