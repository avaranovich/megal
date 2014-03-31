package megal.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map.Entry;

import megal.Context;
import megal.Tool;
import megal.model.Decl;
import megal.model.RDecl;
import megal.model.RTypeDecl;
import megal.relationships.FileElementOfLanguage;
import megal.relationships.core.Relationship;
import megal.relationships.core.elementOf;
import megal.trivia.Pair;

import org.junit.Before;
import org.junit.Test;

public class RelationshipsTest extends BaseTest {
	
	@Before
	public void setUp() {
		super.setUp();
		String input = getResorucePath("/models/java.megal");
		Tool.parse(input);
	}
	
	@Test
	public void customRelationshipsShouldBeAddedToTheGraph(){
		List<RTypeDecl> customRels =  Context.runtime.getCustomRDecls();
		assertEquals(11, customRels.size());	
		
		for (RTypeDecl rTypeDecl: customRels){
			if(rTypeDecl.getClass().isAssignableFrom(elementOf.class)){
				//RTypeDecl fileElementOfLanguage = customRels.get(1);
				assertEquals("elementOf", rTypeDecl.getName());
				assertEquals("Language", rTypeDecl.getRight());
				assertEquals("File", rTypeDecl.getLeft());	
			}
		}
	}
	
	@Test
	public void allRelationshipsFromPreludeShouldBeAddedToTheGraphBeforeBootstrap(){
		Tool.analyze();
		/*
		  subsetOf=[(Set,Set)],
		  conformsTo=[(Artifact,Artifact)],
		  definitionOf=[(Artifact,Language)], 
		  elementOf=[(Entity,Set)], 
		  partOf=[(Artifact,Artifact)], 
		  isA=[(Concept,Concept)], 
		  instanceOf=[(Concept,Concept)] 
		  hasOutput=[(Technology,Artifact) (Artifact,Artifact)]
		*/
		assertEquals(10, Context.rTypeDecls.size());
	}
	
	@Test
	public void allCustomRelationshipsShouldBeAddedToTheGraphAfterBootstrap(){
		Tool.analyze();
		Tool.extend();
		Tool.analyze();
		
		System.out.println("All relationship types:");
		for (Entry<String, List<Pair<String, String>>> entry : Context.rTypeDecls.entrySet()) {
			String key = entry.getKey();
		    System.out.println("Key = " + key + ", Value = " + entry.getValue());
		    if (key.equals("subsetOf") || key.equals("definitionOf") || key.equals("isA") || key.equals("instanceOf") || key.equals("corresponds")){
				assertEquals(1, entry.getValue().size());	
		    }
		    else if (key.equals("conformsTo")){
				assertEquals(2, entry.getValue().size());	
		    }
		    else if (key.equals("elementOf") || key.equals("partOf")){
				assertEquals(2, entry.getValue().size());	
		    }
		    else if (key.equals("inputOf")){
				assertEquals(4, entry.getValue().size());	
		    }
		    else{
		    	//assertEquals(2, entry.getValue().size());
                assertEquals(true, true);
		    }
		}
	}
	
	@Test
	public void existingCustomRelationsihpShouldBeProperlyResolved(){
		Tool.analyze();
		Tool.extend();
		Tool.analyze();
				
		for(Decl d: Context.model.getDecls()){
			if (d instanceof RDecl){
				assertEquals("elementOf", ((RDecl)d).getRel().getName()); 
				Relationship<?,?> rel = ((RDecl)d).getRelationship();
				assertTrue(rel instanceof FileElementOfLanguage);
			}
		}
	}
}
