package megal;

import megal.events.EntityLinkingFailed;
import megal.events.EntityLinkingStarted;
import megal.events.EntityLinkingSucceeded;
import megal.events.EntityLookupStarted;
import megal.events.EntityNotFound;
import megal.events.RelationshipEvaluationFailed;
import megal.events.RelationshipEvaluationStarted;
import megal.events.RelationshipEvaluationSucceeded;

import com.google.common.eventbus.Subscribe;

public class EventBusChangeRecorder {
	private void log(Object e){
		System.out.println(e.toString());
	}
	
	@Subscribe public void recordEvent(EntityLinkingStarted e) {
	    log(e);
	}
	
	@Subscribe public void recordEvent(EntityLinkingFailed e){
		log(e);
	}
	
	@Subscribe public void recordEvent(EntityLinkingSucceeded e){
		log(e);
	}
	
	@Subscribe public void recordEvent(EntityLookupStarted e){
		log(e);
	}
	
	@Subscribe public void recordEvent(EntityNotFound e){
		log(e);
	}
	
	@Subscribe public void recordEvent(RelationshipEvaluationStarted e){
		log(e);
	}
	
	@Subscribe public void recordEvent(RelationshipEvaluationFailed e){
		log(e);
	}
	
	@Subscribe public void recordEvent(RelationshipEvaluationSucceeded e){
		log(e);
	}
}
