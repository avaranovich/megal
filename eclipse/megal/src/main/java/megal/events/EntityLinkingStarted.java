package megal.events;

/*
 * Represents an event, when the framework starts linking the entity to a resource.
 */
public class EntityLinkingStarted {
	/*
	 * URL which represents a resource and used for linking.
	 */
	private String url;
	
	public EntityLinkingStarted(String url){
		this.url = url;
	}
	
	public String toString(){
		return "Trying to link entity to the resource: " + url;
	}
}
