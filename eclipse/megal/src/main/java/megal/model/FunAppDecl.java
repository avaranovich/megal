package megal.model;

import java.util.LinkedList;
import java.util.List;

public class FunAppDecl extends Decl {

	private String name;
	private String arg;
	private String res;
	
	private List<Decl> expanded;
	
	public FunAppDecl(String name, String arg, String res){
		this.name = name;
		this.arg = arg;
		this.res = res;
		this.expanded = new LinkedList<Decl>();
	}
	
	public String getName(){ return name; }
	public String getArg() { return arg; }
	public String getRes() { return res; }
	
	/*
	 * Expands function application declaration. For example,
	 * codeGeneration(aGrammar) |-> aParser 
	 * becomes
	 * codeGenerationApp1 : FunctionApplication
	 * codeGenerationApp1 elementOf codeGeneration
	 * aGrammar inputOf codeGenerationApp1
	 * aParser outputOf codeGenerationApp1
	 */
	public List<Decl> expand(){
		if (expanded.size() > 0){
			return expanded;
		}
		
		EType t = new EType("FunctionApplication", null, null);
		//public EDecl(Modifier modifier, EType type, String name, String uqref, String parent)
		EDecl fapp = new EDecl(null, t, "codeGenerationApp1", null, null);
		// 	public RDecl(String name, String left, String right, String annotation)
		RDecl elementOf = new RDecl("elementOf", "codeGenerationApp1", name, null);
		RDecl inputOf = new RDecl("inputOf", arg, "codeGenerationApp1", null);
		RDecl outputOf = new RDecl("outputOf", res, "codeGenerationApp1", null);
		expanded.add(fapp);
		expanded.add(elementOf);
		expanded.add(inputOf);
		expanded.add(outputOf);
		
		return expanded;
	}
}
