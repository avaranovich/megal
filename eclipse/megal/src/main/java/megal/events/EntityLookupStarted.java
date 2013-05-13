package megal.events;

import megal.model.EDecl;

/*
 * Represents an event, when the framework starts the entity lookup for a given entity declaration.
 */
public class EntityLookupStarted {
	private EDecl eDecl;
	
	public EntityLookupStarted(EDecl eDecl){
		this.eDecl = eDecl;
	}
	
	public String toString(){
		return "Looking for entity: " + eDecl.getName();
	}
}
