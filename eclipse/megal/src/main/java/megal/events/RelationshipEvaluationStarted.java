package megal.events;

import megal.entities.Entity;
import megal.relationships.core.Relationship;

/*
 * Represents an event, when the framework starts to evaluate a given relationship.
 */
public class RelationshipEvaluationStarted extends RelationshipEvaluation {

	public RelationshipEvaluationStarted(Entity first, Entity second, Relationship rel){
		this.first  = first;
		this.second = second;
		this.rel    = rel;
	}
	
	public String toString(){
		return "Started evaluating: " + first.getName() + " " + rel.getClass().getName() + " " + second.getName();
	}

	public String toJson() {
		return String.format("{\"event\":\"RelationshipEvaluationStarted\", \"source\": \"%s\", \"left\":\"%s\", \"rel\":\"%s\", \"right\":\"%s\"}",
				this.toMegalSoruce(), first.getName(), rel.getClass().getName(), second.getName());
	}
}
