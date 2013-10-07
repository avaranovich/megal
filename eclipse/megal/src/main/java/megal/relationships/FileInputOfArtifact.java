package megal.relationships;

import megal.entities.Artifact;
import megal.entities.File;
import megal.model.RTypeDecl;
import megal.relationships.core.inputOf;

public class FileInputOfArtifact extends inputOf<File, Artifact> {
	
	public FileInputOfArtifact(File first, Artifact second, RTypeDecl rTypeDecl){
		super(first, second, rTypeDecl);
	}
	
}
