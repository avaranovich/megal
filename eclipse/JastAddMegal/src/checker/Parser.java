package checker;


import java.net.URI;

import AST.BytecodeParser;
import AST.CompilationUnit;
import megal.checkers.Checker;

public class Parser implements Checker<URI>{
	
	@SuppressWarnings("deprecation")
	public boolean check(URI file) {
            // parse the file
            try {
            	return compile(file.getPath());
			} catch (Exception e){
				return false;
			}
	}
	
	static class JavaCompiler extends AST.Frontend {

		public static boolean compile(String args) {
			return new JavaCompiler().process(new String[]{args}, new BytecodeParser(),
					new AST.JavaParser() {
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
		return new JavaCompiler().process(new String[]{args}, new BytecodeParser(),
				new AST.JavaParser() {
					public CompilationUnit parse(java.io.InputStream is,
							String fileName) throws java.io.IOException,
							beaver.Parser.Exception {
						return new parser.JavaParser().parse(is, fileName);
					}
				});
	}
	
}
