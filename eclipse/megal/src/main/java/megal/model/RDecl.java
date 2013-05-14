package megal.model;

import java.util.List;
import java.util.Map.Entry;

import megal.Context;
import megal.entities.Entity;
import megal.events.RelationshipLookupStarted;
import megal.relationships.Relationship;
import megal.trivia.Pair;

import static megal.Context.*;

public class RDecl extends Decl {
	private RTypeRef rel;
	private ERef left;
	private ERef right;
	
	public RDecl(String name, String left, String right)  {
		this.rel = new RTypeRef(name);
		this.left = new ERef(left);
		this.right = new ERef(right);
	}
		
	public RTypeRef getRel() { return rel; }
	public ERef getLeft() { return left; }
	public ERef getRight() { return right; }
	
	/**
	 * Lookups the relationship for the relationship declaration.
	 * @return The relationship associated with the given relationship declaration.
	 */
	public Relationship<?,?> getRelationship(){
		eventBus.post(new RelationshipLookupStarted(this));
		
		Entity first = this.left.getDecl().getEntity();
		Entity second = this.right.getDecl().getEntity();
		
		for(megal.Runtime.Relationship r: runtime.getCustomRels()){
			//TODO: implement ambiquity check
			RTypeDecl rType = r.toRTypeDecl();
			if ((rType.getLeft() == this.left.getDecl().getName()) && 
				(rType.getRight() == this.right.getDecl().getName())){
				return r.newInstance(first, second);
			}
		}
		
		for(megal.Runtime.Relationship r: runtime.getCoreRels()){
			RTypeDecl rType = r.toRTypeDecl();
			if ((rType.getLeft() == this.left.getDecl().getName()) && 
				(rType.getRight() == this.right.getDecl().getName())){
				return r.newInstance(first, second);
			}
		}

		return null;
	}
}
