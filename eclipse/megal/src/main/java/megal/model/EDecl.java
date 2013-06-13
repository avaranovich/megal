package megal.model;

import static megal.Context.*;
import megal.entities.Entity;
import megal.events.EntityLookupStarted;
import megal.events.EntityNotFound;

public class EDecl extends Decl {
	private Modifier modifier;
	private EType type;
	private String name;
	private String uqref;
	private String parent;
	private Entity entity;
	public EDecl(Modifier modifier, EType type, String name, String uqref, String parent) {
		this.modifier = modifier;
		this.type = type;
		this.name = name;
		this.uqref = uqref;
		this.parent = parent;
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
}
