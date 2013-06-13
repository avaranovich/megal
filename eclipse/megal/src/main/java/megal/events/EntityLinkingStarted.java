package megal.events;

import megal.model.EDecl;

/*
 * Represents an event, when the framework starts linking the entity to a resource.
 */
public class EntityLinkingStarted extends Event {
	/*
	 * URL which represents a resource and used for linking.
	 */
	private String url;
	
	private EDecl eDecl;
	
	public EntityLinkingStarted(String url, EDecl eDecl){
		this.url   = url;
		this.eDecl = eDecl;
	}
	
	public String toString(){
		return "Trying to link entity to the resource: " + url;
	}
	
	public String toJson() {
		return String.format("{\"event\":\"EntityLinkingStarted\", \"source\": \"%s\", \"resource\":\"%s\"}", eDecl.toSource(), url);
	}
}
