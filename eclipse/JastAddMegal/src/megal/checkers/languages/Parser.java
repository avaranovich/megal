package megal.checkers.languages;

import java.io.File;
import java.net.URI;

import util.Net;

import AST.BytecodeParser;
import AST.CompilationUnit;
import megal.checkers.Checker;

public class Parser implements Checker<URI> {

	@SuppressWarnings("deprecation")
	public boolean check(URI file) {
		// parse the file
		try {
			if(file.toString().startsWith("http")){
		    	try
		    	{
		    		//safes the linked file in URI in output file temp.java
		    		if(Net.safeFileFromURI(new File("temp.java"), file));
		    			return compile("temp.java");
		    	} catch(Exception e){
		    		e.printStackTrace();
		    		return false;
		    	}
			}
			return compile(file.getPath());
		} catch (Exception e) {
			return false;
		}
	}

	static class JavaCompiler extends AST.Frontend {

		public static boolean compile(String args) {
			return new JavaCompiler().process(new String[] { args },
					new BytecodeParser(), new AST.JavaParser() {
						public CompilationUnit parse(java.io.InputStream is,
								String fileName) throws java.io.IOException,
								beaver.Parser.Exception {
							return new parser.JavaParser().parse(is, fileName);
						}
					});
		}

		protected void processNoErrors(CompilationUnit unit) {
			unit.transformation();
			System.out.println("After Transformation:");
			System.out.println(unit.toString());
			unit.generateClassfile();
		}

		protected void processErrors(java.util.Collection errors,
				CompilationUnit unit) {
			super.processErrors(errors, unit);
		}
	}

	public static boolean compile(String args) {
		return new JavaCompiler().process(new String[] { args },
				new BytecodeParser(), new AST.JavaParser() {
					public CompilationUnit parse(java.io.InputStream is,
							String fileName) throws java.io.IOException,
							beaver.Parser.Exception {
						return new parser.JavaParser().parse(is, fileName);
					}
				});
	}

}
