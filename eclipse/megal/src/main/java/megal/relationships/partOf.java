package megal.relationships;

import megal.entities.Entity;
import megal.model.EDecl;

// TODO
public class partOf<X extends Entity, Y extends Entity> extends Relationship<X, Y> {

	protected partOf(X first, Y second) {
		super(first, second);
	}
	
}
