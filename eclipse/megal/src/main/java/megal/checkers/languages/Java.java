package megal.checkers.languages;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.common.io.Closeables;
import com.google.common.io.Resources;
import com.google.common.primitives.Chars;

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
