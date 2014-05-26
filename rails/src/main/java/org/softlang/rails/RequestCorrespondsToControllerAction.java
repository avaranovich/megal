package org.softlang.rails;

import megal.checkers.CorrespondanceChecker;
import megal.checkers.Fragment;
import megal.entities.Artifact;
import megal.entities.File;
import megal.trivia.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.softlang.rails.helpers.ResourceHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RequestCorrespondsToControllerAction implements CorrespondanceChecker<String, String> {

    @Override
    public Pair<Boolean, List<Pair<Fragment, Fragment>>> check(String request, String controller) {
        JSONParser jsonParser = new JSONParser();
        ResourceHelper rh = new ResourceHelper();
        try {
            JSONObject request_json = (JSONObject) jsonParser.parse(request);
            JSONArray routes_json = (JSONArray) jsonParser.parse(rh.getResourceContent("/routes.json"));

            // temporary read local fragment file because 101companies/resources is down
            JSONArray controller_fragments = (JSONArray) jsonParser.parse(rh.getResourceContent("/companies_controller_fragments.json"));

            //check if request uri is not contained in application routes
            String request_uri = extractRequestUriFromJson(request_json);
            List<String> route_uris = extractURIsFromRoutes(routes_json);
            if (!checkRequestUriContainedInRoutes(request_uri, route_uris)) {
                return new Pair<Boolean, List<Pair<Fragment, Fragment>>>(false, null);
            }

            return new Pair<Boolean, List<Pair<Fragment, Fragment>>>(true, extractFragments(controller_fragments, request_uri, routes_json));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pair<Fragment, Fragment>> extractFragments(JSONArray controller_fragments, String request_uri, JSONArray routes) throws MalformedURLException {
        //find route object where request uri is contained
        Iterator<JSONObject> iterator = routes.iterator();
        JSONObject corresponding_route = null;
        while (iterator.hasNext()) {
            JSONObject obj = (JSONObject) iterator.next();
            if (((String) obj.get("path")).contains(new URL(request_uri).getPath())) {
                corresponding_route = obj;
                break;
            }
        }
        String action = (String) corresponding_route.get("action");
        String controller = (String) corresponding_route.get("controller");

        //find controller fragment
        Iterator<JSONObject> c_iterator = controller_fragments.iterator();
        while (c_iterator.hasNext()) {
            JSONObject obj = (JSONObject) c_iterator.next();
            if (((String) obj.get("name")).equals(controller)) {
                JSONArray method_fragments = (JSONArray) obj.get("fragments");
                Iterator<JSONObject> method_fragment_iterator = method_fragments.iterator();
                while (method_fragment_iterator.hasNext()) {
                    JSONObject method_fragment = (JSONObject) method_fragment_iterator.next();
                    if (((String) method_fragment.get("name")).equals(action)) {
                        //found fragment
                        Fragment fragment = new Fragment((String) method_fragment.get("name"), "", (String) method_fragment.get("resource"));
                        Fragment controller_fragment = new Fragment((String) corresponding_route.get("name"), (String) corresponding_route.get("verb"), (String) corresponding_route.get("path"));
                        Pair<Fragment, Fragment> fragment_pair = new Pair<Fragment, Fragment>(controller_fragment, fragment);
                        List<Pair<Fragment, Fragment>> correspondance_list = new ArrayList<Pair<Fragment, Fragment>>();
                        correspondance_list.add(fragment_pair);
                        return correspondance_list;
                    }
                }
            }
        }
        return null;
    }

    public boolean checkRequestUriContainedInRoutes(String requestUri, List<String> routeUris) {
        try {
            String path = new URL(requestUri).getPath();
            for (String routeUri : routeUris) {
                if (routeUri.contains(path)) {
                    return true;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return false;
    }

    public String extractRequestUriFromJson(JSONObject json_object) {
        JSONArray interaction_array = (JSONArray) json_object.get("http_interactions");
        Iterator<JSONObject> iterator = interaction_array.iterator();
        String uri = null;
        while (iterator.hasNext()) {
            JSONObject object = (JSONObject) iterator.next();
            uri = (String) ((JSONObject) object.get("request")).get("uri");
        }

        return uri;
    }

    public List<String> extractURIsFromRoutes(JSONArray json_array) {
        Iterator<JSONObject> iterator = json_array.iterator();
        List<String> uris = new ArrayList<String>();
        while (iterator.hasNext()) {
            uris.add((String) ((JSONObject) iterator.next()).get("path"));
        }
        return uris;
    }

}
