package megal.analysis;

import megal.model.*;

public class Resolution extends Visitor {
	
	private boolean allResolved = false;
		
	@Override
	public void visit(EDecl edecl) { 
		boolean isResolved = edecl.getEntity().tryResolve();
		System.out.println(isResolved);
		allResolved |= isResolved;
	}

	public boolean isAllResolved() {
		return allResolved;
	}
}
