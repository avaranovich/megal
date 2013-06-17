package megal.entities;

import static megal.Context.eventBus;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import megal.events.EntityLinkingFailed;
import megal.events.EntityLinkingStarted;
import megal.events.EntityLinkingSucceeded;
import megal.model.EDecl;

public abstract class Entity101 extends Entity {

	public Entity101(EDecl edecl) {
		super(edecl);
	}
	
	/**
	 * @return Base URL of 101companies discovery servicy, depending on the entity type.
	 */
	private String getBaseUrl(){
		String base = "http://101companies.org/resources/";
		String typeName = getEdecl().getType().getName();
		
		if (typeName.equals("Language")) return base + "languages/" + getEdecl().getName();;
		if (typeName.equals("Technology")) return base + "technologies/" + getEdecl().getName();;
		
		return "";
	}
	
	/**
	 * Uses 101companies discovery service to link to a base entity (language, technology, etc.).
	 * @return True if the linking succeeds, False otherwise.
	 */
	public boolean tryLink(){
		Config conf = ConfigFactory.load();
		List<Config> rels = (List<Config>) conf.getConfigList("linking");
		for(Config c: rels){
			String type = c.getString("type");
			String name = c.getString("name");
			URI uri = null;
			try {
				String res = c.getString("resource");
				uri = new URI(res);
			} catch (URISyntaxException ex) {
				eventBus.post(new EntityLinkingFailed(ex, edecl));
				return false;
			}
			String t = this.edecl.getType().getName();
			String n = this.getName(); 
			if ((type.equals(t)) && (name.equals(n))){
				this.link(uri);
				eventBus.post(new EntityLinkingSucceeded(uri, this));
				return true;
			}
		}
		
		int code = 404;
		String url = getBaseUrl();

		eventBus.post(new EntityLinkingStarted(url, edecl));
		
		try {
			URL u = new URL(url);
			HttpURLConnection huc =  (HttpURLConnection) u.openConnection(); 
			huc.setRequestMethod("GET");  
			huc.connect(); 
			code = huc.getResponseCode();	
		}
		catch(Exception ex){
			eventBus.post(new EntityLinkingFailed(ex, edecl));
			return false;
		}
		
		if (code == 200){
			try {
				URI uri = new URI(url);
				this.link(uri);
				eventBus.post(new EntityLinkingSucceeded(uri, this));
			} catch (URISyntaxException ex) {
				eventBus.post(new EntityLinkingFailed(ex, edecl));
				return false;
			}
			return true;
		}
		
		return false;
	}

}
