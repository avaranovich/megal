package megal.events;

import megal.entities.Entity;
import megal.relationships.Relationship;

/*
 * Represents an event, when the framework starts to evaluate a given relationship.
 */
public class RelationshipEvaluationStarted extends RelationshipEvaluation {

	public RelationshipEvaluationStarted(Entity first, Entity second, Relationship rel){
		this.first  = first;
		this.second = second;
		this.rel    = rel;
	}
}
