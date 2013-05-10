package megal.events;

import megal.entities.Entity;
import megal.relationships.Relationship;

/*
 * Represents an event, when the framework succeeds to evaluate a given relationship.
 */
public class RelationshipEvaluationSucceeded extends RelationshipEvaluation {
	public RelationshipEvaluationSucceeded(Entity first, Entity second, Relationship rel){
		this.first  = first;
		this.second = second;
		this.rel    = rel;
	}
}
