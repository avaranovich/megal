package megal.checkers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    private String controllerExtractedFragments;
    private String serializedRoutes;

    public RequestControllerChecker(String pathToControllerFragment, String pathToSerializedRoutes) {
        this.controllerExtractedFragments = pathToControllerFragment;
        this.serializedRoutes = pathToSerializedRoutes;
    }

    @Override
    public Pair<Boolean, List<Pair<Fragment, Fragment>>> check(URI source, URI target) {
        JSONParser parser = new JSONParser();
        List<Pair<Fragment, Fragment>> correspondanceList = new ArrayList<Pair<Fragment, Fragment>>();
        try {
            JSONArray requestsFolder = (JSONArray) parser.parse(getJsonContentFromURI(source));
            JSONArray controllersFolder = (JSONArray) parser.parse(getJsonContentFromURI(target));
            List<JSONObject> requests = extractAllFiles(requestsFolder);
            List<JSONObject> controllers = extractAllFiles(controllersFolder);
            // get all requests
            for (JSONObject request : requests) {
                String requestURI = getRequestURI(request);
                //locate controller action from request uri with help of routes
                Pair<Fragment, Fragment> correspondancePair = findCorrespondance(requestURI);
                if (correspondancePair != null) {
                    correspondanceList.add(correspondancePair);
                }

            }
            if (correspondanceList.size() > 0) {
                return new Pair<Boolean, List<Pair<Fragment, Fragment>>>(true, correspondanceList);
            } else {
                return new Pair<Boolean, List<Pair<Fragment, Fragment>>>(false, null);
            }
        } catch (ParseException ex) {
            Logger.getLogger(RequestControllerChecker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(RequestControllerChecker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
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

    public Pair<Fragment, Fragment> findCorrespondance(String requestUri) throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray routes = (JSONArray) parser.parse(new FileReader(serializedRoutes));
        JSONArray controllerFragments = (JSONArray) parser.parse(new FileReader(controllerExtractedFragments));

        //iterate over all routes and see if request uri is contained in it
        Iterator<JSONObject> routesIterator = routes.iterator();
        while (routesIterator.hasNext()) {
            JSONObject route = routesIterator.next();
            if (requestUri.contains((String) route.get("path"))) {
                String controller = (String) route.get("controller");
                String action = (String) route.get("action");
                //search in controller fragments for this controller with this action
                Iterator<JSONObject> controllerIterator = controllerFragments.iterator();
                while (controllerIterator.hasNext()) {
                    JSONObject c = controllerIterator.next();
                    if (((String) c.get("name")).equals(controller) && ((String) c.get("classifier")).equals("class")) {
                        JSONArray methods = (JSONArray) c.get("fragments");
                        Iterator<JSONObject> methodIterator = methods.iterator();
                        while (methodIterator.hasNext()) {
                            JSONObject m = methodIterator.next();
                            if (((String) m.get("name")).equals(action) && ((String) m.get("classifier")).equals("method")) {
                                //correspondance found
                                Fragment requestFragment = new Fragment("request", "", requestUri);
                                Fragment controllerFragment = new Fragment("method", (String) m.get("source"), (String) m.get("name"));
                                return new Pair<Fragment, Fragment>(requestFragment, controllerFragment);
                            }
                        }
                    }
                }

            }
        }
        return null;
    }

    public Pair<Fragment, Fragment> buildFragmentPair(String requestUri) {
        return null;
    }

}
