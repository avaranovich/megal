package megal.model;

public class RDecl extends Decl {
	private String name;
	private String left;
	private String right;
	public RDecl(String name, String left, String right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
	public String getName() { return name; }
	public String getLeft() { return left; }
	public String getRight() { return right; }
}
