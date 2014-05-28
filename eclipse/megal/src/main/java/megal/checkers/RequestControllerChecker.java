package megal.checkers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import megal.trivia.Pair;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RequestControllerChecker implements CorrespondanceChecker<URI, URI> {

    private String fragmentExtractor;
    private String serializedRoutes;

    public RequestControllerChecker(String pathToFragmentExtractor, String pathToSerializedRoutes) {
        this.fragmentExtractor = pathToFragmentExtractor;
        this.serializedRoutes = pathToSerializedRoutes;
    }

    @Override
    public Pair<Boolean, List<Pair<Fragment, Fragment>>> check(URI source, URI target) {
        JSONParser parser = new JSONParser();
        List<Pair<Fragment, Fragment>> correspondanceList = null;
        try {
            JSONArray requestsFolder = (JSONArray) parser.parse(getJsonContentFromURI(source));
            JSONArray controllersFolder = (JSONArray) parser.parse(getJsonContentFromURI(target));
            List<JSONObject> requests = extractAllFiles(requestsFolder);
            List<JSONObject> controllers = extractAllFiles(controllersFolder);
            // get all requests
            for (JSONObject request : requests) {
                String requestURI = getRequestURI(request);
                //check if requestURI matches to a route given
                if (checkRequestURIIsInRoutes(requestURI)) {
                    //locate controller action from request uri with help of routes
                    correspondanceList.add(buildFragmentPair(requestURI));
                }
            }
            if (correspondanceList.size() > 0) {
                return new Pair<Boolean, List<Pair<Fragment, Fragment>>>(true, correspondanceList);
            } else {
                return new Pair<Boolean, List<Pair<Fragment, Fragment>>>(false, correspondanceList);
            }
        } catch (ParseException ex) {
            Logger.getLogger(RequestControllerChecker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(RequestControllerChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<JSONObject> extractAllFiles(JSONArray requestsFolder) throws URISyntaxException, ParseException {
        JSONParser parser = new JSONParser();
        List<JSONObject> requests = new ArrayList<JSONObject>();
        Iterator<JSONObject> iterator = requestsFolder.iterator();
        while (iterator.hasNext()) {
            JSONObject request = iterator.next();
            if (request.get("type").equals("file")) {
                JSONObject r = (JSONObject) parser.parse(getJsonContentFromURI(new URI((String) request.get("git_url"))));
                requests.add(r);
            }
        }
        return requests;
    }

    public String getJsonContentFromURI(URI target) {
        try {
            URL url = target.toURL();
            // get URL content
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;
            String result = "";
            while ((inputLine = br.readLine()) != null) {
                result = result + inputLine;
            }
            return result;
        } catch (MalformedURLException ex) {
            Logger.getLogger(RequestControllerChecker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RequestControllerChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String decode(String s) {
        try {
            byte[] decoded = Base64.decodeBase64(s.getBytes());
            return new String(decoded, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RequestControllerChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getRequestURI(JSONObject request) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONArray rInteractions = ((JSONArray) ((JSONObject) parser.parse(decode((String) request.get("content")))).get("http_interactions"));
        Iterator<JSONObject> iterator = rInteractions.iterator();
        while (iterator.hasNext()) {
            JSONObject interaction = iterator.next();
            return (String) ((JSONObject) interaction.get("request")).get("uri");
        }
        return null;
    }
    
    public boolean checkRequestURIIsInRoutes(String requestUri){
        return true;
    }
    
    public Pair<Fragment, Fragment> buildFragmentPair(String requestUri){
        return null;
    }

}
