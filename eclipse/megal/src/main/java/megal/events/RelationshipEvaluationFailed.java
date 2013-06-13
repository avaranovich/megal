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
	
	public String toString(){
		return "Failed to evaluate: " + first.getName() + " " + rel.getClass().getName() + " " + second.getName();
	}

	public String toJson() {
		return String.format("{\"event\":\"RelationshipEvaluationFailed\", \"source\": \"%s\", \"left\":\"%s\", \"rel\":\"%s\",\"right\":\"%s\"}",
				this.toMegalSoruce(), first.getName(), rel.getClass().getName(), second.getName());
	}
}
