package megal.relationships;

import megal.entities.Entity;
import megal.entities.Set;
import megal.events.RelationshipEvaluationFailed;

import static megal.Context.*;

public class elementOf<X extends Entity, Y extends Set> extends Relationship<X, Y> {
	
	public elementOf(X first, Y second){
		super(first, second);
	}
	
	public boolean evaluate() {
		if (!super.evaluate()) {
			eventBus.post(new RelationshipEvaluationFailed(first, second, this));
			return false;
		}
		
		// entities on both sides of this relationship have to be linked to resources before
		if (!first.isLinked()){
			if (!first.tryLink()){
				eventBus.post(new RelationshipEvaluationFailed(first, second, this));
				return false;
			}
		}
		
		if (!second.isLinked()){
			if (!second.tryLink()){
				eventBus.post(new RelationshipEvaluationFailed(first, second, this));
				return false;
			}
		}

		return true;
	}
}