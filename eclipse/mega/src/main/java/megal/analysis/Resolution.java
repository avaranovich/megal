package megal.analysis;

import megal.model.*;
import megal.logging.Log;

public class Resolution extends Visitor {
	
	private boolean allResolved = true;
	
	public Resolution(){
		super();
	}

	public void visit(EDecl edecl) { 
		boolean isResolved = edecl.getEntity().tryResolve();
		System.out.println(isResolved);
		if (!isResolved){
			this.allResolved = false;
		}
	}

	public boolean isAllResolved() {
		return allResolved;
	}
}
