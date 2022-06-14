package com.urenha.ddsheet.model;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class CharacterCategory implements Serializable {
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "categoryName field is required")
	@Length(min = 1, max = 100, message = "Max name length is 100 characters, min name length is 1 character")
	private String categoryName;
	private String categoryDescription;
	
	@OneToMany(mappedBy = "category")
	private List<DDCharacter> characters = new ArrayList<>();

	public CharacterCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CharacterCategory(Integer id, String categoryName, String categoryDescription) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getcategoryName() {
		return categoryName;
	}

	public void setcategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getcategoryDescription() {
		return categoryDescription;
	}

	public void setcategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<DDCharacter> getCharacters() {
		return characters;
	}

	public void setCharacters(List<DDCharacter> characters) {
		this.characters = characters;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterCategory other = (CharacterCategory) obj;
		return Objects.equals(id, other.id);
	}
	
}
