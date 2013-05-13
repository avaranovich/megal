package megal.events;

import java.net.URI;

import megal.entities.Entity;

/*
 * Represents an event, when the entity was successfully linked to the resource.
 */
public class EntityLinkingSucceeded {
	/*
	 * Resource, to which the given entity is linked.
	 */
	private URI resource;
	
	/*
	 * Entity, which is linked.
	 */
	private Entity entity;
	
	public EntityLinkingSucceeded(URI resource, Entity entity){
		this.resource = resource;
		this.entity   = entity;
	}
	
	public String toString(){
		return "Successfully linked entity " + entity.getName() + " to resource: " + resource.toString();
	}
}
