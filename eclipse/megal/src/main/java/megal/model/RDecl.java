package megal.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import megal.entities.Entity;
import megal.events.AmbiguousRelationshipDetected;
import megal.events.RelationshipLookupStarted;
import megal.relationships.core.Relationship;

import static megal.Context.*;

public class RDecl extends Decl {
	private RTypeRef rel;
	private ERef left;
	private ERef right;
	private String annotation;
	
	public RDecl(String name, String left, String right, String annotation)  {
		this.rel = new RTypeRef(name);
		this.left = new ERef(left);
		this.right = new ERef(right);
		this.annotation = annotation;
	}
		
	public RTypeRef getRel() { return rel; }
	public ERef getLeft() { return left; }
	public ERef getRight() { return right; }
	public String getAnnotation() { return annotation; }
	
	/**
	 * Lookups the relationship for the relationship declaration.
	 * @return The relationship associated with the given relationship declaration.
	 */
	public Relationship<?,?> getRelationship(){
		eventBus.post(new RelationshipLookupStarted(this));
		
		// get the left entity from the entity declaration, assosicated with the relationship
		Entity first = this.left.getDecl().getEntity();
		
		// get the right entity from the entity declaration, assosicated with the relationship
		Entity second = this.right.getDecl().getEntity();
		
		@SuppressWarnings("rawtypes")
		List<Relationship> candidates = new ArrayList<Relationship>();
		
		// first, we try all custom relationships, which are implemented as plugins. 
		// MegaL runtime provides the list of them
		for(megal.Runtime.Relationship r: runtime.getCustomRels()){
			RTypeDecl rType = r.toRTypeDecl();
			try{
				// we do probing, by relying on Java typesystem to try to create an instance of the relation
				candidates.add(r.newInstance(first, second, rType));
			}
			catch(Exception _){}	
		}
		
		// if we were able to create many relationships for the same set of arguments
		if (candidates.size() > 1){
			
			// we report an event, indicating the abmiguity detection. 
			// Only one type of relationship plugin is allowed in MegaL
			eventBus.post(new AmbiguousRelationshipDetected(this, candidates));
		}
		// if we found exactly one relationship type -- use it
		else if (candidates.size() == 1){
			return candidates.get(0);
		}
		
		// if we didn't find any custom relationships -- trying basic "weak" relationships
		else{
			for(megal.Runtime.Relationship r: runtime.getWeakRels()){
				RTypeDecl rType = r.toRTypeDecl();
				
				// we search for exact name matching EntityLeft > relationship > EntityRight
				if ((rType.getLeft().equals(this.left.getDecl().getType().getName())) && 
						(rType.getRight().equals(this.right.getDecl().getType().getName()))){
						try {
							return r.newInstance(first, second, rType);
						} catch (Exception e) {
							return null;	
					}
				}
			}
		}
		
		return null;
	}
}
