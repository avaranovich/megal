package megal.test;

import megal.PrettyPrinter;
import megal.Tool;

import org.junit.Before;
import org.junit.Test;

public class PrettyPrinterTest extends BaseTest {
	
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void prettyPrintShouldProduceTheOriginalSource(){
		Tool.analyze();
		PrettyPrinter pp = new PrettyPrinter();
		//String pprint = getResourceContent("/prelude.pprint.megal");
		System.out.println("Prelude pretty-printed: ");
		System.out.println(pp.getSource());
	}
}
