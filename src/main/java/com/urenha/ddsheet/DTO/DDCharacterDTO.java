package com.urenha.ddsheet.DTO;

import com.urenha.ddsheet.model.DDCharacter;

import java.io.Serializable;

public class DDCharacterDTO implements Serializable {

    private Integer id;
    private String name;
    private String owner;
    private Integer categoryId;


    public DDCharacterDTO(DDCharacter character) {
        super();
        this.id = character.getId();
        this.name = character.getName();
        this.owner = character.getOwner();
        this.categoryId = character.getCategory().getId();
    }

    public DDCharacterDTO() {
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
