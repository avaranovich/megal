package megal.analysis;

import java.util.List;
import java.util.LinkedList;
import megal.model.*;
import megal.trivia.Pair;
import static megal.Context.*;

/**
 * Collect all RTypeDecls. 
 */
public class RTypeDecls extends Visitor {
	public void visit(RTypeDecl decl) {
		String name = decl.getName();
		String left = decl.getLeft();
		String right = decl.getRight();
		if (!rTypeDecls.containsKey(name))
			rTypeDecls.put(name, new LinkedList<Pair<String,String>>());
		List<Pair<String,String>> decls = rTypeDecls.get(name);
		decls.add(new Pair<String,String>(left,right));
	}
}
