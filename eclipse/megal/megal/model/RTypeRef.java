package megal.model;

/**
 * An eventually resolved reference to a relationship type
 */
public class RTypeRef {
	private String name;
	private RTypeDecl decl;
	public RTypeRef(String name) {
		this.name = name;
	}
	public String getName() { return name; }
	public RTypeDecl getDecl() { return decl; }
	public void setDecl(RTypeDecl decl) { this.decl = decl; }
}
