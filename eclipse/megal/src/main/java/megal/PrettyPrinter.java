package megal;

import megal.model.EDecl;
import megal.model.ETypeDecl;
import megal.model.RDecl;
import megal.model.RTypeDecl;
import megal.model.Visitor;


public class PrettyPrinter extends Visitor {

	private String eDeclSource;
	private String rDeclSource;
	private String eTypeDeclSource;
	private String rTypeDeclSource;
	
	public PrettyPrinter() {
		super();
	}
	
	@Override
	protected void init() {
		this.eDeclSource = "";
		this.rDeclSource = "";
		this.eTypeDeclSource = "// Entity types \n";
		this.rTypeDeclSource =  "// Relationship types \n";
	}
	
	public void visit(EDecl edecl) {
		eDeclSource = eDeclSource.concat(edecl.getName() + "\n .");
	}

	public void visit(RDecl rdecl) {
		rDeclSource = rDeclSource.concat(rdecl.getLeft().getName() + " < " + rdecl.getRel().getName() + " " + rdecl.getRight().getName() + " .\n");	
	}
	
	public void visit(ETypeDecl etdecl) {
		try{
			eTypeDeclSource = eTypeDeclSource.concat(etdecl.getName() + " < " + etdecl.getSuper().getName() + " .\n");	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void visit(RTypeDecl rtdecl) {
		try {
			rTypeDeclSource = rTypeDeclSource.concat(rtdecl.getName() + " < " + rtdecl.getLeft() + " * " + rtdecl.getRight() + " .\n");	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String getSource(){
		String s = new StringBuilder().append(this.eTypeDeclSource).append(this.rTypeDeclSource).append(this.rDeclSource).append(this.eDeclSource).append(this.rDeclSource).toString();
		return s.trim();
	}
}
