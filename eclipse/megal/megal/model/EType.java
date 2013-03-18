package megal.model;

public class EType {
	private String name;
	private Cardinality cardinality;
	public enum Cardinality {None,Plus,Star}
	public EType(String name, Cardinality cardinality) {
		this.name = name;
		this.cardinality = cardinality;
	}
	public String getName() { return name; }
	public Cardinality getCardinality() { return cardinality; }
}
