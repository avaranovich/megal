package megal.test;

import org.junit.Before;

import megal.Context;
import megal.Tool;
import megal.logging.Log;
import megal.model.Model;

public abstract class BaseTest {
	
	@Before
	public void setUp(){
		//
		// This code needs to be factored/abstracted.
		//
		Model model = new Model();
		Log log = new Log();
		Context.model = model;
		Context.log = log;
		
		Tool.parse(getResorucePath("/prelude.megal"));
	}
	
	String getResorucePath(String relPath){
		return this.getClass().getResource(relPath).getPath();
	}
}
