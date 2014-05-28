package megal.events;

import megal.model.RDecl;

public class RelationshipNotConfigured extends Event {

    private RDecl rdecl;

    public RelationshipNotConfigured(RDecl rdecl){
        this.rdecl = rdecl;
    }

    @Override
    public String toJson() {
        return rdecl.getAnnotation();
    }
}
