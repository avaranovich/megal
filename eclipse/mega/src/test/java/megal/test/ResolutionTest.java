package megal.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import megal.Context;
import megal.Tool;
import megal.analysis.Resolution;
import megal.logging.Log;
import megal.model.Model;

import org.junit.Before;
import org.junit.Test;

public class ResolutionTest extends BaseTest {
	
	@Before
	public void setUp() throws Exception {
		//
		// This code needs to be factored/abstracted.
		//
		Model model = new Model();
		Log log = new Log();
		Context.model = model;
		Context.log = log;
		
		String input = getResorucePath("/models/java.megal");
		
		Tool.parse(getResorucePath("prelude.megal"));
		Tool.parse(input);
	}

	@Test
	public void resolutionTest() throws IOException {
		Resolution v =  new Resolution();
		assertEquals(true, v.isAllResolved());
	}
}
