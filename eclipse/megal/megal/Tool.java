package megal;

import megal.logging.Log;
import megal.model.*;
import megal.analysis.*;
import megal.parser.MegaLMyLexer;
import megal.parser.MegaLParser;

import java.io.File;
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
	
	public static void parse(String input, Model model, Log log) {
		try {
			try {
				FileInputStream stream = new FileInputStream(input);
				ANTLRInputStream antlr = new ANTLRInputStream(stream);
				MegaLMyLexer lexer = new MegaLMyLexer(antlr);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				MegaLParser parser = new MegaLParser(tokens);
				parser.root = model;
				parser.model();
				log.lexerErrors += lexer.getNumberOfErrors();
				log.parserErrors += parser.getNumberOfSyntaxErrors();
			} catch (IOException e) {
				e.printStackTrace();
				log.fatalErrors++;
			}
//			Definedness.check(model,log);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatalErrors++;
		}		
	}
	
	private static void resolve(Model model, Log log){
		new Resolution(model, log);
	}
	
	public static void main(String[] args) throws IOException {
		String home = args[0];
		String input = args[1];
		
		//configuration file path
		String config = args[3];
		
		// load the config file
		// pululate the tool registry
		ConfigRegistry registry = ConfigRegistry.fromFile(config);
		
		Model model = new Model();
		Log log = new Log();
		parse(home+File.separator+"megal"+File.separator+"prelude.megal",model,log);
		parse(input,model,log);
		
		resolve(model, log);
		
		// Write log back next to input file
		String output = input.replaceFirst(".megal", ".log");
		if (input!=output) {
			PrintStream ps = new PrintStream(output);
			Gson gson = new Gson();
			ps.println(gson.toJson(log));
			ps.close();
		}
		
		// Run various analyses
		new EDecls(model,log);
		new ETDecls(model,log);
		
		// Exit with a non-zero exit code if there were any problems
		if (log.fatalErrors > 0 
			|| log.lexerErrors > 0 
			|| log.parserErrors > 0
			|| log.problems.size() > 0)
		System.exit(1);
	}
}
