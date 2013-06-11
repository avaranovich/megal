package megal.events;

import megal.model.EDecl;

/*
 * Represents an event, when the framework starts the entity lookup for a given entity declaration.
 */
public class EntityLookupStarted extends Event {
	private EDecl eDecl;
	
	public EntityLookupStarted(EDecl eDecl){
		this.eDecl = eDecl;
	}
	
	public String toString(){
		return "Looking for entity: " + eDecl.getName();
	}

	public String toJson() {
		return String.format("{'event':'EntityLookupStarted', 'entity':'%s'}", eDecl.getName());
	}
}
