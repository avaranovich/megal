package megal.events;

import megal.entities.Entity;
import megal.relationships.Relationship;

/*
 * Represents an event, when the framework fails to evaluate a given relationship.
 */
public class RelationshipEvaluationFailed extends RelationshipEvaluation {	
	public RelationshipEvaluationFailed(Entity first, Entity second, Relationship<?, ?> rel){
		this.first  = first;
		this.second = second;
		this.rel    = rel;
	}
}
