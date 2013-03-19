package megal.model;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;

public class Model {
	private List<Decl> decls;	
	public List<Decl> getDecls() {
		if (decls==null)
			decls = new LinkedList<Decl>();
		return decls;
	}
	
	public void resolve(String entity, Object resource) {
		EDecl e = this.getEDecl(entity);
		boolean inResolved = e.getEntity().resolve();
		//TODO: check if it was successfully resolved
	}
	
	public EDecl getEDecl(String name) {
		// TODO
		return null;
	}
}
