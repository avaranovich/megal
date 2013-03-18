package megal.model;

public class ETDecl extends Decl {
	private String subtype;
	private String supertype;
	public ETDecl(String subtype, String supertype) {
		this.subtype = subtype;
		this.supertype = supertype;
	}
	public String getSubtype() { return subtype; }
	public String getSupertype() { return supertype; }
}
