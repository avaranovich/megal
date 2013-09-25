package megal.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.List;

import megal.entities.File;
import megal.entities.Language;
import megal.model.RTypeDecl;
import megal.relationships.FileElementOfLanguage;
import megal.relationships.Relationship;

import org.junit.Test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigTest extends BaseTest {
	
	@Test
	public void readFromFileTest() throws IOException {
		Config conf = ConfigFactory.load();
		assertNotNull(conf);
	}
	
	@Test
	public void relationshipsShouldExist(){
		Config conf = ConfigFactory.load();
		@SuppressWarnings("unchecked")
		List<Config> rels = (List<Config>) conf.getConfigList("relationships");
		
		// FileElementOfLanguage, FolderPartOfFolder
		assertEquals(2, rels.size());
	}
	
	@Test
	public void relationshipsShouldBeValidExist(){
		Config conf = ConfigFactory.load();
		@SuppressWarnings("unchecked")
		List<Config> rels = (List<Config>) conf.getConfigList("relationships");
		for (Config rel : rels){
			String name = rel.getString("relationship");
			assertNotNull(name);
			Config relConfig = rel.getConfig("config");	
			assertNotNull(relConfig);
		}
	}
	
	@Test
	public void configForRelationshipTypeShouldBeDiscoveredIfExists(){
		File f = new File(null);
		Language l = new Language(null);
		RTypeDecl rTypeDecl = new RTypeDecl("elementOf", "File", "Language", true);
		
		Relationship<File, Language> rel = new FileElementOfLanguage(f, l, rTypeDecl);
		Config c = rel.getConfig();
		assertNotEquals(c, null);
	}
}
