grammar MegaL;

@parser::header {
package megal.parser;

import megal.*;
import megal.model.*;
import java.util.List;
import java.util.LinkedList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
}

@lexer::header {
package megal.parser;
}

@parser::members {
	public static Model parse(String s) throws IOException {
    	FileInputStream stream = new FileInputStream(s);
    	ANTLRInputStream antlr = new ANTLRInputStream(stream);
    	MegaLLexer lexer = new MegaLMyLexer(antlr);
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
    	MegaLParser parser = new MegaLParser(tokens);
    	ModelContext ctx = parser.model();
    	if (parser.getNumberOfSyntaxErrors()>0)
    		throw new MegaLException();
    	return ctx.m;
	}
}

model returns [Model m] :
 { $m = new Model(); }
 ( decl
   { $m.getDecls().add($decl.d); }
 )*
 ;

decl returns [Decl d] : 
	( edecl { $d = $edecl.d; }	
	| rdecl { $d = $rdecl.d; }
	| etdecl { $d = $etdecl.d; }
	| rtdecl { $d = $rtdecl.d; }
	)
	'.'
	;

// Entity declarations
edecl returns [EDecl d] : 
    { Modifier m = null; }
	( modifier { m = $modifier.m; } )? 
	ename 
	':'
	etype 
	{ $d = new EDecl(m, $etype.t, $ename.n); }
	; 
	
// Relationship declarations
rdecl returns [RDecl d]:
	left=name 
	ID 
	right=name 
	{ $d = new RDecl($ID.text, $left.n, $right.n); }
	;

// Modifiers for entities
modifier returns [Modifier m] :
	  'extern' { $m = Modifier.Extern; }
	| 'intern' { $m = Modifier.Intern; }
	;

// Entity types for entity declarations
etype returns [EType t] :
	{ EType.Cardinality c = EType.Cardinality.None; }
	ID 
	( '+' { c = EType.Cardinality.Plus; }
	| '*' { c = EType.Cardinality.Star; }
	)?
	{ $t = new EType($ID.text, c); }
	;

// Entity names are either IDs or STRINGs.
ename returns [List<String> n] :
	{ List<String> n = new LinkedList<String>(); }
	n1=name
	{ n.add($n1.n); }
	(
	'@'
	n2=name
	{ n.add($n2.n); }
	)*
	;

// Names
name returns [String n] :
	(
	  ID { $n = $ID.text; }
	| STRING { $n = $STRING.text.substring(1,$STRING.text.length()-2); }
	)
	;

// Entity type declarations
etdecl returns [ETDecl d] :
	subtype=ID
	'<'
	supertype=ID
	{ $d = new ETDecl($subtype.text, $supertype.text); } 
	;

// Relationship type declarations
rtdecl returns [RTDecl d] :
	r=ID
	'<'
	arg1=ID
	'*'
	arg2=ID
	{ $d = new RTDecl($r.text, $arg1.text, $arg2.text); } 
	;

// IDs as in names of entity or relationship type
ID : ('a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')* ;

// STRINGs as more protected variations on IDs
STRING : '"' (~'"')* '"';

// White space along lexing/parsing
WS : (' '|'\r'? '\n'|'\t')+ { skip(); };

// Comments to be allowed and skipped anywhere
COMMENT : ('/*' ((~'*')|'-'*'/')* '*/' | '/' '/' (~('\n'|'\r'))*) { skip(); };
