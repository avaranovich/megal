package megal.model;

public class RDecl extends Decl {
	private RTypeRef rel;
	private ERef left;
	private ERef right;
	public RDecl(String name, String left, String right) {
		this.rel = new RTypeRef(name);
		this.left = new ERef(left);
		this.right = new ERef(right);
	}
	public RTypeRef getRel() { return rel; }
	public ERef getLeft() { return left; }
	public ERef getRight() { return right; }
}
