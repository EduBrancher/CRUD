package com.urenha.ddsheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.urenha.ddsheet.DDCharacter;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<DDCharacter, Integer>{

    @Query("SELECT somecharacter FROM DDCharacter somecharacter WHERE somecharacter.category.id = :id ORDER BY somecharacter.name")
    List<DDCharacter> findAllByCategory(@Param(value = "id") Integer id);
}
