package megal.model;

public class RTypeDecl extends Decl {
	private String name;
	private String left;
	private String right;
	
	// Specifies whether this is a core relationship or implemented by plugins
	private boolean isCore;
	
	public RTypeDecl(String name, String left, String right, boolean isCore) {
		this.name = name;
		this.left = left;
		this.right = right;
		this.isCore = isCore;
	}
	
	public RTypeDecl(String name, String left, String right) {
		this(name, left, right, true);
	}
	
	public String getName() { return name; }
	public String getLeft() { return left; }
	public String getRight() { return right; }

	public boolean isCore() {
		return isCore;
	}
}
