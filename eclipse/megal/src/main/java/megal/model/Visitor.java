package megal.model;

import megal.Context;

/**
 * Reusable walker over MegaL model
 */
public abstract class Visitor {
	public Visitor() {
		this.init();
		this.walk();
	}
	
	protected void init() {}
	
	protected void walk(){
		for (Decl decl : Context.model.getDecls()) {
			if (decl instanceof EDecl) {
				EDecl edecl = (EDecl)decl;
				visit(edecl);
				visit(edecl.getType());
			} else if (decl instanceof RDecl) {
				RDecl rdecl = (RDecl)decl;
				visit(rdecl);
			}  else if (decl instanceof ETypeDecl) {
				ETypeDecl etdecl = (ETypeDecl)decl;
				visit(etdecl);
			}  else if (decl instanceof RTypeDecl) {
				RTypeDecl rtdecl = (RTypeDecl)decl;
				visit(rtdecl);
			}
		}
	}
	public void visit(EDecl edecl){}
	public void visit(EType etype){}
	public void visit(RDecl rdecl){}
	public void visit(ETypeDecl etdecl){}
	public void visit(RTypeDecl rtdecl){}	
}
