package megal.relationships;

import java.net.URL;
import java.util.List;

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
		
		if ((!first.isLinked()) && (!second.isLinked())) return false;
		
		Config c = this.getConfig();
				
		// all checkers for this relationship
		List<Config> configs = (List<Config>) c.getAnyRefList("checkers");
		for(Config conf: configs){
			String resource = conf.getString("resource");
			if (resource.equals(second.getResource().toString())){
				String checker  = conf.getString("checker");
				String type = c.getString("type");
				
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
			}
		}
		
		return false;
	}
}
