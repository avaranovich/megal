package megal.analysis;

import java.util.LinkedList;
import java.util.List;

import megal.logging.*;
import megal.model.*;

/**
 * Aggregate all definitions.
 */
public class Definitions extends Visitor {

//	public Map<String,ETDecl> es = new LinkedList<String>();
//	public List<String> etypes = new LinkedList<String>();
//	public Map<String,Pair<>> rtypes = new LinkedList<String>();
	
	public Definitions(Model model, Log log) {
		super(model, log);
	}
	
	public void visit(EDecl edecl) { 
//		String name = edecl.getType().getName();
////		if (!etypes.contains(n)) {
//			System.out.println("Entity type " + n + " undefined.");
//			ok = false;
////		}		
	}
	public void visit(RDecl rdecl) { 
		
	}
	public void visit(ETDecl etdecl) { 
		
	}
	public void visit(RTDecl rtdecl) { 
		
	}	
	
//	public static boolean check(Model model, Log log) {
//		boolean ok = true;
//		for (Decl d : model.getDecls()) {
//			
//			// Check entity type names in EDecls
//			if (d instanceof EDecl) {
//				EDecl e = (EDecl)d;
//				String n = e.getType().getName();
////				if (!etypes.contains(n)) {
//					System.out.println("Entity type " + n + " undefined.");
//					ok = false;
////				}
//			}
//			
//			// Check relationship type names in RDecls
//			else if (d instanceof RDecl) {
//				RDecl r = (RDecl)d;
//				String n = r.getName();
////				if (!rtypes.contains(n)) {
//					System.out.println("Relationship type " + n + " undefined.");
//					ok = false;
////				}
//			}
//		}
//		return ok;
//	}

}
