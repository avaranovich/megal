import com.typesafe.config.ConfigFactory;
import megal.Context;
import megal.Tool;
import megal.checkers.RequestControllerChecker;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class CorrespondanceTest extends BaseTest {
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testRailsMegaModel() {
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
