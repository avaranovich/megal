package megal.model;

import java.net.URI;
import java.util.List;

public class EDecl extends Decl {
	private Modifier modifier;
	private EType type;
	private List<String> name;
	private Object resource;
	public EDecl(Modifier modifier, EType type, List<String> name) {
		this.modifier = modifier;
		this.type = type;
		this.name = name;
	}
	public Modifier getModifier() { return modifier; }
	public EType getType() { return type; }
	public List<String> getName() { return name; }
	public Object getResource() { return resource; }
	public void setResource(Object resource) { this.resource = resource; }	
	public boolean isResolved() { return !(resource==null); }
}
