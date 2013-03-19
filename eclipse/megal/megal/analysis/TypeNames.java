package megal.analysis;

import megal.logging.*;
import megal.model.*;

/**
 * Check that all referenced entity and relationship types are defined.
 */
public class TypeNames {

	public static boolean check(Model model, Log log) {
		boolean ok = true;
		for (Decl d : model.getDecls()) {
			
			// Check entity type names in EDecls
			if (d instanceof EDecl) {
				EDecl e = (EDecl)d;
				String n = e.getType().getName();
//				if (!etypes.contains(n)) {
					System.out.println("Entity type " + n + " undefined.");
					ok = false;
//				}
			}
			
			// Check relationship type names in RDecls
			else if (d instanceof RDecl) {
				RDecl r = (RDecl)d;
				String n = r.getName();
//				if (!rtypes.contains(n)) {
					System.out.println("Relationship type " + n + " undefined.");
					ok = false;
//				}
			}
		}
		return ok;
	}

}
