package megal.relationships;

import megal.entities.Entity;
import megal.model.EDecl;
import megal.model.RTypeDecl;

@WeakRef
public class conformsTo<X extends Entity, Y extends Entity> extends Relationship<X, Y> {

	protected conformsTo(X first, Y second, RTypeDecl rTypeDecl) {
		super(first, second, rTypeDecl);
	}
}
