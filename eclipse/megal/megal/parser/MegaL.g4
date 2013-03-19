grammar MegaL;

@parser::header {
package megal.parser;

import megal.*;
import megal.model.*;
import java.util.List;
import java.util.LinkedList;
}

@lexer::header {
package megal.parser;
}

@parser::members {
	public Model root;
}

model :
 ( decl
   { root.getDecls().add($decl.d); }
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
	uqref
	parent
	':'
	etype
	{ $d = new EDecl(m, $etype.t, $ename.n, $uqref.s, $parent.n); }
	; 
	
// Relationship declarations
rdecl returns [RDecl d]:
	left=ename 
	rname
	right=ename 
	{ $d = new RDecl($rname.n, $left.n, $right.n); }
	;

// Modifiers for entities
modifier returns [Modifier m] :
	  'extern' { $m = Modifier.Extern; }
	| 'intern' { $m = Modifier.Intern; }
	;

// Entity types for entity declarations
etype returns [EType t] :
	{ EType.Cardinality c = EType.Cardinality.None; }
	etypename
	( '+' { c = EType.Cardinality.Plus; }
	| '*' { c = EType.Cardinality.Star; }
	)?
	{ $t = new EType($etypename.n, c); }
	;

// Entity names
ename returns [String n] :
	ID { $n = $ID.text; }
	;

// Relationship names
rname returns [String n] :
	ID { $n = $ID.text; }
	;

// Entity type names
etypename returns [String n] :
	ID { $n = $ID.text; }
	;

// Unqualified references for entities
uqref returns [String s] :
	{ $s = null; }
	(
	'['
	STRING { $s = $STRING.text.substring(1,$STRING.text.length()-2); }
	']'
	)?
	;
	
// Parent context in entity declarations
parent returns [String n] :
	{ $n = null; }
	(
	'@'
	ename { $n = $ename.n; }
	)?
	;

// Entity type declarations
etdecl returns [ETDecl d] :
	subtype=etypename
	'<'
	supertype=etypename
	{ $d = new ETDecl($subtype.n, $supertype.n); } 
	;

// Relationship type declarations
rtdecl returns [RTDecl d] :
	r=rname
	'<'
	arg1=etypename
	'*'
	arg2=etypename
	{ $d = new RTDecl($r.n, $arg1.n, $arg2.n); } 
	;

// IDs as in names of entity or relationship type
ID : ('a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')* ;

// STRINGs as more protected variations on IDs
STRING : '"' (~'"')* '"';

// White space along lexing/parsing
WS : (' '|'\r'? '\n'|'\t')+ { skip(); };

// Comments to be allowed and skipped anywhere
COMMENT : ('/*' ((~'*')|'-'*'/')* '*/' | '/' '/' (~('\n'|'\r'))*) { skip(); };
