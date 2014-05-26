import com.typesafe.config.ConfigFactory;
import junit.framework.Assert;
import megal.Context;
import megal.Tool;
import megal.checkers.Fragment;
import megal.trivia.Pair;
import org.junit.Before;
import org.junit.Test;
import org.softlang.rails.RequestCorrespondsToControllerAction;
import org.softlang.rails.helpers.ResourceHelper;

import java.io.File;
import java.util.List;

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

    @Test
    public void testRequestControllerActionCorrespondance() {
        RequestCorrespondsToControllerAction c = new RequestCorrespondsToControllerAction();
        ResourceHelper rh = new ResourceHelper();
        String request = rh.getResourceContent("/request.json");
        String controller = "http://101companies.org/resources/contributions/rubyonrails/app/controllers/companies_controller.rb";
        Pair<Boolean, List<Pair<Fragment, Fragment>>> result = c.check(request, controller);
        Assert.assertEquals(1, result.second.size());
    }
}
