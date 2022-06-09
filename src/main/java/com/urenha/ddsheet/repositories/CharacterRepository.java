package com.urenha.ddsheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urenha.ddsheet.model.DDCharacter;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<DDCharacter, Integer>{
    //findByCategoryIdByOrderByName
    //@Query("SELECT somecharacter FROM DDCharacter somecharacter WHERE somecharacter.category.id = :id ORDER BY somecharacter.name")
    //@Param(value = "id")
    List<DDCharacter> findAllByCategoryIdOrderByName(Integer id);
}
