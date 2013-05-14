package megal.analysis;

import megal.Context;
import megal.model.*;

/**
 * Go over all RDecls to resolve ERefs.
 */
public class ERefs extends Visitor {
	public void visit(RDecl rdecl) {
		EDecl eDecl = Context.eDecls.get(rdecl.getLeft().getName());
		rdecl.getLeft().setDecl(eDecl);
		
		eDecl = Context.eDecls.get(rdecl.getRight().getName());
		rdecl.getRight().setDecl(eDecl);
	}
}
