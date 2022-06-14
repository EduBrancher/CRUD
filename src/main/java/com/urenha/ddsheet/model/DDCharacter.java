package com.urenha.ddsheet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class DDCharacter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "name is required")
	@Length(min = 1, max = 100, message = "Name must not exceed 100 characters and must not be less than 1 character")
	private String name;
	private String owner;
	private String description;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="category_id")
	private CharacterCategory category;
	/*private List<Attribute> attributes;
	private List<Integer> reflexes;
	private List<Integer> fortitude;
	private Integer will;
	private List<CharacterClass> levels;
	private List<Skill> skills;
	private List<Feat> feats;
	private List<Item> inventory;
	private List<Item> equipment;*/
	
	public DDCharacter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public DDCharacter(String name, String owner, CharacterCategory category) {
		super();
		//pode tirar o id do construtor pq o banco administra
		this.name = name;
		this.owner = owner;
		this.category = category;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CharacterCategory getCategory() {
		return category;
	}

	public void setCategory(CharacterCategory category) {
		this.category = category;
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
		DDCharacter other = (DDCharacter) obj;
		return Objects.equals(id, other.id);
	}
	
}
