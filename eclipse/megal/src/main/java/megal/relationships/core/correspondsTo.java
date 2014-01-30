package megal.relationships.core;

import megal.entities.Entity;
import megal.model.RTypeDecl;
import megal.relationships.WeakRel;

@WeakRel
public class correspondsTo<X extends Entity, Y extends Entity> extends Relationship<Entity, Entity>  {

	protected correspondsTo(X first, Y second, RTypeDecl rTypeDecl) {
		super(first, second, rTypeDecl);
	}

}
