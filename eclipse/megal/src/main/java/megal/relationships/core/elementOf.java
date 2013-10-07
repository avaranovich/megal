package megal.relationships.core;

import megal.entities.Entity;
import megal.entities.Set;
import megal.model.RTypeDecl;
import megal.relationships.WeakRel;

import static megal.Context.*;

@WeakRel
public class elementOf<X extends Entity, Y extends Set> extends Relationship<X, Y> {
	
	public elementOf(X first, Y second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
}