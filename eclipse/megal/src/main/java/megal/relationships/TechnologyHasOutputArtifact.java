package megal.relationships;

import megal.entities.Artifact;
import megal.entities.Technology;
import megal.model.RTypeDecl;

public class TechnologyHasOutputArtifact extends hasOutput<Technology, Artifact> {
	
	public TechnologyHasOutputArtifact(Technology first, Artifact second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
	
}
