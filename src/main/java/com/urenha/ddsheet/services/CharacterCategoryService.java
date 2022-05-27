package com.urenha.ddsheet.services;

import com.urenha.ddsheet.CharacterCategory;
import com.urenha.ddsheet.exceptions.ObjectNotFoundException;
import com.urenha.ddsheet.repositories.CharacterCategoryRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterCategoryService {

    @Autowired
    CharacterCategoryRepository categoryRepo;

    public CharacterCategory findById(Integer id){
        Optional<CharacterCategory> obj = categoryRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado: " + id + "Tipo: " + CharacterCategory.class.getName()));
    }
    public List<CharacterCategory> findAll(){
        return categoryRepo.findAll();
    }
}
