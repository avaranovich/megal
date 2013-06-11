package megal.events;

import com.google.gson.Gson;

/*
 * Represents an event when a linking process for a given entity has failed.
 */
public class EntityLinkingFailed extends Event {
	/*
	 * An exception associated with the failure.
	 */
	private Exception ex;
	
	public EntityLinkingFailed(Exception ex){
		this.ex = ex;
	}

	public String toString(){
		return "Linking failed: " + ex.getMessage();
	}

	public String toJson() {
		return String.format("{'event':'EntityLinkingFailed', 'error':'%s'}", ex.getMessage());
	}
}
