package megal.providers;

import java.net.URI;

public class ProviderFactory {
	public static IProvider getForUrl(URI url){
		if(url.toString().contains("github")){
			return new GitHubProvider(url);
		}
		return null;
	}
}
