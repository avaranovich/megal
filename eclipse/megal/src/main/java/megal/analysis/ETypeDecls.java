package megal.analysis;

import megal.model.*;
import megal.logging.*;
import static megal.Context.*;

/**
 * Collect all ETypeDecls and check for uniqueness of names. 
 */
public class ETypeDecls extends Visitor {
	public void visit(ETypeDecl decl) {
		String name = decl.getName();
		if (eTypeDecls.containsKey(name))
			log.problems.add(new ProblemWithName(ProblemCode.doubleDeclaration, name));
		else
			eTypeDecls.put(name, decl);
	}
}
