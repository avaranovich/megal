package megal.test;

import static org.junit.Assert.*;
import java.io.IOException;

import megal.Config;
import megal.ConfigRegistry;
import org.junit.Test;

public class ConfigTest {
	
	@Test
	public void readFromFileTest() throws IOException {
		ConfigRegistry r = ConfigRegistry.fromFile("foo.config");
		assertNotNull(r);
	}
}
