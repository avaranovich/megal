package megal.entities;

import megal.model.EDecl;

public class File extends Entity {
	public File(EDecl edecl){
		super(edecl);
	}
	
	@Override
	public boolean tryResolve(){
		return true;
	}
}
