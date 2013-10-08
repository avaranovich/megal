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
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<EDecl> expanded = edecl.expand();
		if (expanded.size() > 0){
			for(@SuppressWarnings("rawtypes") EDecl ed: expanded){
				Entity e = ed.getEntity();
				isLinked &= e.tryLink();
			}
		}
		else{
			Entity e = edecl.getEntity();
					
			isLinked &= e.tryLink();
			System.out.println(isLinked);
			if (!isLinked){
				this.allLinked = false;
			}
		}
	}

	public boolean isAllLinked() {
		return this.allLinked;
	}
}
