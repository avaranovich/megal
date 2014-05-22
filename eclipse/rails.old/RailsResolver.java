import java.net.URI;
import java.net.URISyntaxException;

import megal.*;
import megal.model.EDecl;
import megal.model.Model;

public class RailsResolver implements Resolver {

	public boolean tryResolve(Model model) {
		Object app = model.getEDecl("app");
		if (app==null || !(app instanceof URI))
			return false;			
		String parent = app.toString();
		try {
			URI models = new URI(parent+"/models");
			URI views = new URI(parent+"views");
			URI controllers = new URI(parent+"controllers");
			model.resolve("models", models);
			model.resolve("views", views);
			model.resolve("controllers", controllers);
		} catch (URISyntaxException e) {
			return false;
		}
		return true;
	}

}
