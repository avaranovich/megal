package megal.parser;

import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.CharStream;

/**
 * A lexer subclass to bail out on token recognition issues and alikes
 */
public class MegaLMyLexer extends MegaLLexer {

	private int errors = 0;
	
	/**
	 * Delegate construction to the super lexer
	 */
	public MegaLMyLexer(CharStream input) {
		super(input);
	}

	/**
	 * Do not recover!
	 */
	public void recover(LexerNoViableAltException e) {
		errors++;
	}

	/**
	 * Do not recover!
	 */
	public void recover(RecognitionException e) {
		errors++;
	}

	public int getNumberOfErrors() {
		return errors;
	}
}
