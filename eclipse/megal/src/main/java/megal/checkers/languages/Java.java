package megal.checkers.languages;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import com.google.common.io.Closeables;
import com.google.common.io.Resources;

import megal.checkers.Checker;

public class Java implements Checker<URI> {

	@SuppressWarnings("deprecation")
	public boolean check(URI file) {
        CompilationUnit cu;
        try {
            // parse the file
        	InputStream in = null;
            try {
            	in = Resources.newInputStreamSupplier(file.toURL()).getInput();
            	//String content = CharStreams.toString(new InputStreamReader(in, Charsets.UTF_8));
            	
				cu = JavaParser.parse(in);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
            finally{
            	Closeables.closeQuietly(in);
            }
        } catch (ParseException e) {
			return false;
		} 

		return true;
	}
}
