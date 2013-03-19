package megal;

import megal.model.*;
import megal.logging.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Analyses semi-persist results in this context class.
 */
public final class Context {
	public static Model model = new Model();
	public static Log log = new Log();
	public static Map<String,EDecl> edecls = new HashMap<String,EDecl>();
	public static Map<String,ETypeDecl> etdecls = new HashMap<String,ETypeDecl>();

	static {
		etdecls.put("Entity",null);
	}
	
	private Context() { } 
}
