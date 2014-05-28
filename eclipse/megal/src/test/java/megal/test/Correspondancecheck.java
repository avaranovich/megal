/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package megal.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import junit.framework.Assert;
import megal.checkers.Fragment;
import megal.checkers.RequestControllerChecker;
import megal.trivia.Pair;
import org.junit.Test;

/**
 *
 * @author erwinschens
 */
public class Correspondancecheck extends BaseTest {
    @Test
    public void testRequestCorrespondanceController() throws URISyntaxException{
        RequestControllerChecker requestChecker = new RequestControllerChecker(getResorucePath("/rails/utils/controller_fragments.json"), getResorucePath("/rails/utils/routes.json"));
        Pair<Boolean, List<Pair<Fragment, Fragment>>> c  = 
                requestChecker.check(new URI("https://api.github.com/repos/ndea/megal-rails/contents/rails_project/test/fixtures/requests"), new URI("https://api.github.com/repos/ndea/megal-rails/contents/rails_project/app/controllers"));
    }
    
}
