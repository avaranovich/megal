package megal.events;

import megal.entities.Entity;
import megal.relationships.core.Relationship;

public abstract class RelationshipEvaluation extends Event {
	protected Entity first;
	protected Entity second;
	protected Relationship<?,?> rel;
	
	protected String toMegalSoruce(){
		return String.format("%s %s: %s", this.first.getName(), this.rel.getTypeDecl().getName(), this.second.getName());
	}
}
