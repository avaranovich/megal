package megal;

import megal.model.*;
import megal.analysis.*;
import megal.parser.MegaLMyLexer;
import megal.parser.MegaLParser;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.antlr.v4.runtime.*;

import com.google.gson.Gson;

/**
 * Parse the megamodel. Analyze it in all kinds of ways. Resolve it, of course.
 * Any sort of issue is to report with a non-zero exit code.
 */
public class Tool {
	public static void main(String[] args) throws IOException {
		String input = args[0];
		Log log = new Log();
		Model m = null;
		try {
			try {
				FileInputStream stream = new FileInputStream(input);
				ANTLRInputStream antlr = new ANTLRInputStream(stream);
				MegaLMyLexer lexer = new MegaLMyLexer(antlr);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				MegaLParser parser = new MegaLParser(tokens);
				MegaLParser.ModelContext ctx = parser.model();
				log.lexerErrors += lexer.getNumberOfErrors();
				log.parserErrors += parser.getNumberOfSyntaxErrors();
				m = ctx.m;
				if (m == null)
					log.fatalErrors++;
			} catch (IOException e) {
				e.printStackTrace();
				log.fatalErrors++;
			}
			TypeNames.check(m);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatalErrors++;
		}
		
		// Write log back next to input file
		String output = input.replaceFirst(".megal", ".log");
		if (input!=output) {
			PrintStream ps = new PrintStream(output);
			Gson gson = new Gson();
			ps.println(gson.toJson(log));
			ps.close();
		}
		
		if (log.fatalErrors > 0 
			|| log.lexerErrors > 0 
			|| log.parserErrors > 0)
		System.exit(1);
	}
}
