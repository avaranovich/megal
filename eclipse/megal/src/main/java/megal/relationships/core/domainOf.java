package megal.relationships.core;

import megal.entities.Function;
import megal.entities.Language;
import megal.model.RTypeDecl;
import megal.relationships.WeakRel;

@WeakRel
public class domainOf extends Relationship<Language, Function> {

	protected domainOf(Language first, Function second, RTypeDecl rTypeDecl) {
		super(first, second, rTypeDecl);
	}

}
