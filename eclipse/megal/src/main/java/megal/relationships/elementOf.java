package megal.relationships;

import megal.entities.Entity;
import megal.entities.Set;
import megal.events.RelationshipEvaluationFailed;
import megal.model.RTypeDecl;

import static megal.Context.*;

@WeakRel
public class elementOf<X extends Entity, Y extends Set> extends Relationship<X, Y> {
	
	public elementOf(X first, Y second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
}