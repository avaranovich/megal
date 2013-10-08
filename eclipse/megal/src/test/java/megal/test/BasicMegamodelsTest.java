package megal.test;

import megal.Context;
import megal.Tool;

import org.junit.Before;
import org.junit.Test;

import com.typesafe.config.ConfigFactory;

public class BasicMegamodelsTest extends BaseTest {

    @Before
    public void setUp() {
        super.setUp();
    }

    public void javaTest() {
        Tool.parse(getResorucePath("/models/java.megal"));
        Tool.extend();
        Tool.analyze();
        Tool.link();
        Tool.check();
        
        System.out.println("JSON:" + Tool.getEvents().getJson());
    }

    @Test
    public void rubyTest() {
        Tool.parse(getResorucePath("/models/ruby.megal"));
        Context.config = ConfigFactory.load("configs/ruby.conf").withFallback(Context.config);
        Tool.extend();
        Tool.analyze();
        Tool.link();
        Tool.check();
        
        System.out.println("JSON:" + Tool.getEvents().getJson());
    }
}
