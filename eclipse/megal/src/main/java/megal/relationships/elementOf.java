package megal.relationships;

import megal.entities.Entity;
import megal.entities.Set;
import megal.events.RelationshipEvaluationFailed;

import static megal.Context.*;

@WeakRef
public class elementOf<X extends Entity, Y extends Set> extends Relationship<X, Y> {
	
	public elementOf(X first, Y second){
		super(first, second);
	}
	
	public boolean evaluate() {
		return super.evaluate();
	}
}