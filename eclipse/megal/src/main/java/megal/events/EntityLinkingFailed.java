package megal.events;

import megal.model.EDecl;

import com.google.gson.Gson;

/*
 * Represents an event when a linking process for a given entity has failed.
 */
public class EntityLinkingFailed extends Event {
	/*
	 * An exception associated with the failure.
	 */
	private Exception ex;
	
	private EDecl eDecl;
	
	public EntityLinkingFailed(Exception ex, EDecl eDecl){
		this.ex    = ex;
		this.eDecl = eDecl;
	}

	public String toJson() {
		return String.format("{\"event\":\"EntityLinkingFailed\", \"%s\", \"error\":\"%s\"}", eDecl.toSource(), ex.getMessage());
	}
}
