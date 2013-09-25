package megal.checkers.languages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;

import util.Net;

import ast.AST.Ast;
import ast.AST.ParseException;

import megal.checkers.Checker;

public class ASTChecker implements Checker<URI> {

	@Override
	public boolean check(URI target) {
	
		String path=target.getPath();
		Ast parser;
		try {
			if(target.toString().startsWith("http")){
				Net.safeFileFromURI(new File("temp.ast"), target);
				parser = new Ast(new FileInputStream("temp.ast"));
			}
			else{
				parser = new Ast(new FileInputStream(path));
			}
			parser.fileName = path;
			parser.Grammar();
			if(parser.parseProblems().isEmpty())
				return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (ParseException e) {
			return false;
		} catch(Exception e){
			return false;
		}
		return false;
	}

}
