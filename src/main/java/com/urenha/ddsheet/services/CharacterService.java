package com.urenha.ddsheet.services;

import com.urenha.ddsheet.CharacterCategory;
import com.urenha.ddsheet.DDCharacter;
import com.urenha.ddsheet.exceptions.ObjectNotFoundException;
import com.urenha.ddsheet.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepo;

    @Autowired
    private CharacterCategoryService categoryService;

    public DDCharacter create(Integer id_cat, DDCharacter receivedCharacter) {
        receivedCharacter.setId(null);
        CharacterCategory cat = categoryService.findById(id_cat);
        receivedCharacter.setCategory(cat);
        return characterRepo.save(receivedCharacter);
    }

    public DDCharacter findById(Integer id){
        Optional<DDCharacter> character = characterRepo.findById(id);
        return character.orElseThrow(() -> new ObjectNotFoundException(DDCharacter.class.getName() + id + "not found"));
    }

    public List<DDCharacter> findAll(Integer id){
        categoryService.findById(id);
        List<DDCharacter> characterList = characterRepo.findAllByCategory(id);
        return characterList;
    }

    public DDCharacter update(Integer id, DDCharacter updatedCharacter) {
        DDCharacter savedCharacter = findById(id);
        updateData(savedCharacter, updatedCharacter);
        return characterRepo.save(savedCharacter);
    }

    private void updateData(DDCharacter character, DDCharacter updatedCharacter) {
        character.setName(updatedCharacter.getName());
        character.setOwner(updatedCharacter.getOwner());
        character.setDescription(updatedCharacter.getDescription());
    }

    public void delete(Integer id) {
        DDCharacter toBeDeleted = findById(id);
        characterRepo.delete(toBeDeleted);
    }
}
