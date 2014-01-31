package megal.providers;

import java.net.URI;
import java.util.List;

public interface IVCSProvider {
	List<URI> getUris();
	
	URI getUri();
}
