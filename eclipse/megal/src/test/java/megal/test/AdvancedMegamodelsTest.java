package megal.test;

import static org.junit.Assert.*;

import java.util.Map.Entry;

import megal.Context;
import megal.Tool;
import megal.model.EDecl;
import megal.model.GenericArguments;
import megal.model.RDecl;

import org.junit.Before;
import org.junit.Test;

public class AdvancedMegamodelsTest extends BaseTest {
	
    @Before
    public void setUp() {
        super.setUp();
    	String input = getResorucePath("/models/antlr.megal");
		Tool.parse(input);
		Tool.analyze();
		Tool.extend();
		Tool.analyze();
    }

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
}
