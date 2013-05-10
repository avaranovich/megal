package megal.entities;

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
import megal.model.EType;

import static megal.Context.*;

/**
 * The abstract base class of all entity types (classes).
 * See package megal.entities.
 */
public abstract class Entity {
	private EDecl edecl;
	
	public URI getResource() { return resource; }
	protected void setResource(URI resource) { this.resource = resource; }	
	public boolean isLinked() { return !(resource==null); }
	//TODO: add properies related to the resolution results (e.g. failed because of checker was not found)
	
	/*
	 * URI is user, as it can be extended in for any domain-specific notion of resource. 
	 * See http://docs.oracle.com/javase/1.5.0/docs/api/java/net/URI.html
	 */
	private URI resource;

	public Entity(EDecl edecl){
		this.edecl = edecl;
	}
	
	/**
	 * @return An associated entity declaration from the parsing tree.
	 */
	protected EDecl getEdecl() {
		return edecl;
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
		int code = 404;
		String url = getBaseUrl();

		eventBus.post(new EntityLinkingStarted(url));
		
		try {
			URL u = new URL(url);
			HttpURLConnection huc =  (HttpURLConnection) u.openConnection(); 
			huc.setRequestMethod("GET");  
			huc.connect(); 
			code = huc.getResponseCode();	
		}
		catch(Exception ex){
			eventBus.post(new EntityLinkingFailed(ex));
			return false;
		}
		
		if (code == 200){
			try {
				URI uri = new URI(url);
				this.link(uri);
				eventBus.post(new EntityLinkingSucceeded(uri, this));
			} catch (URISyntaxException ex) {
				eventBus.post(new EntityLinkingFailed(ex));
				return false;
			}
			return true;
		}
		
		return false;
	}
	
	/**
	 * Links an entity to a provided resource.
	 * @param resource Resource to use in a linking process for a given entity.
	 */
	public void link(URI resource){
		setResource(resource);
	}
	
	/**
	 * @return the piece of config (if any), associated with a given relationship.
	 */
	@SuppressWarnings("unchecked")
	public Config getConfig(){
		Config conf = ConfigFactory.load();
		List<Config> rels = (List<Config>) conf.getConfigList("linking");
		for (Config rel : rels){
			String name = rel.getString("relationship");
			//System.out.println(this.getClass().getName());
			if (name.equalsIgnoreCase(this.getClass().getName())){
				return rel.getConfig("config");	
			}
		}
		
		return null;
	}
}
