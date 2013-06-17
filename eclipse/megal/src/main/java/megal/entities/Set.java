package megal.entities;

import megal.model.EDecl;

public abstract class Set extends Entity {

	public Set(EDecl edecl) {
		super(edecl);
	}
	
	public abstract boolean tryLink();
}
