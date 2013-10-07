package megal.relationships;

import megal.entities.Artifact;
import megal.model.RTypeDecl;
import megal.relationships.core.hasOutput;

public class ArtifactHasOutputArtifact extends hasOutput<Artifact, Artifact> {
	
	public ArtifactHasOutputArtifact(Artifact first, Artifact second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
	
}
