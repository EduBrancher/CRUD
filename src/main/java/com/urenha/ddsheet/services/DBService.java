package com.urenha.ddsheet.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urenha.ddsheet.DDCharacter;
import com.urenha.ddsheet.CharacterCategory;
import com.urenha.ddsheet.repositories.CharacterCategoryRepository;
import com.urenha.ddsheet.repositories.CharacterRepository;

@Service
public class DBService {
	
	@Autowired
	private CharacterCategoryRepository characterCategoryRepo;
	
	@Autowired
	private CharacterRepository characterRepo;
	
	public void instantiateDB() {
		CharacterCategory DMcategory = new CharacterCategory(null, "DMCharacter", "Managed by the DM");
		DDCharacter myCharacter = new DDCharacter(null, "FirstCharacter", "DM", DMcategory);
		DMcategory.getCharacters().addAll(Arrays.asList(myCharacter));
		
		//persistence is still not able to persist these data. We must inform the database that this is to be done.
		//now we tell them to save
		this.characterCategoryRepo.saveAll(Arrays.asList(DMcategory));
		this.characterRepo.saveAll(Arrays.asList(myCharacter));
	}
	
}
