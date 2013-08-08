package megal.relationships;

import megal.entities.Artifact;
import megal.entities.Language;
import megal.model.RTypeDecl;

public class ArtifactDefinitionOfLanguage extends definitionOf<Artifact, Language> {
	
	public ArtifactDefinitionOfLanguage(Artifact first, Language second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
	
}
