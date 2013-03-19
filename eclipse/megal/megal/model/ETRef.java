package megal.model;

/**
 * An eventually resolved reference to an entity type
 */
public class ETRef {
	private String name;
	private ETDecl decl;
	public ETRef(String name) {
		this.name = name;
	}
	public String getName() { return name; }
	public ETDecl getDecl() { return decl; }
	public void setDecl(ETDecl decl) { this.decl = decl; }
}
