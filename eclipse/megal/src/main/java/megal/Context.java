package megal;

import megal.model.*;
import megal.trivia.Pair;
import megal.logging.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Analyses semi-persist results in this context class.
 * There is access to the current model and log.
 * There is also access to typical collections over the model.
 */
public final class Context {
	// The model
	public static Model model = new Model();
	
	// The runtime of the MegaL
	public static megal.Runtime runtime = new Runtime();

	// The log
	public static Log log = new Log();

	// The declared entities
	public static Map<String,EDecl> eDecls = new HashMap<String,EDecl>();

	// The declared entity types
	public static Map<String,ETypeDecl> eTypeDecls = new HashMap<String,ETypeDecl>();

	// The declared relationship types
	public static Map<String,List<Pair<String,String>>> rTypeDecls = new HashMap<String,List<Pair<String,String>>>();

	// Registry of the Entity base type
	static {
		eTypeDecls.put("Entity",null);
	}

	public static Map<String,EDecl> customEDecls = new HashMap<String,EDecl>(); 
	// The Context class is used as a global variable.
	private Context() { 
		
	} 
}
