package megal.model;

public class EType {
	private String name;
	private ETDecl decl;
	private Cardinality cardinality;
	public enum Cardinality {None,Plus,Star}
	public EType(String name, Cardinality cardinality) {
		this.name = name;
		this.cardinality = cardinality;
	}
	public String getName() { return name; }
	public ETDecl getDecl() { return decl; }
	public Cardinality getCardinality() { return cardinality; }
	public void setDecl(ETDecl decl) { this.decl = decl; }
}
