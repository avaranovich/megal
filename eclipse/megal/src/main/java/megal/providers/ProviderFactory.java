package megal.providers;

import java.net.URI;

public class ProviderFactory {
	public static IVCSProvider getForUrl(URI url){
        if (url == null){
            throw new IllegalArgumentException("url should not be null");
        }

		if(url.toString().contains("github")){
			return new GitHubProvider(url);
		}
        else if (url.toString().contains("bitbucket")){
            return new BitbucketProvider(url);
        }
		else {
			return new BasicHttpProvider(url);
		}
	}
}
