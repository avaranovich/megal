package megal.relationships;

import megal.entities.Artifact;
import megal.entities.Technology;
import megal.model.RTypeDecl;
import megal.relationships.core.inputOf;

public class ArtifactInputOfTechnology extends inputOf<Artifact, Technology> {
	
	public ArtifactInputOfTechnology(Artifact first, Technology second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
	
}
