package megal.checkers.languages;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

import jrag.AST.JragParser;

import org.jastadd.JastAddConfiguration;

import util.Net;

import ast.AST.Grammar;
import megal.checkers.Checker;

public class JastAddChecker implements Checker<URI> {

	@SuppressWarnings("deprecation")
	public boolean check(URI file) {

		FileInputStream fis;
		try {
			if(file.toString().startsWith("http")){
				Net.safeFileFromURI(new File("temp.jadd"), file);
				fis = new FileInputStream("temp.jadd");
			}else{
				fis = new FileInputStream(file.getPath());
			}
			JragParser jp = new JragParser(fis);
			jp.inputStream = fis;
			jp.setFileName(file.getPath());
			jp.root = new Grammar();
			jp.CompilationUnit();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}