package megal;

import com.google.common.eventbus.Subscribe;

public class EventBusChangeRecorder {
	@Subscribe public void recordCustomerChange(Object e) {
	    //recordChange(e.getChange());
		System.out.println(e.toString());
	  }
}
