package megal.relationships.core;

import megal.entities.Entity;
import megal.model.RTypeDecl;
import megal.relationships.WeakRel;

@WeakRel
public class definitionOf<X extends Entity, Y extends Entity> extends Relationship<X, Y> {
	protected definitionOf(X first, Y second, RTypeDecl rTypeDecl) {
		super(first, second, rTypeDecl);
	}	
}
