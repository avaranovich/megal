package megal.model;

/**
 * An eventually resolved reference to an entity type
 */
public class ETypeRef {
	private String name;
	private ETypeDecl decl;
	public ETypeRef(String name) {
		this.name = name;
	}
	public String getName() { return name; }
	public ETypeDecl getDecl() { return decl; }
	public void setDecl(ETypeDecl decl) { this.decl = decl; }
}
