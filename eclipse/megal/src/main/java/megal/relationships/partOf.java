package megal.relationships;

import megal.entities.Entity;
import megal.model.EDecl;
import megal.model.RTypeDecl;

@WeakRel
public class partOf<X extends Entity, Y extends Entity> extends Relationship<X, Y> {

	protected partOf(X first, Y second, RTypeDecl rTypeDecl) {
		super(first, second, rTypeDecl);
	}
	
}
