package megal.relationships;

import java.net.URL;

import com.google.gson.JsonObject;
import com.typesafe.config.Config;

import megal.checkers.Checker;
import megal.entities.File;
import megal.entities.Language;

public class FileElementOfLanguage extends elementOf<File, Language> {
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean evaluate(File first, Language second) {
		boolean isValid = super.evaluate(first, second);
		if (!isValid) return false;
		
		if (!first.isResolved()) return false;
		
		Config c = this.getConfig();
		String type = c.getString("type");
		String resource = c.getString("resource");
		String checker = c.getString("checker");
		
		if (type == "class"){
		    Class<?> clazz;
			try {
				clazz = Class.forName(checker);
			} catch (ClassNotFoundException e) {
				return false;
			}
		    try {
				Checker<String> tool = (Checker<String>) clazz.newInstance();
				return tool.check(((URL)first.getResource()).getPath());
			} catch (InstantiationException e) {
				return false;
			} catch (IllegalAccessException e) {
				return false;
			}
		}
		
		return false;
	}
}
