package megal.relationships.core;

import megal.entities.Function;
import megal.entities.Language;
import megal.model.RTypeDecl;
import megal.relationships.WeakRel;

@WeakRel
public class rangeOf extends Relationship<Language, Function> {

	protected rangeOf(Language first, Function second, RTypeDecl rTypeDecl) {
		super(first, second, rTypeDecl);
	}

}
