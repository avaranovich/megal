package megal.analysis;

import megal.model.*;
import megal.logging.*;
import static megal.analysis.Context.*;

/**
 * Collect all ETDecls.
 * Check for uniqueness of names. 
 */
public class ETDecls extends Visitor {
	public ETDecls(Model model, Log log) {
		super(model, log);
	}	
	public void visit(ETDecl decl) {
		String name = decl.getName();
		if (etdecls.containsKey(name))
			log.problems.add(new ProblemWithName(ProblemCode.doubleDefinition, name));
		else
			etdecls.put(name,decl);
	}
}
