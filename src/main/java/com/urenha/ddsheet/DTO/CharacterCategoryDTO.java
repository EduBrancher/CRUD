package com.urenha.ddsheet.DTO;

import com.urenha.ddsheet.CharacterCategory;

import java.io.Serializable;

public class CharacterCategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String description;

    public CharacterCategoryDTO(CharacterCategory category) {
        super();
        this.id = category.getId();
        this.name = category.getcategoryName();
        this.description = category.getcategoryDescription();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
