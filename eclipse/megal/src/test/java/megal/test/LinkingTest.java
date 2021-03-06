package megal.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import megal.Context;
import megal.Tool;
import megal.analysis.Linking;
import megal.logging.Log;
import megal.model.Model;

import org.junit.Before;
import org.junit.Test;

public class LinkingTest extends BaseTest {
	
	@Before
	public void setUp() {
		super.setUp();
		String input = getResorucePath("/models/java.megal");
		Tool.parse(input);
	}

	@Test
	public void resolutionTest() throws IOException {
		Linking v =  new Linking();
		assertEquals(true, v.isAllLinked());
	}
}
