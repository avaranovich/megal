package megal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import megal.trivia.Pair;

/**
 * 
 */
public class Ontology {
	
	public static Set<String> etypes;	
	public static Set<String> rtypes;
	public static Map<String,String> esubtypes;
	public static Map<String,List<Pair<String,String>>> rargtypes;
		
	static {

		etypes = new HashSet<String>();
		etypes.add("Entity");
		etypes.add("Language");
		etypes.add("Technology");
		etypes.add("Concept");
		etypes.add("Artifact");
		etypes.add("Folder");
		etypes.add("File");

		esubtypes = new HashMap<String,String>();
		esubtypes.put("Language", "Entity");
		esubtypes.put("Technology", "Entity");
		esubtypes.put("Concept", "Entity");
		esubtypes.put("Artifact", "Entity");
		esubtypes.put("File", "Artifact");
		esubtypes.put("Folder", "Artifact");
		
		rtypes = new HashSet<String>();
		rtypes.add("elementOf");
		rtypes.add("subsetOf");
		rtypes.add("partOf");
		rtypes.add("instanceOf");
		rtypes.add("isA");
		rtypes.add("conformsTo");
		rtypes.add("definitionOf");

		rargtypes = new HashMap<String, List<Pair<String,String>>>();

	}
	
}
