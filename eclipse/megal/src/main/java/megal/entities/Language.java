package megal.entities;

import static megal.Context.eventBus;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import megal.events.EntityLinkingFailed;
import megal.events.EntityLinkingStarted;
import megal.events.EntityLinkingSucceeded;
import megal.model.EDecl;

public class Language extends Set {

	public Language(EDecl edecl) {
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
		
		if (super.tryLink()){
			return true;
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
