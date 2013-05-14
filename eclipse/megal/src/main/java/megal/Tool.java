package megal;

import static megal.Context.*;
import megal.analysis.*;
import megal.model.RDecl;
import megal.model.RTypeDecl;
import megal.parser.MegaLMyLexer;
import megal.parser.MegaLParser;
import megal.trivia.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.*;
import com.google.gson.Gson;

/**
 * Parse the megamodel. Analyze it in all kinds of ways. Resolve it, of course.
 * Any sort of issue is to report with a non-zero exit code.
 */
public class Tool {
	
	public static void parse(String input) {
		try {
			try {
				FileInputStream stream = new FileInputStream(input);
				ANTLRInputStream antlr = new ANTLRInputStream(stream);
				MegaLMyLexer lexer = new MegaLMyLexer(antlr);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				MegaLParser parser = new MegaLParser(tokens);
				parser.root = Context.model;
				parser.model();
				Context.log.lexerErrors += lexer.getNumberOfErrors();
				Context.log.parserErrors += parser.getNumberOfSyntaxErrors();
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
	
	public static void link(){
		new Linking();
	}
	
	/*
	 * After prelude was parsed, we need to extend MegaL, i.e. register all plugins and add custom relationships
	 */
	public static void extend(){ 
		List<RTypeDecl> customRDecls = Context.runtime.getCustomRDecls();
		for(RTypeDecl decl: customRDecls){
			Context.model.addDecl(decl);
		}
	}
	
	public static void analyze(){
		// Run various analyses
		new EDecls();
		new ETypeDecls();
		new ERefs();
		new ETypeRefs();
		new RDecls();
		new RTypeDecls();
	}
	
	public static void main(String[] args) throws IOException {
		
		if (args.length < 2){
			System.out.print("Please provide the following arguments: home dir and a megamodel file");
			System.exit(-1);
		}
		
		String home = args[0];
		String input = args[1];
		
		parse(home+File.separator+"megal"+File.separator+"prelude.megal");

		extend();
		
		analyze();
		
		parse(input);

		link();
		
		// Write log back next to input file
		String output = input.replaceFirst(".megal", ".log");
		if (input!=output) {
			PrintStream ps = new PrintStream(output);
			Gson gson = new Gson();
			ps.println(gson.toJson(Context.log));
			ps.close();
		}
				
		// Exit with a non-zero exit code if there were any problems
		if (log.fatalErrors > 0 
			|| log.lexerErrors > 0 
			|| log.parserErrors > 0
			|| log.problems.size() > 0)
		System.exit(1);
	}
}
