package megal.relationships.custom;

import com.google.gson.JsonObject;

import megal.entities.File;
import megal.entities.Language;
import megal.relationships.elementOf;

public class FileElementOfLanguage extends elementOf<File, Language> {
	
	@Override
	public boolean evaluate(File first, Language second) {
		boolean isValid = super.evaluate(first, second);
		if (!isValid) return false;
		
		JsonObject cfg = this.getConfig();
		//cfg.get
		//Context.model
		
		//http://101companies.org/resources/languages/Java
		Object res = second.getResource(); 
		
		//  -> JavaChecker
		//Tool tool = lookup(res);
		return false;
	}
}
