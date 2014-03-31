package megal.relationships

import megal.relationships.core.correspondsTo
import megal.entities.File
import org.antlr.v4.tool.Grammar
import megal.checkers.CorrespondanceChecker
import java.net.URI
import megal.providers.ProviderFactory

class FileCorrespondsToFile(first: megal.entities.File, 
						   second: megal.entities.File, 
						   rTypeDecl: megal.model.RTypeDecl) extends correspondsTo[File, File](first, second, rTypeDecl)  {
	
	override def evaluate() : Boolean = {
	  val grammar = ""
	  val g = new Grammar(grammar)
	  
	  val checker = ""
      val clazz = Class.forName(checker)
	  val tool = clazz.newInstance().asInstanceOf[CorrespondanceChecker[URI, URI]]
	  
	  val r1  = ProviderFactory.getForUrl(first.getResource()).getUri()
	  val r2  = ProviderFactory.getForUrl(second.getResource()).getUri()
	  
    val success = tool.check(r1, r2)
      
    false
	}
}