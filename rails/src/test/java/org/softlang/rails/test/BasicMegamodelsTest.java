package org.softlang.rails.test;

import com.typesafe.config.ConfigFactory;
import megal.Context;
import megal.Tool;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class BasicMegamodelsTest extends BaseTest {

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void Foo(){
        assertEquals(true, true);
    }

    @Test
    public void testRailsMegaModel(){
        String resourcePath = getResorucePath("/rails.megal");
        Tool.parse(resourcePath);
        Context.config = ConfigFactory.parseFile(new File(getResorucePath("/rails.conf"))).withFallback(Context.config);
        Tool.extend();
        Tool.analyze();
        Tool.link();
        Tool.check();

        System.out.println("JSON:" + Tool.getEvents().getJson());
    }
}
