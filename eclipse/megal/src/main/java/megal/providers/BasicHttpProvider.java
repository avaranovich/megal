package megal.providers;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class BasicHttpProvider implements IVCSProvider {

	private URI url;

	public BasicHttpProvider(URI url){
		this.url = url;
	}

	public List<URI> getUris() {
		return Arrays.asList(this.url);
	}
}
