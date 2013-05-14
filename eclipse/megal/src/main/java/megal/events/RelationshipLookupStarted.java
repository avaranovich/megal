package megal.events;

import megal.model.RDecl;

/*
 * Represents an event, when the framework starts the relationship lookup for a given relationship declaration.
 */
public class RelationshipLookupStarted {
	private RDecl rDecl;
	
	public RelationshipLookupStarted(RDecl rDecl){
		this.rDecl = rDecl;
	}
	
	public String toString(){
		return "Looking for relationship: " + rDecl.getLeft().getName() + " " + rDecl.getRel().getName() + " " + rDecl.getRight().getName();
	}
}
