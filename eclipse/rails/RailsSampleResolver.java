import java.net.URI;
import java.net.URISyntaxException;

import megal.*;
import megal.model.EDecl;
import megal.model.Model;

public class RailsSampleResolver extends RailsResolver implements Resolver {

	public boolean tryResolve(Model model) {
		try {
			model.resolve(
					"app", 
					new URI("http://101companies.org/resources/contributions/rails/app"));
		} catch (URISyntaxException e) {
			return false;
		}
		return super.tryResolve(model);
	}
}
