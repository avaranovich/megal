package megal.model;

public class ERef {
	private String name;
	private EDecl decl;
	public ERef(String name) {
		this.name = name;
	}
	public String getName() { return name; }
	public EDecl getDecl() { return decl; }
	public void setDecl(EDecl decl) { this.decl = decl; }
}
