package megal.analysis;

import megal.model.RDecl;
import megal.model.Visitor;

/*
 * Checks all the relationships in the megamodel.
 */
public class Checking extends Visitor { 

	public void visit(RDecl decl) {
		//TODO: check if allowed to invoke, trigger an event otherwise
		decl.getRelationship().evaluate();
	}
}
