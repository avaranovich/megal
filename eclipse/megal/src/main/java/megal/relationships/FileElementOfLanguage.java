package megal.relationships;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import com.typesafe.config.Config;

import megal.checkers.Checker;
import megal.entities.File;
import megal.entities.Language;
import megal.events.RelationshipEvaluationFailed;
import megal.events.RelationshipEvaluationSucceeded;
import megal.model.RTypeDecl;

import static megal.Context.*;
import megal.providers.GitHubProvider;
import megal.providers.IVCSProvider;
import megal.providers.ProviderFactory;
import megal.relationships.core.elementOf;

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
                e.printStackTrace();
                return false;
            }
                if (resource.equals(second.getResource())) {
                    String checker = conf.getString("checker");
                    String type = conf.getString("type");

                    if (type.equals("class")) {
                        Class<?> clazz;
                        try {
                            clazz = Class.forName(checker);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                            return false;
                        }
                        try {
                            Checker<URI> tool = (Checker<URI>) clazz.newInstance();
                            IVCSProvider provider = ProviderFactory.getForUrl(first.getResource());
                            if (provider == null){
                                System.out.println("Were not able to get a provider, perhaps the URL for the resource is not configured");
                                return false;
                            }
                            success = tool.check(provider.getUris());
                            eventBus.post(new RelationshipEvaluationSucceeded(first, second, this, success));

                        } catch (Exception e) {
                            e.printStackTrace();
                            success = false;
                        }
                    }
                }
        }
        return success;
    }
}
