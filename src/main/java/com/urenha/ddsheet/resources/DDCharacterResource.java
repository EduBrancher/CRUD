package com.urenha.ddsheet.resources;

import com.urenha.ddsheet.CharacterCategory;
import com.urenha.ddsheet.DDCharacter;
import com.urenha.ddsheet.DTO.DDCharacterDTO;
import com.urenha.ddsheet.repositories.CharacterRepository;
import com.urenha.ddsheet.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Characters")
public class DDCharacterResource {

    @Autowired
    private CharacterService characterService;

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


}
