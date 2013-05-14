package megal.relationships;

import megal.entities.Entity;
import megal.model.EDecl;

// TODO
public class conformsTo<X extends Entity, Y extends Entity> extends Relationship<X, Y> {

	protected conformsTo(X first, Y second) {
		super(first, second);
	}

}
