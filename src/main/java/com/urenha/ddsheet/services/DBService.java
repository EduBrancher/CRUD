package com.urenha.ddsheet.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urenha.ddsheet.model.DDCharacter;
import com.urenha.ddsheet.model.CharacterCategory;
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
		CharacterCategory PCcategory = new CharacterCategory(null, "PlayerCharacter", "Owned by a player");
		DDCharacter myCharacter = new DDCharacter("FirstCharacter", "DM", DMcategory);
		DDCharacter myCharacter2 = new DDCharacter("SecondCharacter", "PC1", PCcategory);
		DMcategory.getCharacters().addAll(Arrays.asList(myCharacter));
		PCcategory.getCharacters().addAll(Arrays.asList(myCharacter2));
		
		//persistence is still not able to persist these data. We must inform the database that this is to be done.
		//now we tell them to save
		this.characterCategoryRepo.saveAll(Arrays.asList(DMcategory));
		this.characterCategoryRepo.saveAll(Arrays.asList(PCcategory));
		this.characterRepo.saveAll(Arrays.asList(myCharacter2));
		this.characterRepo.saveAll(Arrays.asList(myCharacter));
	}
	
}
