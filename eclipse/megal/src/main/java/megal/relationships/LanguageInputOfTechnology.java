package megal.relationships;

import megal.entities.Language;
import megal.entities.Technology;
import megal.model.RTypeDecl;
import megal.relationships.core.inputOf;

public class LanguageInputOfTechnology extends inputOf<Language, Technology> {
	
	public LanguageInputOfTechnology(Language first, Technology second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
	
}
