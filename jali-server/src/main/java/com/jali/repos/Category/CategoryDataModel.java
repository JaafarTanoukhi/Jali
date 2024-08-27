package com.jali.repos.Category;

import java.io.Serializable;

import com.jali.repos.Genre.GenreDataModel;
import com.jali.repos.Product.ProductDataModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.*;

@Entity
@Table(name = "Category")
public class CategoryDataModel implements Serializable {

    @EmbeddedId
    CategoryId Id;
    String name;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    GenreDataModel genre;

    @OneToMany
    ArrayList<ProductDataModel> products;

    public CategoryDataModel() {
    }

    public CategoryDataModel(String name, GenreDataModel genre) {
        this.Id = new CategoryId(null, genre.getId());
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Embeddable
    public static class CategoryId implements Serializable {

        private Long categoryId;
        private String genreId;

        CategoryId() {
        }

        CategoryId(Long categoryId, String genreId) {

            this.categoryId = categoryId;
            this.genreId = genreId;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
            result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
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
            CategoryId other = (CategoryId) obj;
            if (categoryId == null) {
                if (other.categoryId != null)
                    return false;
            } else if (!categoryId.equals(other.categoryId))
                return false;
            if (genreId == null) {
                if (other.genreId != null)
                    return false;
            } else if (!genreId.equals(other.genreId))
                return false;
            return true;
        }

        public Long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        public String getGenreId() {
            return genreId;
        }

        public void setGenreId(String genreId) {
            this.genreId = genreId;
        }

    }

}
