package megal.relationships;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import com.typesafe.config.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import megal.checkers.Checker;
import megal.entities.File;
import megal.entities.Language;
import megal.events.RelationshipEvaluationSucceeded;
import megal.model.RTypeDecl;

import static megal.Context.*;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;

public class FileElementOfLanguage extends elementOf<File, Language> {

    public FileElementOfLanguage(File first, Language second, RTypeDecl rTypeDecl) {
        super(first, second, rTypeDecl);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean evaluate() {
        // entities on both sides of this relationship have to be linked to resources before		
        if ((!first.isLinked()) && (!second.isLinked())) {
            return false;
        }
        boolean success = false;
        Config c = this.getConfig();

        // all checkers for this relationship
        List<Config> configs = (List<Config>) c.getConfigList("checkers");
        for (Config conf : configs) {
            URI resource;
            try {
                resource = new URI(conf.getString("resource"));
            } catch (URISyntaxException e) {
                return false;
            }

            try {

                for (String s : this.listAllFilesFromDirectory(first.getResource().toURL().toString())) {
                    if (resource.equals(second.getResource())) {
                        String checker = conf.getString("checker");
                        String type = conf.getString("type");

                        if (type.equals("class")) {
                            Class<?> clazz;
                            try {
                                clazz = Class.forName(checker);
                            } catch (ClassNotFoundException e) {
                                return false;
                            }
                            try {
                                Checker<URI> tool = (Checker<URI>) clazz.newInstance();
                                success = success || tool.check(first.getResource());
                                eventBus.post(new RelationshipEvaluationSucceeded(first, second, this, success));

                            } catch (Exception e) {
                                success = false;
                            }
                        }
                    }
                }
            } catch (MalformedURLException ex) {
            }


        }
        return success;
    }

    /**
     * Helper method to retreive all files that are contained in a directory
     * needed for Files+ - Relationship
     *
     * @param gitHubUrl
     * @return
     */
    private List<String> listAllFilesFromDirectory(String gitHubUrl) {
        List<String> files = new ArrayList<String>();
        try {

            RepositoryService repositoryService = new RepositoryService();
            Repository repo = repositoryService.getRepository("avaranovich", "megal");

            URLConnection urlConnection = new URL(repo.getUrl().concat("/contents/").concat(gitHubUrl)).openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            String jsonAsString = "";
            while ((line = rd.readLine()) != null) {
                jsonAsString = line;
            }

            List<StringMap> jsonJavaRootObject = new Gson().fromJson(jsonAsString, List.class);

            //iterate over result
            for (StringMap sm : jsonJavaRootObject) {
                if (sm.get("type").equals("file")) {
                    files.add("https://raw.github.com/avaranovich/megal/master/" + sm.get("path"));
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(FileElementOfLanguage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return files;

    }
}
