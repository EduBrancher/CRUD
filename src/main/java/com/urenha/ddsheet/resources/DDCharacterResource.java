package com.urenha.ddsheet.resources;

import com.urenha.ddsheet.model.CharacterCategory;
import com.urenha.ddsheet.model.DDCharacter;
import com.urenha.ddsheet.DTO.DDCharacterDTO;
import com.urenha.ddsheet.services.CharacterCategoryService;
import com.urenha.ddsheet.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/Characters")
public class DDCharacterResource {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private CharacterCategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DDCharacter> findById(@PathVariable Integer id){
        DDCharacter character = characterService.findById(id);
        return ResponseEntity.ok(character);
    }

    @GetMapping
    public ResponseEntity<List<DDCharacterDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Integer id){
        List<DDCharacter> characterList = characterService.findAll(id);
        List<DDCharacterDTO> DTOList = characterList.stream().map(character -> new DDCharacterDTO(character)).toList();
        return ResponseEntity.ok().body(DTOList);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DDCharacter> update(@PathVariable Integer id, @RequestBody DDCharacter updatedCharacter){
        DDCharacter newCharacter = characterService.update(id, updatedCharacter);
        return ResponseEntity.ok().body(newCharacter);
    }

    @PostMapping
    public ResponseEntity<DDCharacter> create(@RequestBody DDCharacterDTO receivedCharacter){
        Integer cat_id = receivedCharacter.getCategoryId();
        CharacterCategory cat = categoryService.findById(cat_id);
        DDCharacter received = new DDCharacter(receivedCharacter.getName(), receivedCharacter.getOwner(), cat);
        DDCharacter newCharacter = characterService.create(cat.getId(), received);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/Characters/{id}")
                                             .buildAndExpand(newCharacter.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        characterService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
