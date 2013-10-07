package megal.relationships;

import megal.entities.Artifact;
import megal.entities.Language;
import megal.model.RTypeDecl;
import megal.relationships.core.definitionOf;

public class ArtifactDefinitionOfLanguage extends definitionOf<Artifact, Language> {
	
	public ArtifactDefinitionOfLanguage(Artifact first, Language second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
	
}
