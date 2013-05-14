package megal.relationships;

import java.util.List;
import com.typesafe.config.Config;

import megal.checkers.Checker;
import megal.entities.File;
import megal.entities.Language;
import megal.events.RelationshipEvaluationFailed;
import megal.events.RelationshipEvaluationSucceeded;

import static megal.Context.*;

public class FileElementOfLanguage extends elementOf<File, Language> {
	
	public FileElementOfLanguage(File first, Language second){
		super(first, second);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean evaluate() {
		boolean isValid = super.evaluate();
		if (!isValid) return false;
		
		if ((!first.isLinked()) && (!second.isLinked())) {
			eventBus.post(new RelationshipEvaluationFailed(first, second, this));
			return false;
		}
		
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
						eventBus.post(new RelationshipEvaluationFailed(first, second, this));
						return false;
					}
				    try {
						Checker<String> tool = (Checker<String>) clazz.newInstance();
						boolean success = tool.check(first.getResource().getPath());
						eventBus.post(new RelationshipEvaluationSucceeded(first, second, this));
						return success;
					} catch (Exception e) {
						eventBus.post(new RelationshipEvaluationFailed(first, second, this));
						return false;
					}
				}
			}
		}
		
		eventBus.post(new RelationshipEvaluationFailed(first, second, this));
		return false;
	}
}
