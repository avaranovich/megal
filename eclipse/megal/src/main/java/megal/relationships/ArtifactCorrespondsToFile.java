package megal.relationships;

import megal.entities.Artifact;
import megal.entities.File;
import megal.model.RTypeDecl;
import megal.relationships.core.correspondsTo;

public class ArtifactCorrespondsToFile extends correspondsTo<Artifact, File> {

    protected ArtifactCorrespondsToFile(Artifact first, File second, RTypeDecl rTypeDecl) {
        super(first, second, rTypeDecl);
    }


    @Override
    public boolean evaluate() {
        first.getResource();
        return true;
    }
}