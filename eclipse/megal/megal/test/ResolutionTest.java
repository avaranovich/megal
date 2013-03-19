package megal.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import megal.Tool;
import megal.analysis.Resolution;
import megal.logging.Log;
import megal.model.Model;

import org.junit.Before;
import org.junit.Test;

public class ResolutionTest {
	Model model;
	Log log;
	
	@Before
	public void setUp() throws Exception {
		model = new Model();
		log = new Log();
		
		String home = new java.io.File( "." ).getCanonicalPath();
	    System.out.println("Current dir:" + home);
		
		String input = "../../models/java.megal";
		Tool.parse(home+File.separator+"megal"+File.separator+"prelude.megal",model,log);
		Tool.parse(input,model,log);
	}

	@Test
	public void resolutionTest() throws IOException {
		Resolution v =  new Resolution(model, log);
		assertEquals(true, v.isAllResolved());
	}
}
