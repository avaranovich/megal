package megal.analysis;

import megal.model.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Analyses semi-persist results in this context class.
 */
public class Context {
	public static Map<String,EDecl> edecls = new HashMap<String,EDecl>();
	public static Map<String,ETDecl> etdecls = new HashMap<String,ETDecl>();

	static {
		etdecls.put("Entity",null);
	}
}
