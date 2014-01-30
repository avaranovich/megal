package megal.test;

import org.junit.Test;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.Rule;
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
				
				if ( ast.getChildren()==null || ast.getChildren().isEmpty() ) {
					//return this.toString();
				}
				
				StringBuilder buf = new StringBuilder();
				buf.append("(");
				String s = ast.toString();
				buf.append(s);
				buf.append(' ');
				
				for (int i = 0; ast.getChildren() !=null && i < ast.getChildren().size(); i++) {
					Tree t = (Tree) ast.getChildren().get(i);
					if ( i>0 ) {
						buf.append(' ');
					}
					buf.append(t.toStringTree());
				}
					buf.append(")");
				//return buf.toString();
				
				String res = buf.toString();
				System.out.println(res);
			}
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
    	System.out.print("done");
	}
    
    private String toStringTree(Tree ast){
    	return null;
    }
}
