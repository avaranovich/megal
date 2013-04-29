package megal.test;

import static org.junit.Assert.*;

import java.util.List;

import megal.Context;
import megal.Tool;
import megal.model.RDecl;

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
		List<RDecl> customRels =  Context.runtime.getCustomRDecls();
		assertEquals(1, customRels.size());	
		
		RDecl fileElementOfLanguage = customRels.get(0);
		assertEquals("elementOf", fileElementOfLanguage.getRel().getName());
		assertEquals("Language", fileElementOfLanguage.getRight().getName());
		assertEquals("File", fileElementOfLanguage.getLeft().getName());	
	}
}
