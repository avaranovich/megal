package megal.entities;

import megal.model.EDecl;

public class Concept extends Entity {

	public Concept(EDecl edecl) {
		super(edecl);
	}
	
	@Override
	public boolean tryLink(){
		return true;
	}
}
