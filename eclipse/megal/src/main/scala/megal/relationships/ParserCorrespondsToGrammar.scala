package megal.relationships

import megal.relationships.core.correspondsTo
import megal.entities.File
import org.antlr.v4.tool.Grammar

class ParserCorrespondsToGrammar(first: megal.entities.File, 
								 second: megal.entities.File, 
								 rTypeDecl: megal.model.RTypeDecl) extends correspondsTo[File, File](first, second, rTypeDecl)  {
	
	override def evaluate() : Boolean = {
	  val grammar = ""
	  val g = new Grammar(grammar)
	  
	  true
	}
}