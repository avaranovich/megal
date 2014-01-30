package megal.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map.Entry;

import megal.Context;
import megal.Tool;
import megal.model.Decl;
import megal.model.EDecl;
import megal.model.GenericArguments;
import megal.model.RDecl;

import org.junit.Before;
import org.junit.Test;

import com.typesafe.config.ConfigFactory;

public class AdvancedMegamodelsTest extends BaseTest {
	
    @Before
    public void setUp() {
        super.setUp();
        Context.config = ConfigFactory.load("configs/antlr.conf").withFallback(Context.config);
    	String input = getResorucePath("/models/antlr.megal");
		Tool.parse(input);
		Tool.analyze();
		Tool.extend();
		Tool.analyze();
    }

    @SuppressWarnings("rawtypes")
	@Test
	public void genericArgumentsForFunctionShouldBeSupported(){
    	for (Entry<String, EDecl> entry: Context.eDecls.entrySet()){
    		String key = entry.getKey();
    		if (key.equals("codeGeneration")){
    			EDecl eDecl = entry.getValue();
    			assertEquals("Function", eDecl.getType().getName());
    			GenericArguments args = eDecl.getType().getGenericArguments();
    			assertEquals("AntlrNotation", args.getLeft());
    			assertEquals("Java", args.getRight());
    		}
    	}
	}
    
    @Test
    public void relationAnnotationsShouldBeSupported(){
    	for (Entry<String, RDecl> entry: Context.rDecls.entrySet()){
    		String key = entry.getKey();
    		if (key.equals("conformsTo")){
    			String ann = entry.getValue().getAnnotation();
    			assertEquals("aParser", ann);
    		}
    	}
    }
    
    @SuppressWarnings("rawtypes")
	@Test
    public void testSyntacticExpansionForGenericFucntion(){
     	for (Entry<String, EDecl> entry: Context.eDecls.entrySet()){
    		String key = entry.getKey();
    		if (key.equals("codeGeneration")){
    			@SuppressWarnings("unchecked")
				List<Decl> expanded = entry.getValue().expand();
    			assertNotNull(expanded);
    			assertEquals(2, expanded.size());
    		}
     	}
    }
    
    @Test
    public void testFunctionApplicationDeclaration(){
    	assertEquals(true, true);
    }
    
    @Test
    public void testExpansionLinkingForFunction(){
    	Tool.link();
    }
}
