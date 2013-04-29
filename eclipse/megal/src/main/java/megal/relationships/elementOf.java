package megal.relationships;

import megal.Relationship;
import megal.entities.Entity;
import megal.entities.Set;

public class elementOf<X extends Entity, Y extends Set> extends Relationship<X, Y> {
	public boolean evaluate(X first, Y second) {
		if (!super.evaluate(first, second)) {
			return false;
		}
		
		if (!first.isResolved() || !second.isResolved()){
			// entities on both sides of this relationship have to be resolved before
			return false;
		}
		
		return true;
	}
}