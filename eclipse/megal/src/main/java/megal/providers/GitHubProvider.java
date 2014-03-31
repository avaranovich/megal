package megal.providers;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import megal.relationships.FileElementOfLanguage;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;

/**
 *
 * @author erwinschens
 */
public class GitHubProvider implements IVCSProvider {

	private URI url;

	public GitHubProvider(URI url){
		this.url = url;

	}

	public List<URI> getUris(){
		return listAllFilesFromDirectory(url.toString());
	}

	/**
	 * Helper method to retreive all files that are contained in a directory
	 * needed for Files+ - Relationship
	 *
	 * @param gitHubUrl
	 * @return
	 */
	private List<URI> listAllFilesFromDirectory(String gitHubUrl) {
		List<URI> files = new ArrayList<URI>();
		try {

            //TODO: extract username and repo name from gitHubUrl
			gitHubUrl = gitHubUrl.replaceAll("https://github.com/.*/master/", "");
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
					try {
						files.add(new URI("https://raw.github.com/avaranovich/megal/master/" + sm.get("path")));
					} catch (URISyntaxException ex) {
						Logger.getLogger(GitHubProvider.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}

		} catch (IOException ex) {
			Logger.getLogger(FileElementOfLanguage.class.getName()).log(Level.SEVERE, null, ex);
		}

		return files;

	}

	public URI getUri() {
		List<URI> files = listAllFilesFromDirectory(url.toString());
		return files.get(0);
	}

    @Override
    public String getContent() {
        return null;
    }
}
