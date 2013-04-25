package megal.checkers.languages;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import megal.checkers.Checker;

public class Java implements Checker<String> {

	public boolean check(String fileName) {
		// creates an input stream for the file to be parsed
        FileInputStream in;
		try {
			in = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			return false;
		}

        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } catch (ParseException e) {
			return false;
		} finally {
			if (in != null){
	            try {
					in.close();
				} catch (IOException e) {
					return false;
				}
			}
        }

		return false;
	}
}
