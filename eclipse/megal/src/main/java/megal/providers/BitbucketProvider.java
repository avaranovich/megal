package megal.providers;

import java.net.URI;
import java.util.List;

//TODO: needs to be implemented
public class BitbucketProvider implements IVCSProvider {

    private URI url;

    public BitbucketProvider(URI url){
        this.url = url;

    }

    @Override
    public List<URI> getUris() {
        return null;
    }

    @Override
    public URI getUri() {
        return null;
    }

    @Override
    public String getContent() {
        return null;
    }
}
