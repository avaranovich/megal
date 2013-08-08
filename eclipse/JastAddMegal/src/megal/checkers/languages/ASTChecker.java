package megal.checkers.languages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;

import ast.AST.Ast;
import ast.AST.ParseException;

import megal.checkers.Checker;

public class ASTChecker implements Checker<URI> {

	@Override
	public boolean check(URI target) {
	
		String path=target.getPath();
		Ast parser;
		try {
			parser = new Ast(new FileInputStream(path));
			parser.fileName = path;
			parser.Grammar();
			if(parser.parseProblems().isEmpty())
				return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
