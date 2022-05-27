package com.urenha.ddsheet.resources;

import com.urenha.ddsheet.CharacterCategory;
import com.urenha.ddsheet.DTO.CharacterCategoryDTO;
import com.urenha.ddsheet.services.CharacterCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/CharacterCategories")
public class CharacterCategoryResource {

    @Autowired
    CharacterCategoryService categoryService;

    @GetMapping(value="/{id}")
    public ResponseEntity<CharacterCategory> findById(@PathVariable Integer id){
        CharacterCategory obj = categoryService.findById(id);
        return(ResponseEntity.ok().body(obj)) ;
    }
    @GetMapping
    public ResponseEntity<List<CharacterCategoryDTO>> findall(){
        List<CharacterCategory> lista = categoryService.findAll();
        List<CharacterCategoryDTO> listDTO = lista.stream().map(
                obj -> new CharacterCategoryDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
