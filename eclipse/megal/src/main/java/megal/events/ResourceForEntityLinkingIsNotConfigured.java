package megal.events;

import megal.model.EDecl;

/*
 * Represents an event, when the framework tries to link an entity to a certain resource, the configuration file does not contain such linking.
 */
public class ResourceForEntityLinkingIsNotConfigured extends Event {

	@SuppressWarnings("rawtypes")
	private EDecl eDecl;
	
	public ResourceForEntityLinkingIsNotConfigured(@SuppressWarnings("rawtypes") EDecl eDecl){
		this.eDecl = eDecl;
	}
	
	public String toString(){
		return String.format("Resource for entity %s is not configured: ", eDecl.getName());
	}
	
	@Override
	public String toJson() {
		return String.format("{\"event\":\"ResourceForEntityLinkingIsNotConfigured\", \"%s\"}", eDecl.toSource());
	}

}
