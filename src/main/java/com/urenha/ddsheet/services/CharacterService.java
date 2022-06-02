package com.urenha.ddsheet.services;

import com.urenha.ddsheet.DDCharacter;
import com.urenha.ddsheet.exceptions.ObjectNotFoundException;
import com.urenha.ddsheet.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepo;

    public DDCharacter findById(Integer id){
        Optional<DDCharacter> character = characterRepo.findById(id);
        return character.orElseThrow(() -> new ObjectNotFoundException(DDCharacter.class.getName() + id + "not found"));
    }
}
