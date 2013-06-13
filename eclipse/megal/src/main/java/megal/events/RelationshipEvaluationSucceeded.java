package megal.events;

import megal.entities.Entity;
import megal.relationships.Relationship;

/*
 * Represents an event, when the framework succeeds to evaluate a given relationship.
 */
public class RelationshipEvaluationSucceeded extends RelationshipEvaluation {
	
	/*
	 * Indicates whether the evaluated relationship holds or not.
	 */
	private boolean holds;
	public RelationshipEvaluationSucceeded(Entity first, Entity second, Relationship rel, boolean holds){
		this.first  = first;
		this.second = second;
		this.rel    = rel;
		this.holds  = holds;
	}
	
	public String toString(){
		return "Successfully evaluated: " + first.getName() + " " + rel.getClass().getName() + " " + second.getName() + "; Holds:" + this.holds;
	}

	public String toJson() {
		return String.format("{\"event\":\"RelationshipEvaluationSucceeded\", \"source\":\"%s\", \"left\":\"%s\", \"rel\":\"%s\", \"right\":\"%s\"}",
				this.toMegalSoruce(), first.getName(), rel.getClass().getSimpleName(), second.getName());
	}
}
