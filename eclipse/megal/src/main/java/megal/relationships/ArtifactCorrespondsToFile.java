package megal.relationships;

import megal.entities.Artifact;
import megal.entities.Language;
import megal.model.RTypeDecl;
import megal.relationships.core.correspondsTo;

public class ArtifactCorrespondsToFile extends correspondsTo<Artifact, Language> {

    protected ArtifactCorrespondsToFile(Artifact first, Language second, RTypeDecl rTypeDecl) {
        super(first, second, rTypeDecl);
    }


    @Override
    public boolean evaluate() {
        first.getResource();
        return true;
    }
}