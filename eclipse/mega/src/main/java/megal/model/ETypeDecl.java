package megal.model;

public class ETypeDecl extends Decl {
	private String name;
	private ETypeRef supertype;
	public ETypeDecl(String name, String supertype) {
		this.name = name;
		this.supertype = new ETypeRef(supertype);
	}
	public String getName() { return name; }
	public ETypeRef getSuper() { return supertype; }
}
