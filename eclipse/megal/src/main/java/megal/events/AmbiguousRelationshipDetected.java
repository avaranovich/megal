package megal.events;

import java.util.List;

import megal.model.RDecl;
import megal.relationships.Relationship;

public class AmbiguousRelationshipDetected extends Event {

	private List<Relationship> candidates;
	private RDecl rDecl;
		
	public AmbiguousRelationshipDetected(RDecl rDecl, List<Relationship> candidates){
		this.rDecl      = rDecl;
		this.candidates = candidates;
	}
	
	@Override
	public String toJson() {
		return "";
	}

}
