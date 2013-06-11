package megal.test;

import megal.Tool;

import org.junit.Before;
import org.junit.Test;

public class BasicMegamodelsTest extends BaseTest {

	@Before
	public void setUp(){
		super.setUp();
	}
	
	@Test
	public void javaTest(){
		Tool.parse(getResorucePath("/models/java.megal"));
		Tool.extend();
		Tool.analyze();
		Tool.link();
		Tool.check();
		
		System.out.println("JSON:" + Tool.getEvents().getJson());
	}
}
