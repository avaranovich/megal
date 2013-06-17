package megal.events;

import megal.model.RDecl;

public class NotWellFormedRelationshipDetected extends Event {

	private RDecl rDecl;
	
	public NotWellFormedRelationshipDetected(RDecl rDecl){
		this.rDecl = rDecl;
	}

	@Override
	public String toJson() {
		return null;
	}
		
}
