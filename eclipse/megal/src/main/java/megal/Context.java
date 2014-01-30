package megal;

import static megal.Context.eventBus;
import megal.model.*;
import megal.trivia.Pair;
import megal.logging.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.eventbus.EventBus;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

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
	
	// The declated function applications
	public static Map<String, FunAppDecl> funAppDecls = new HashMap<String, FunAppDecl>();

	// The declared entity types
	public static Map<String,ETypeDecl> eTypeDecls = new HashMap<String,ETypeDecl>();
	
	// The declared relationships
	public static Map<String, RDecl> rDecls = new HashMap<String, RDecl>();

	// The declared relationship types
	public static Map<String,List<Pair<String,String>>> rTypeDecls = new HashMap<String,List<Pair<String,String>>>();
	
	public static EventBus eventBus = new EventBus();
	
	public static Config config = null;

	// Registry of the Entity base type
	static {
		eTypeDecls.put("Entity",null);
		
		// loading default application.conf
		config = ConfigFactory.load();
		config.resolve();
	}
	
	public static void register(EventBusChangeRecorder recorder){
		eventBus.register(recorder);
	}
	
	public static Map<String,EDecl> customEDecls = new HashMap<String,EDecl>(); 
	// The Context class is used as a global variable.
	private Context() { 
		
	} 
}
