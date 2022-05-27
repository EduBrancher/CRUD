package com.urenha.ddsheet.resources;

import com.urenha.ddsheet.CharacterCategory;
import com.urenha.ddsheet.DTO.CharacterCategoryDTO;
import com.urenha.ddsheet.services.CharacterCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PostMapping
    public ResponseEntity<CharacterCategory> create(@RequestBody CharacterCategory obj){
        obj = categoryService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<CharacterCategoryDTO> update(@PathVariable Integer id, @RequestBody CharacterCategoryDTO updateData){
        CharacterCategory updatedCategory = categoryService.update(id, updateData);
        return ResponseEntity.ok().body(new CharacterCategoryDTO(updatedCategory));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
