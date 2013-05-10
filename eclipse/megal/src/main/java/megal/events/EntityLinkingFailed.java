package megal.events;

/*
 * Represents an event when a linking process for a given entity has failed.
 */
public class EntityLinkingFailed {
	/*
	 * An exception associated with the failure.
	 */
	private Exception ex;
	
	public EntityLinkingFailed(Exception ex){
		this.ex = ex;
	}
}
