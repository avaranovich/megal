package megal.model;

public class EType {
	private String name;
	private ETypeDecl decl;
	private Cardinality cardinality;
	private GenericArguments generic;
	public enum Cardinality {None,Plus,Star}
	public EType(String name, Cardinality cardinality, GenericArguments generic) {
		this.name = name;
		this.cardinality = cardinality;
		this.generic = generic;
	}
	public String getName() { return name; }
	public ETypeDecl getDecl() { return decl; }
	public Cardinality getCardinality() { return cardinality; }
	public Boolean isGeneric() { return generic != null; }
	public GenericArguments getGenericArguments() { return generic; }
	public void setDecl(ETypeDecl decl) { this.decl = decl; }
}
