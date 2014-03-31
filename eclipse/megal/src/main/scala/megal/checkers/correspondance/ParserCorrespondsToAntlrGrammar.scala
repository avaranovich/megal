package megal.checkers.correspondance

import java.net.URI
import megal.checkers.CorrespondanceChecker
import megal.checkers.Fragment
import japa.parser.JavaParser
import com.google.common.io.Resources
import japa.parser.ast.visitor.VoidVisitorAdapter
import japa.parser.ast.body.MethodDeclaration
import japa.parser.ast.body.TypeDeclaration
import scala.collection.JavaConverters._
import megal.checkers.Fragment
import japa.parser.ast.body.ClassOrInterfaceDeclaration
import org.antlr.v4.tool.Grammar
import com.google.common.base.Charsets
import japa.parser.ast.expr.NameExpr
import japa.parser.ast.`type`.ClassOrInterfaceType
import japa.parser.ast.body.BodyDeclaration

class ParserCorrespondsToAntlrGrammar(first: URI, second: URI) extends CorrespondanceChecker[URI, URI] {
	
	implicit def javaListToScalaList(x: java.util.List[japa.parser.ast.body.TypeDeclaration]) = x.asScala.toList
  implicit def javaListToScalaList1(x: java.util.List[ClassOrInterfaceType]) = x.asScala.toList
  implicit def javaListToScalaLis2(x: java.util.List[NameExpr]) = x.asScala.toList
  implicit def javaListToScalaLis3(x: java.util.List[BodyDeclaration]) = x.asScala.toList

	override def check(first: URI, second: URI) = {	  
	  
	  var parser: URI = first
	  var grammar: URI = second
	  
	  if (first.toString.endsWith(".g4")){
		  grammar = first
	  }

	  if (second.toString.endsWith(".java")){
	    parser = second
	  }
	  
	  val in = Resources.newInputStreamSupplier(parser.toURL).getInput
      val cu = JavaParser.parse(in)
      val types: List[TypeDeclaration] = cu.getTypes
              
      if (types.length > 1){
        new megal.trivia.Pair[java.lang.Boolean, java.util.List[megal.trivia.Pair[Fragment, Fragment]]](false, null) 
      }
      
      val comments = cu.getComments.asScala.toList
      val firstComment = comments(0)
      val onTheSameLine = ((firstComment.getBeginLine == 1) && (firstComment.getEndLine == 1))
      val antlrHint = firstComment.getContent.contains("by ANTLR 4.0")
      
      if (!onTheSameLine || !antlrHint){
    	  new megal.trivia.Pair[java.lang.Boolean, java.util.List[megal.trivia.Pair[Fragment, Fragment]]](false, null) 
      }
      
      val root = types(0)
      val classes = root.getMembers.asScala.toList.filter(p => p.isInstanceOf[ClassOrInterfaceDeclaration])
      												.map(x => x.asInstanceOf[ClassOrInterfaceDeclaration])	
      												.filter(x => x.getExtends.map(y => y.getName).contains("ParserRuleContext"))
      												
      //classes.foreach(c => println(c.getName()))
												
      val methods = root.getMembers().filter(x => x.isInstanceOf[MethodDeclaration])
      												.map(x =>x.asInstanceOf[MethodDeclaration])
      												.filter(
      												    x => ((x.getThrows() != null) && 
      												         (x.getThrows().map(y => y.getName()).contains("RecognitionException"))))
      														         
      methods.foreach(m => println(m.getName()))			
      												
      val g = Resources.toString(grammar.toURL(), Charsets.UTF_8)
      val antrlGrammar = new Grammar(g)
      val rules = antrlGrammar.rules.asScala
      
      val ruleNames = rules.map(r => r._1)
      
       if (rules.size != methods.size){
    	  new megal.trivia.Pair[java.lang.Boolean, java.util.List[megal.trivia.Pair[Fragment, Fragment]]](false, null) 
      }
      
      val isAlligned = methods.zip(ruleNames).forall(x => x._1.getName().equals(x._2))
      
      val res = new java.util.ArrayList[megal.trivia.Pair[Fragment, Fragment]]();
      
      if (isAlligned){
        methods.zip(rules).foreach(x =>{
          var m = x._1.toString();
          var r = x._2._2.ast.toStringTree();
          
          res.add(new megal.trivia.Pair[Fragment, Fragment](
              new Fragment(x._1.getName(), r, null), 
              new Fragment(x._2._1, m, null)))
        })
      }
     /*
      ruleNames.foreach(n => println(n))
      
      val isAlligned = classes.map(c => c.getName()).zip(rules.map(r => r._1)).forall(x => x._1.startsWith(x._2.capitalize))
      
      
      if (isAlligned){
        classes.zip(rules).foreach(x => {
          val c = x._1.toString()
          val r = x._2._2.ast.toStringTree()
          res.add(new megal.trivia.Pair[Fragment, Fragment](
              new Fragment(r), 
              new Fragment(c)))
        })
      }*/
 
	  new megal.trivia.Pair[java.lang.Boolean, java.util.List[megal.trivia.Pair[Fragment, Fragment]]](true, res) 
	}
}