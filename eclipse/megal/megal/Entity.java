package megal;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import megal.model.EDecl;

public abstract class Entity {
	private EDecl edecl;
	
	public Object getResource() { return resource; }
	public void setResource(Object resource) { this.resource = resource; }	
	public boolean isResolved() { return !(resource==null); }
	private Object resource;

	public Entity(EDecl edecl){
		this.edecl = edecl;
	}
	
	protected EDecl getEdecl() {
		return edecl;
	}
	
	public boolean tryResolve(){
		return false;
	}
	
	/*
	 * Uses 101companies discovery service to resolve base entities (languages, technologies, etc.)
	 */
	public boolean resolve(){
		int code = 404;
		String url = "http://101companies.org/resources/languages/" + this.getEdecl().getName();

		try{
			URL u = new URL(url);
			HttpURLConnection huc =  (HttpURLConnection) u.openConnection(); 
			huc.setRequestMethod("GET");  
			huc.connect(); 
			code = huc.getResponseCode();	
		}
		catch(Exception skip){
			return false;
		}
		
		if (code == 200){
			try {
				this.setResource(new URI(url));
			} catch (URISyntaxException e) {
				return false;
			}
			return true;
		}
		
		return false;
	}
}
