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
	protected EDecl edecl;
	
	public URI getResource() { return resource; }
	protected void setResource(URI resource) { this.resource = resource; }	
	public boolean isLinked() { return !(resource == null); }
	
	/*
	 * URI is user, as it can be extended in for any domain-specific notion of resource. 
	 * See http://docs.oracle.com/javase/1.5.0/docs/api/java/net/URI.html
	 */
	private URI resource;

	public Entity(EDecl edecl){
		this.edecl = edecl;
	}
	
	public String getName(){
		return this.edecl.getName();
	}
	
	/**
	 * @return An associated entity declaration from the parsing tree.
	 */
	public EDecl getEdecl() {
		return edecl;
	}
	
	public abstract boolean tryLink();
	
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
