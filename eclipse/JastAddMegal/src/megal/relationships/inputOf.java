package megal.relationships;

import megal.entities.Artifact;
import megal.model.RTypeDecl;

@WeakRel
public class inputOf extends Relationship<Artifact, Artifact> {

	protected inputOf(Artifact first, Artifact second, RTypeDecl rTypeDecl) {
		super(first, second, rTypeDecl);
	}
	
}
