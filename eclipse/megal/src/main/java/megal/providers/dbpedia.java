package megal.providers;

import megal.model.EDecl;

public class dbpedia implements IResourceProvider {

    /**
     * @return Base URL of dbpedia resource, depending on the entity type.
     */
    public String getURL(@SuppressWarnings("rawtypes") final EDecl eDecl){
        String base = "http://dbpedia.org/page/";
        String typeName = eDecl.getType().getName();
        
        // TODO: name does not always represent the actual resource. Think about
        // Rails: Technology
        // the solution is to use Rails ["Ruby on Rails"]: Technology
        if (typeName.equals("Language")) return base + eDecl.getName() + "_(programming_language)";        
        return "";
    }
}
