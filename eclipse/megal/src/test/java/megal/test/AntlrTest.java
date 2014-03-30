package megal.test;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

import megal.checkers.Fragment;
import megal.checkers.correspondance.ParserCorrespondsToAntlrGrammar;
import megal.trivia.Pair;

import org.junit.Test;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.v4.parse.GrammarASTAdaptor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.Rule;
import org.antlr.v4.tool.ast.GrammarAST;
import org.antlr.v4.tool.ast.RuleAST;
import org.antlr.v4.tool.interp.LexerInterpreter;
import org.antlr.v4.tool.interp.ParserInterpreter;

public class AntlrTest extends BaseTest {
	
    @Test
	public void parserTest(){    	
    	String grammar = this.getResourceContent("/files/MegaL.g4");
    	try {
			final Grammar g = new Grammar(grammar);
			System.out.println(g.name);
			for(String k: g.rules.keySet()){
				System.out.println(k);
				Rule r = (Rule)g.rules.get(k);
				RuleAST ast = r.ast;
				
				String st = ast.toStringTree();
				System.out.println(st);
			}
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
    	System.out.print("done");
	}
    
    private String toStringTree(Tree ast){
    	return null;
    }
    
    @Test
    public void correspondanceTest(){
    	ParserCorrespondsToAntlrGrammar c = new ParserCorrespondsToAntlrGrammar(null, null);
    	try {
		
    		Pair<java.lang.Boolean, List<Pair<Fragment, Fragment>>> res =
    				c.check(
    						new URI("https://raw2.github.com/avaranovich/megal/master/eclipse/megal/src/main/java/megal/parser/MegaL.g4"), 
    						new URI("https://raw2.github.com/avaranovich/megal/master/eclipse/megal/src/main/java/megal/parser/MegaLParser.java"));
    		
    		assertEquals(true, res.first);
    		assertEquals(18, res.second.size());
    		
    		
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
    }
}
