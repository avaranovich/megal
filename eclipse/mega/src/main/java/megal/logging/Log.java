package megal.logging;

import java.util.List;
import java.util.LinkedList;

/**
 * A log accumulated over time
 */
public class Log {
	// Fatal errors such as IOExcecptions
	public int fatalErrors = 0;
	
	// Errors reported by lexer and parser
	public int lexerErrors = 0;
	public int parserErrors = 0;
	
	// Problems classified by problem code
	public List<Problem> problems = new LinkedList<Problem>();
}
