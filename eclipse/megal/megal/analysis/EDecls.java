package megal.analysis;

import megal.model.*;
import megal.logging.*;
import static megal.analysis.Context.*;

/**
 * Collect all EDecls.
 * Check for uniqueness of names. 
 */
public class EDecls extends Visitor {
	public EDecls(Model model, Log log) {
		super(model, log);
	}	
	public void visit(EDecl decl) {
		String name = decl.getName();
		if (edecls.containsKey(name))
			log.problems.add(new ProblemWithName(ProblemCode.doubleDefinition, name));
		else
			edecls.put(name,decl);
	}
}
