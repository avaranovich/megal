package megal.relationships.core;

import java.util.List;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import megal.Context;
import megal.entities.Entity;
import megal.events.RelationshipEvaluationStarted;
import megal.model.EDecl;
import megal.model.RTypeDecl;

import static megal.Context.*;

/**
 * The abstract base class of all relationship types (classes).
 * See package megal.relationships.
 */
public abstract class Relationship<X extends Entity, Y extends Entity> {
	
	protected X first;
	protected Y second;
	protected RTypeDecl rTypeDecl;
	
	protected String src;
	
	protected Relationship(X first, Y second, RTypeDecl rTypeDecl){
		this.first  	 = first;
		this.second 	 = second;
		this.rTypeDecl   = rTypeDecl;
		this.src		 = "";
	}
	
	public X getLeft(){
		return this.first;
	}
	
	public Y getRight(){
		return this.second;
	}
	
	public RTypeDecl getTypeDecl(){
		return this.rTypeDecl;
	}
	
	public String getSrc(){
		if (this.src.isEmpty()){
			this.getConfig();
		}
		return this.src;
	}
	
	/**
	 * @return the result of testing the relationship to be well-formed
	 * 
	 * In this manner, constraints can be imposed on MegaL.
	 * For instance, the following MegaL could be rejected:
     *   Set X .
     *   Set Y .
	 *   X subsetOf Y .
	 *   Y subsetOf X .
	 * X and Y would need to be the same set (entity).
	 * Arguably, such a MegaL model is not useful.
	 * 
	 * By default, no constraints are imposed.
	 */
	public boolean wellFormed() {
		return true;
	}

	/**
	 * 
	 * @return the result of testing the relationship to hold.
	 * 
	 * By default, we assume that it vacuously holds 
	 * as we may not know how to check the relationship.
	 */
	public boolean evaluate() {
		return true;
	}
	
	/**
	 * @return the piece of config (if any), associated with a given relationship.
	 */
	@SuppressWarnings("unchecked")
	public Config getConfig(){
		/*List<Config> rels = (List<Config>) conf.getConfigList("relationships");
		for (Config rel : rels){
			String name = rel.getString("relationship");
			//System.out.println(this.getClass().getName());
			if (name.equalsIgnoreCase(this.getClass().getName())){
				this.src = rel.getString("src");
				if (rel.hasPath("config"))
					return rel.getConfig("config");	
			}
		}    */
        return ConfigFactory.load(this.getClass().getName()).withFallback(Context.config);
	}
}
