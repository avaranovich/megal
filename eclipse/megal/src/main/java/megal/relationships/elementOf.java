package megal.relationships;

import megal.entities.Entity;
import megal.entities.Set;
import megal.model.EDecl;

public class elementOf<X extends Entity, Y extends Set> extends Relationship<X, Y> {
	
	public boolean evaluate(X first, Y second) {
		if (!super.evaluate(first, second)) {
			return false;
		}
		
		if (!first.isLinked() || !second.isLinked()){
			// entities on both sides of this relationship have to be linked to resources before
			return false;
		}
		
		return true;
	}
}