package megal.entities;

import megal.model.EDecl;
import megal.model.EType.Cardinality;

public class File extends Entity {
	public File(EDecl edecl){
		super(edecl);
	}
        
        protected Cardinality getCardinality() {
            return this.edecl.getType().getCardinality();
        }
}
