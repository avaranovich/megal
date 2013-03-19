package megal.model;

public class EType {
	private String name;
	private ETypeDecl decl;
	private Cardinality cardinality;
	public enum Cardinality {None,Plus,Star}
	public EType(String name, Cardinality cardinality) {
		this.name = name;
		this.cardinality = cardinality;
	}
	public String getName() { return name; }
	public ETypeDecl getDecl() { return decl; }
	public Cardinality getCardinality() { return cardinality; }
	public void setDecl(ETypeDecl decl) { this.decl = decl; }
}
