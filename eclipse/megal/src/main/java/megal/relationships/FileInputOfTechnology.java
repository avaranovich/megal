package megal.relationships;

import megal.entities.File;
import megal.entities.Technology;
import megal.model.RTypeDecl;

public class FileInputOfTechnology extends inputOf<File, Technology> {
	
	public FileInputOfTechnology(File first, Technology second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
	
}
