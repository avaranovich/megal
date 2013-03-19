package megal.model;

public class ETDecl extends Decl {
	private String name;
	private ETRef supertype;
	public ETDecl(String name, String supertype) {
		this.name = name;
		this.supertype = new ETRef(supertype);
	}
	public String getName() { return name; }
	public ETRef getSuper() { return supertype; }
}
