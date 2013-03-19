package megal;

import megal.model.EDecl;

public class Relationship {
	/**
	 * @return the result of testing the relationship to be well-formed
	 * 
	 * In this manner, constraints can be imposed on MegaL.
	 * For instance, the following MegaL could be rejected:
     *   Set X .
     *   Set Y .
	 *   X subsetOf Y .
	 *   Y subsetOf X .
	 * X and Y would need to be the same set (entity).
	 * Arguably, such a MegaL model is not useful.
	 * 
	 * By default, no constraints are imposed.
	 */
	public boolean wellFormed(EDecl first, EDecl second) {
		return true;
	}

	/**
	 * 
	 * @return the result of testing the relationship to hold.
	 * 
	 * By default, we assume that it vacuously holds 
	 * as we may not know how to check the relationship.
	 */
	public boolean evaluate(EDecl first, EDecl second) {
		//http://101companies.org/resources/languages/Java
		//String res = second.getEntity().getResource(); 
		
		//  -> JavaChecker
		//Tool tool = lookup(res);
		return true;
	}
}
