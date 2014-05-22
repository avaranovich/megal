package megal.providers;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import com.typesafe.config.Config;
import megal.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

//TODO: needs to be implemented
public class BitbucketProvider implements IVCSProvider {

    private URI url;
    private static String BITBUCKET_BASE_URL = "https://api.bitbucket.org/1.0/repositories";

    public BitbucketProvider(URI url) {
        this.url = url;
    }

    /**
     * Helper method to retreive all files that are contained in a directory
     * needed for Files+ - Relationship
     *
     * @param bitbucketURL
     * @return
     */
    private List<URI> listAllFilesFromDirectory(String bitbucketURL) {
        if (!isRepoValid()) {
            return null;
        } else {
            List<URI> files = new ArrayList<URI>();
            Map jsonJavaRootObject = new Gson().fromJson(getContent(), Map.class);
            //check if uri is path to file or to directory
            try {
                if (jsonJavaRootObject.containsKey("files")) {
                    for (StringMap f : (List<StringMap>) jsonJavaRootObject.get("files")) {
                        files.add(new URI(createURLString() + f.get("path")));
                    }
                } else {
                    files.add(new URI(createURLString() + jsonJavaRootObject.get("path")));
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return files;
        }

    }

    private String createURLString() {
        Config conf = Context.config;
        List<Config> rels = (List<Config>) conf.getConfigList("repos");
        String repo = null;
        String username = null;
        String branch = null;

        for (Config c : rels) {
            repo = c.getString("repo");
            username = c.getString("username");
            branch = c.getString("branch");
        }
        return (BITBUCKET_BASE_URL
                + "/" + username
                + "/" + repo
                + "/src/"
                + branch
                + "/");
    }

    private boolean isRepoValid() {
        return authenticateAndReturnConnection() != null ? true : false;
    }

    private URLConnection authenticateAndReturnConnection() {

        Config conf = Context.config;
        List<Config> rels = (List<Config>) conf.getConfigList("repos");
        String password = null;
        String username = null;
        for (Config c : rels) {
            username = c.getString("username");
            if (c.hasPath("password")) {
                password = c.getString("password");
            }
        }

        String authString = username + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        try {
            URL url = new URL(createURLString());
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            return urlConnection;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<URI> getUris() {
        return listAllFilesFromDirectory(url.toString());
    }

    @Override
    public URI getUri() {
        return listAllFilesFromDirectory(url.toString()).get(0);
    }

    @Override
    public String getContent() {
        String content = null;
        try {
            URLConnection urlConnection = authenticateAndReturnConnection();
            InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            content = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return content;
    }
}
