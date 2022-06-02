package com.urenha.ddsheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urenha.ddsheet.DDCharacter;

@Repository
public interface CharacterRepository extends JpaRepository<DDCharacter, Integer>{

}
