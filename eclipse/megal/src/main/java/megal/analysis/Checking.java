package megal.analysis;

import megal.model.RDecl;
import megal.model.Visitor;

/*
 * Checks all the relationships in the megamodel.
 */
public class Checking extends Visitor { 

	public void visit(RDecl decl) {
		decl.getRelationship().evaluate();
	}
}
