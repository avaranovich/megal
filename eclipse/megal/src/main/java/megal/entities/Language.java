package megal.entities;

import static megal.Context.eventBus;

import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import megal.Context;
import megal.events.EntityLinkingFailed;
import megal.events.EntityLinkingStarted;
import megal.events.EntityLinkingSucceeded;
import megal.model.EDecl;

import megal.providers.*;

public class Language extends Set {

    public Language(EDecl edecl) {
        super(edecl);
    }

    /**
     * Uses 101companies discovery service to link to a base entity (language,
     * technology, etc.).
     *
     * @return True if the linking succeeds, False otherwise.
     */
    public boolean tryLink() {

        if (super.tryLink()) {
            return true;
        }

        int code = 404;
        String url = null;
		try {
			url = ((IResourceProvider) (Class.forName(Context.config.getString("provider")).getConstructor().newInstance())).getURL(this.edecl);
		} catch (Exception ex){
			return false;
		}

        eventBus.post(new EntityLinkingStarted(url, edecl));

        try {
            URL u = new URL(url);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            code = huc.getResponseCode();
        } catch (Exception ex) {
            eventBus.post(new EntityLinkingFailed(ex, edecl));
            return false;
        }

        if (code == 200) {
            try {
                URI uri = new URI(url);
                this.link(uri);
                eventBus.post(new EntityLinkingSucceeded(uri, this));
            } catch (URISyntaxException ex) {
                eventBus.post(new EntityLinkingFailed(ex, edecl));
                return false;
            }
            return true;
        }

        return false;
    }
}
