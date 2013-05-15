package megal.analysis;

import megal.model.*;
import megal.entities.Entity;
import megal.logging.Log;

/*
 * Tries to link entities to their resources.
 */
public class Linking extends Visitor {
	
	private boolean allLinked = true;
	
	public Linking(){
		super();
	}

	public void visit(EDecl edecl) { 
		Entity e = edecl.getEntity();
				
		boolean isLinked = e.tryLink();
		System.out.println(isLinked);
		if (!isLinked){
			this.allLinked = false;
		}
	}

	public boolean isAllLinked() {
		return this.allLinked;
	}
}
