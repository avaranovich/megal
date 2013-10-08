package megal.analysis;

import static megal.Context.log;
import megal.logging.ProblemCode;
import megal.logging.ProblemWithName;
import megal.model.FunAppDecl;
import megal.model.Visitor;
import static megal.Context.*;

public class FunAppDecls extends Visitor {
	public void visit (FunAppDecl decl){
		String name = decl.getName();
		if (funAppDecls.containsKey(name))
			log.problems.add(new ProblemWithName(ProblemCode.doubleDeclaration, name));
		else
			funAppDecls.put(name, decl);
	}
}
