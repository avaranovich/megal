package megal.providers;

import megal.model.EDecl;

public class explorer101 implements IResourceProvider {

	 /**
     * @return Base URL of 101companies explorer, depending on the entity type.
     */
    public String getURL(@SuppressWarnings("rawtypes") final EDecl eDecl){
        String base = "http://101companies.org/resources/";
        String typeName = eDecl.getType().getName();
        
        // TODO: name does not always represent the actual resource. Think about
        // Rails: Technology
        // the solution is to use Rails ["Ruby on Rails"]: Technology
        if (typeName.equals("Language")) return base + "languages/" + eDecl.getName();;
        if (typeName.equals("Technology")) return base + "technologies/" + eDecl.getName();;
        
        return "";
    }

}
