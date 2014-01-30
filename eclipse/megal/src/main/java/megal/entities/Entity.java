package megal.entities;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import megal.Context;
import megal.events.EntityLinkingFailed;
import megal.events.EntityLinkingStarted;
import megal.events.EntityLinkingSucceeded;
import megal.events.ResourceForEntityLinkingIsNotConfigured;
import megal.model.EDecl;
import megal.model.EType;
import megal.model.Modifier;

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
	
	/**
	 * Lookup the config file and try to find a related resource for a given entity.
	 * @return true if the entity is linked, false otherwise.
	 */
	@SuppressWarnings("unchecked")
	public boolean tryLink(){
		// we don't link internal entities
		if (this.edecl.getModifier().equals(Modifier.Intern)){
			try {
				this.link(new URI("http://megal.org/resources/" + this.getName()));
				return true;
			} catch (final URISyntaxException e) {
				return false;
			}
		}
		
		Config conf = Context.config;
		//Config conf = ConfigFactory.load();
		List<Config> rels = (List<Config>) conf.getConfigList("links");
		for(Config c: rels){
			String type = c.getString("type");
			String name = c.getString("name");
			URI uri = null;
			try {
				String res = c.getString("resource");
				// here we handle URLs like ${repos.megal}
				if (res.startsWith("$")){
					 String pattern = "(\\$\\{)(.+)(\\})";
				     // Create a Pattern object
				     Pattern r = Pattern.compile(pattern);

				      // Now create matcher object.
				      Matcher m = r.matcher(res);
				      if (m.find( )) {
				    	  String toReplace = m.group(2);
				    	  //System.out.println(toReplace);
				    	  String[] parts = toReplace.split("\\.");
				    	  Config replaced = conf.getConfig(parts[0]);
				    	  String target = replaced.getString(parts[1]);
						  //System.out.println(target);
				    	  res = res.replace("${"+toReplace+"}", target);
				      }					
				}
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
		
		if (!isLinked()){
			eventBus.post(new ResourceForEntityLinkingIsNotConfigured(this.edecl));
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
	 * @return the piece of config (if any), associated with a given entity.
	 */
	@SuppressWarnings("unchecked")
	public Config getConfig(){
		Config conf = ConfigFactory.load();
		List<Config> rels = (List<Config>) conf.getConfigList("links");
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
