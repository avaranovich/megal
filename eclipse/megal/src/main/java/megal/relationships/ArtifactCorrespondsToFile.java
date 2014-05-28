package megal.relationships;

import java.util.List;
import megal.checkers.Fragment;
import megal.checkers.RequestControllerChecker;
import megal.entities.Artifact;
import megal.entities.File;
import megal.model.RTypeDecl;
import megal.relationships.core.correspondsTo;
import megal.trivia.Pair;

public class ArtifactCorrespondsToFile extends correspondsTo<Artifact, File> {

    protected ArtifactCorrespondsToFile(Artifact first, File second, RTypeDecl rTypeDecl) {
        super(first, second, rTypeDecl);
    }

    @Override
    public boolean evaluate() {
        RequestControllerChecker requestChecker = new RequestControllerChecker(getResorucePath("/rails/utils/controller_fragments.json"), getResorucePath("/rails/utils/routes.json"));
        Pair<Boolean, List<Pair<Fragment, Fragment>>> c_pair = requestChecker.check(first.getResource(), second.getResource());
        if (c_pair.first) {
            return true;
        } else {
            return false;
        }
    }

    private String getResorucePath(String relPath) {
        return this.getClass().getResource(relPath).getPath();
    }
}
