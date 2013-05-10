package megal.relationships;

import megal.entities.Entity;
import megal.entities.Set;
import megal.events.RelationshipEvaluationFailed;

import static megal.Context.*;

public class elementOf<X extends Entity, Y extends Set> extends Relationship<X, Y> {
	
	public boolean evaluate(X first, Y second) {
		if (!super.evaluate(first, second)) {
			eventBus.post(new RelationshipEvaluationFailed(first, second, this));
			return false;
		}
		
		if (!first.isLinked() || !second.isLinked()){
			eventBus.post(new RelationshipEvaluationFailed(first, second, this));
			
			// entities on both sides of this relationship have to be linked to resources before
			return false;
		}
		
		return true;
	}
}