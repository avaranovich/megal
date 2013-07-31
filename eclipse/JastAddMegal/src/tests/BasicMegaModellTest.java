package tests;


import megal.Tool;

import org.junit.Before;
import org.junit.Test;

public class BasicMegaModellTest extends BaseTest {

	@Before
	public void setUp(){
		super.setUp();
	}
	
	@Test
	public void javaTest(){
		Tool.parse(getResorucePath("/models/jastadd.megal"));
		Tool.extend();
		Tool.analyze();
		Tool.link();
		Tool.check();
		
		System.out.println("JSON:" + Tool.getEvents().getJson());
	}
}
