package megal.model;

/**
 * An eventually resolved reference to a relationship type
 */
public class RTRef {
	private String name;
	private RTDecl decl;
	public RTRef(String name) {
		this.name = name;
	}
	public String getName() { return name; }
	public RTDecl getDecl() { return decl; }
	public void setDecl(RTDecl decl) { this.decl = decl; }
}
