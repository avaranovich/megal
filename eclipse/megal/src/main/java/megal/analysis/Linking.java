package megal.analysis;

import java.util.List;

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

	public void visit(@SuppressWarnings("rawtypes") EDecl edecl) { 
		boolean isLinked = false;
		
		@SuppressWarnings({ "unchecked" })
		List<RDecl> expanded = edecl.expand();
		if (expanded.size() > 0){
			/*for(@SuppressWarnings("rawtypes") RDecl rd: expanded){
				Entity e = rd.getEntity();
				isLinked &= e.tryLink();
			}*/
			//TODO: propagate a proper event here
		}
		else{
			Entity e = edecl.getEntity();
					
			isLinked &= e.tryLink();
			this.allLinked = isLinked;
		}
	}

	public boolean isAllLinked() {
		return this.allLinked;
	}
}
