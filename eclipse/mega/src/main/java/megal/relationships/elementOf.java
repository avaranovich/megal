package megal.relationships;

import com.typesafe.config.Config;

import megal.Entity;
import megal.Relationship;

public class elementOf<X extends Entity, Y extends Entity> extends Relationship<X, Y> {
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