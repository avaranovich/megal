package megal.entities;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import megal.model.EDecl;
import megal.model.EType;

/**
 * The abstract base class of all entity types (classes).
 * See package megal.entities.
 */
public abstract class Entity {
	private EDecl edecl;
	
	public Object getResource() { return resource; }
	protected void setResource(Object resource) { this.resource = resource; }	
	public boolean isResolved() { return !(resource==null); }
	//TODO: add properies related to the resolution results (e.g. failed because of checker was not found)
	
	private Object resource;

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
	 * Uses 101companies discovery service to resolve a base entity (language, technology, etc.).
	 * @return True if the resolution succeeds, False otherwise.
	 */
	public boolean tryResolve(){
		int code = 404;
		String url = getBaseUrl();

		try {
			URL u = new URL(url);
			HttpURLConnection huc =  (HttpURLConnection) u.openConnection(); 
			huc.setRequestMethod("GET");  
			huc.connect(); 
			code = huc.getResponseCode();	
		}
		catch(Exception _){
			return false;
		}
		
		if (code == 200){
			try {
				this.resolve(new URI(url));
			} catch (URISyntaxException e) {
				return false;
			}
			return true;
		}
		
		return false;
	}
	
	/**
	 * Resolves an entity using a provided resource.
	 * @param resource Resource to use in a resolution process for a given entity.
	 */
	public void resolve(Object resource){
		setResource(resource);
	}
}
