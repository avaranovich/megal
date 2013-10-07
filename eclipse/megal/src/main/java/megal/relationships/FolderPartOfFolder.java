package megal.relationships;

import static megal.Context.eventBus;
import megal.entities.Folder;
import megal.events.RelationshipEvaluationSucceeded;
import megal.model.RTypeDecl;
import megal.relationships.core.partOf;

public class FolderPartOfFolder extends partOf<Folder, Folder> {

    public FolderPartOfFolder(Folder first, Folder second, RTypeDecl rTypeDecl) {
        super(first, second, rTypeDecl);
    }

    @Override
    public boolean evaluate() {
        if ((!first.isLinked()) && (!second.isLinked())) {
            return false;
        }
        boolean firstPartOfSecond;

        if (first.getResource().getPath().contains(second.getResource().getPath())) {
            firstPartOfSecond = true;
        } else {
            firstPartOfSecond = false;
        }

        try {
            eventBus.post(new RelationshipEvaluationSucceeded(first, second, this, firstPartOfSecond));
            return firstPartOfSecond;
        } catch (Exception e) {
            return false;
        }
    }
}
