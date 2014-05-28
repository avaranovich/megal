package megal.analysis;

import megal.model.*;
import megal.logging.*;
import static megal.Context.*;

/**
 * Collect all EDecls and check for uniqueness of names. 
 */
public class EDecls extends Visitor {
	public void visit(EDecl decl) {
		String name = decl.getName();
		if (eDecls.containsKey(name))
			log.problems.add(new ProblemWithName(ProblemCode.doubleDeclaration, name));
		else
			eDecls.put(name, decl);
	}
}
