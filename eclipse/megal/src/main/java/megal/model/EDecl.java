package megal.model;

import static megal.Context.*;

import java.util.LinkedList;
import java.util.List;

import megal.entities.Entity;
import megal.events.EntityLookupStarted;
import megal.events.EntityNotFound;

public class EDecl<T> extends megal.model.Decl {
	private Modifier modifier;
	private EType type;
	private String name;
	private String uqref;
	private String parent;
	private Entity entity;
	private List<Decl> expanded = null;
	public EDecl(Modifier modifier, EType type, String name, String uqref, String parent) {
		//TODO: do we need to consider "external" as a defaul modifier on the grammar level?
		if (modifier == null){
			modifier = Modifier.Extern;
		}
		this.modifier = modifier;
		this.type = type;
		this.name = name;
		this.uqref = uqref;
		this.parent = parent;
		this.expanded = new LinkedList<Decl>();
	}
	public Modifier getModifier() { return modifier; }
	public EType getType() { return type; }
	public String getName() { return name; }
	public String getUref() { return uqref; }
	public String getParent() { return parent; }
	
	public String toSource(){
		return String.format("%s: %s", name, type.getName());
	}
	
	/**
	 * Lookups the entity for the entity declaration.
	 * @return The entity associated with the given entity declaration.
	 */
	public Entity getEntity(){
		if (this.entity != null){
			return this.entity;
		}
		
		eventBus.post(new EntityLookupStarted(this));
		try {
			Object[] params = {this};
			Class[] types = {this.getClass()};
			try {
				this.entity = (Entity)Class.forName("megal.entities." + type.getName()).getConstructor(types).newInstance(params);
			} catch (Exception e) {
				eventBus.post(new EntityNotFound(e, this));
				return null;
			}
		} catch (Exception e) {
			eventBus.post(new EntityNotFound(e, this));
			return null;
		} 
		
		if (this.entity == null){
			//TODO: do we want to handle this in some specific way?
		}
		
		
		return this.entity;
	}

	/*
	 * Expands entity declarations for functions.
	 * For example:
	 * codeGeneration: Function[AntlrNotation -> Java] 
	 * becomes
	 * AntlrNotation domainOf codeGeneration
	 * Java rangeOf codeGeneration
	 */
	public List<? extends Decl> expand(){
		if (expanded.size() > 0){
			return expanded;
		}
		GenericArguments args = this.getType().getGenericArguments();
		if (this.getType().getName().equals("Function") && ((args != null))){
			RDecl domainOf = new RDecl("domainOf", args.getLeft(), this.getName(), null);
			RDecl rangeOf = new RDecl("rangeOf", args.getRight(), this.getName(), null);
			expanded.add(domainOf);
			expanded.add(rangeOf);
		}
		
		return expanded;
	}
}
