package megal.model;

public class RDecl extends Decl {
	private RTypeRef rel;
	private ERef left;
	private ERef right;
	// Specifies whether this is a core relationship or implemented by plugins
	private boolean isCore;
	
	public RDecl(String name, String left, String right)  {
		this(name, left, right, true);
	}
	
	public RDecl(String name, String left, String right, boolean isCore){
		this.rel = new RTypeRef(name);
		this.left = new ERef(left);
		this.right = new ERef(right);
		this.isCore = isCore;
	}
	
	public RTypeRef getRel() { return rel; }
	public ERef getLeft() { return left; }
	public ERef getRight() { return right; }
	
	public boolean isCore() {
		return isCore;
	}
	public void setCore(boolean isCore) {
		this.isCore = isCore;
	}
}
