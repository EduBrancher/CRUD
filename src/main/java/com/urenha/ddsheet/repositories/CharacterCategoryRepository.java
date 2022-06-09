package com.urenha.ddsheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urenha.ddsheet.model.CharacterCategory;


@Repository
public interface CharacterCategoryRepository extends JpaRepository<CharacterCategory, Integer> {

}
