package megal.entities;

import megal.model.EDecl;

public class Folder extends Entity {

	public Folder(EDecl edecl) {
		super(edecl);
	}

	@Override
	public boolean tryResolve() {
		// Check whether this entity is a part of another folder in the model.
		// If so, check whether the parent folder is resolved to a URI.
		// If so, interpret entity's name as subfolder name relative to parent folder.
		// Check also whether this entity is physically part of the parent folder.
		return false;
	}
	
	@Override
	public boolean resolve(){
		//TODO: add resolution code
		return false;
	}  

}
