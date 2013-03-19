package megal.analysis;

import megal.model.*;
import megal.logging.*;
import static megal.analysis.Context.*;

/**
 * Go over all EDecls to resolve ETRefs.
 */
public class ETRefs extends Visitor {
	public ETRefs(Model model, Log log) {
		super(model, log);
	}	
	public void visit(EDecl decl) {
//		String name = decl.getType().getName();
//		String EDecl 
//		if (edecls.containsKey(name))
//			log.problems.add(new ProblemWithName(ProblemCode.doubleDefinition, name));
//		else
//			edecls.put(name,decl);
	}
}
