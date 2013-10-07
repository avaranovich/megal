package megal.relationships;

import megal.entities.Artifact;
import megal.entities.Technology;
import megal.model.RTypeDecl;
import megal.relationships.core.hasOutput;

public class TechnologyHasOutputArtifact extends hasOutput<Technology, Artifact> {
	
	public TechnologyHasOutputArtifact(Technology first, Artifact second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
	
}
