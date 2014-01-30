grammar MegaL;

@parser::header {
package megal.parser;

import megal.*;
import megal.model.*;
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
	| etypedecl { $d = $etypedecl.d; }
	| rtypedecl { $d = $rtypedecl.d; }
	| funappdecl { $d = $funappdecl.d; }
	)
	dot
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
rdecl returns [RDecl d] :
	left=ename 
	rname
	right=ename 
	ann=annotation
	{ $d = new RDecl($rname.n, $left.n, $right.n, $ann.s); }
	;

// Relationship annotation
annotation returns [String s] :	
	{ $s = null; }
	(
	 '#'
	 ename { $s = $ename.n; }
	)?	
	;
	

// Modifiers for entities
modifier returns [Modifier m] :
	  'extern' { $m = Modifier.Extern; }
	| 'intern' { $m = Modifier.Intern; }
	| '?'	   { $m = Modifier.Parameter; }
	| '!'	   { $m = Modifier.Dependent; }	
	;

// Entity types for entity declarations
etype returns [EType t] :
	{ EType.Cardinality c = EType.Cardinality.None; }
	etypename
	genericarguments
	( '+' { c = EType.Cardinality.Plus; }
	| '*' { c = EType.Cardinality.Star; }
	)?
	{ $t = new EType($etypename.n, c, $genericarguments.g); }
	;

// Generic arguments for entity types (at the moment only Function can have them)
genericarguments returns [GenericArguments g] :
	{ $g = null; String left = null; String right = null; }
	(
		'['
		etypename {left = $etypename.n; }
		'->'
		etypename {right = $etypename.n; }
		']'
	)?
	{ $g = new GenericArguments(left, right); }
	;

//codeGeneration(aGrammar) |-> aParser .

funappdecl returns [FunAppDecl d] :
	{ $d = null; String n = null; String arg = null; String res = null; }
	ename { n = $ename.n; }
	'('
	ename { arg = $ename.n; }
	')' '|' '->'
	ename { res = $ename.n; }
	{ $d = new FunAppDecl(n, arg, res); }
	;

// Entity names
ename returns [String n] :
	id { $n = $id.text; }
	;

// Relationship names
rname returns [String n] :
	ID { $n = $ID.text; }
	;

id : 
	ID
	('.'ID)?
  ;

// Entity type names
etypename returns [String n] :
	id { $n = $id.text; }
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
etypedecl returns [ETypeDecl d] :
	name=etypename
	'<'
	supertype=etypename
	{ $d = new ETypeDecl($name.n, $supertype.n); } 
	;

// Relationship type declarations
rtypedecl returns [RTypeDecl d] :
	name=rname
	'<'
	arg1=etypename
	'*'
	arg2=etypename
	{ $d = new RTypeDecl($name.n, $arg1.n, $arg2.n); } 
	;

// Indicator for the end for megal expression
dot : (NEWLINE)+  ;

// IDs as in names of entity or relationship type
ID : ('a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')* ;

NEWLINE : '\r'? '\n' ;

// STRINGs as more protected variations on IDs
STRING : '"' (~'"')* '"';

// White space along lexing/parsing
WS : (' '|'\t')+ { skip(); };

COMMENT
    :   ( '//' ~[\r\n]* NEWLINE?
        | '/*' .*? '*/'
        ) -> skip
    ;