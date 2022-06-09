package com.urenha.ddsheet.DTO;

import com.urenha.ddsheet.model.CharacterCategory;

import java.io.Serializable;

public class CharacterCategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String categoryName;
    private String categoryDescription;

    public CharacterCategoryDTO(CharacterCategory category) {
        super();
        this.id = category.getId();
        this.categoryName = category.getcategoryName();
        this.categoryDescription = category.getcategoryDescription();
    }

    public CharacterCategoryDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
