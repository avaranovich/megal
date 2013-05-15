package megal.relationships;

import java.net.URI;
import java.net.URISyntaxException;
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
		List<Config> configs = (List<Config>) c.getConfigList("checkers");
		for(Config conf: configs){
			URI resource;
			try {
				resource = new URI(conf.getString("resource"));
			} catch (URISyntaxException e) {
				eventBus.post(new RelationshipEvaluationFailed(first, second, this));
				return false;
			}
			if (resource.equals(second.getResource())){
				String checker  = conf.getString("checker");
				String type = conf.getString("type");
				
				if (type.equals("class")){
				    Class<?> clazz;
					try {
						clazz = Class.forName(checker);
					} catch (ClassNotFoundException e) {
						eventBus.post(new RelationshipEvaluationFailed(first, second, this));
						return false;
					}
				    try {
						Checker<URI> tool = (Checker<URI>) clazz.newInstance();
						boolean success = tool.check(first.getResource());
						eventBus.post(new RelationshipEvaluationSucceeded(first, second, this, success));
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
