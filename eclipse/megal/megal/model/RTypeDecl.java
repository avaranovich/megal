package megal.model;

public class RTypeDecl extends Decl {
	private String name;
	private String left;
	private String right;
	public RTypeDecl(String name, String left, String right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
	public String getName() { return name; }
	public String getLeft() { return left; }
	public String getRight() { return right; }
}
