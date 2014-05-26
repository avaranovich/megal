package org.softlang.rails.main;

import megal.entities.Artifact;
import megal.model.EDecl;
import org.softlang.rails.RequestCorrespondsToControllerAction;
import org.softlang.rails.helpers.ResourceHelper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RequestCorrespondsToControllerAction c = new RequestCorrespondsToControllerAction();
        ResourceHelper rh = new ResourceHelper();
        String request = rh.getResourceContent("/request.json");
        String routes = rh.getResourceContent("/routes.json");
        c.check(request, routes);
    }


}
