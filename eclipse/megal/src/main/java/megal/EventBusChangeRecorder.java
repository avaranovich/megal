package megal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import megal.events.EntityLinkingFailed;
import megal.events.EntityLinkingStarted;
import megal.events.EntityLinkingSucceeded;
import megal.events.EntityLookupStarted;
import megal.events.EntityNotFound;
import megal.events.Event;
import megal.events.RelationshipEvaluationFailed;
import megal.events.RelationshipEvaluationStarted;
import megal.events.RelationshipEvaluationSucceeded;

import com.google.common.eventbus.Subscribe;

public class EventBusChangeRecorder {
	
	private List<Event> events;
	
	public EventBusChangeRecorder(){
		events = new ArrayList<Event>();
	}
	
	public String getJson(){
		String json = "{'events':[";
		Iterator<Event> iter = events.iterator();
		while(iter.hasNext()){
			Event e = iter.next();
			json += e.toJson();
			if (iter.hasNext()){
				json += ",";
			}
		}
		
		json += "]}";
		return json;
	}
	
	private void log(Event e){
		System.out.println(e.toString());
	}
	
	@Subscribe public void recordEvent(EntityLinkingStarted e) {
	    log(e);
	    events.add(e);
	}
	
	@Subscribe public void recordEvent(EntityLinkingFailed e){
		log(e);
		events.add(e);
	}
	
	@Subscribe public void recordEvent(EntityLinkingSucceeded e){
		log(e);
		events.add(e);
	}
	
	@Subscribe public void recordEvent(EntityLookupStarted e){
		log(e);
		events.add(e);
	}
	
	@Subscribe public void recordEvent(EntityNotFound e){
		log(e);
		events.add(e);
	}
	
	@Subscribe public void recordEvent(RelationshipEvaluationStarted e){
		log(e);
		events.add(e);
	}
	
	@Subscribe public void recordEvent(RelationshipEvaluationFailed e){
		log(e);
		events.add(e);
	}
	
	@Subscribe public void recordEvent(RelationshipEvaluationSucceeded e){
		log(e);
		events.add(e);
	}
}
