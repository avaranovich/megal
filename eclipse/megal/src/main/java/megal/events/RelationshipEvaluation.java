package megal.events;

import megal.entities.Entity;
import megal.relationships.Relationship;

public abstract class RelationshipEvaluation extends Event {
	protected Entity first;
	protected Entity second;
	protected Relationship<?,?> rel;
}
