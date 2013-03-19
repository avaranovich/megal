package megal.analysis;

import megal.model.*;
import megal.logging.*;
import static megal.Context.*;

/**
 * Go over all EDecls to resolve ETRefs.
 */
public class ETypeRefs extends Visitor {
	public void visit(EDecl edecl) {
		if (edecl.getType().getDecl() == null) {
			String name = edecl.getType().getName();
			ETypeDecl etdecl = etdecls.get(name);
			if (etdecl == null)
				log.problems.add(new ProblemWithName(
						ProblemCode.undeclaredEntityType, name));
			else
				edecl.getType().setDecl(etdecl);
		}
	}
}
