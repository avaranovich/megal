package megal.analysis;

import megal.logging.ProblemCode;
import megal.logging.ProblemWithName;
import megal.model.RDecl;
import megal.model.Visitor;

import static megal.Context.*;

/**
 * Collect all RDecls and check for uniqueness of names. 
 */
public class RDecls extends Visitor {
	public void visit(RDecl decl) {
		String name = decl.getRel().getName();
		if (eDecls.containsKey(name))
			log.problems.add(new ProblemWithName(ProblemCode.doubleDeclaration, name));
		else
			rDecls.put(name,decl);
	}
}
