package megal.entities;

import megal.model.EDecl;

public class File extends Entity101 {
	public File(EDecl edecl){
		super(edecl);
	}
	
	@Override
	public boolean tryLink(){
		if (super.tryLink() == true)
			return true;
		
		return false;
	}
}
