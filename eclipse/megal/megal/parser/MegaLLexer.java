// Generated from MegaL.g4 by ANTLR 4.0

package megal.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MegaLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, ID=9, 
		STRING=10, WS=11, COMMENT=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'.'", "'extern'", "'+'", "'*'", "':'", "'@'", "'<'", "'intern'", "ID", 
		"STRING", "WS", "COMMENT"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "ID", 
		"STRING", "WS", "COMMENT"
	};


	public MegaLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MegaL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 10: WS_action((RuleContext)_localctx, actionIndex); break;

		case 11: COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:  skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\16o\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\7\n8\n\n\f\n\16\n;\13\n\3\13\3\13\7\13?\n\13\f\13\16\13B"+
		"\13\13\3\13\3\13\3\f\3\f\5\fH\n\f\3\f\3\f\6\fL\n\f\r\f\16\fM\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\7\rW\n\r\f\r\16\rZ\13\r\3\r\7\r]\n\r\f\r\16\r`\13\r"+
		"\3\r\3\r\3\r\3\r\3\r\7\rg\n\r\f\r\16\rj\13\r\5\rl\n\r\3\r\3\r\2\16\3\3"+
		"\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\2"+
		"\31\16\3\3\2\7\4C\\c|\6\62;C\\aac|\3$$\3,,\4\f\f\17\17y\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3"+
		"\33\3\2\2\2\5\35\3\2\2\2\7$\3\2\2\2\t&\3\2\2\2\13(\3\2\2\2\r*\3\2\2\2"+
		"\17,\3\2\2\2\21.\3\2\2\2\23\65\3\2\2\2\25<\3\2\2\2\27K\3\2\2\2\31k\3\2"+
		"\2\2\33\34\7\60\2\2\34\4\3\2\2\2\35\36\7g\2\2\36\37\7z\2\2\37 \7v\2\2"+
		" !\7g\2\2!\"\7t\2\2\"#\7p\2\2#\6\3\2\2\2$%\7-\2\2%\b\3\2\2\2&\'\7,\2\2"+
		"\'\n\3\2\2\2()\7<\2\2)\f\3\2\2\2*+\7B\2\2+\16\3\2\2\2,-\7>\2\2-\20\3\2"+
		"\2\2./\7k\2\2/\60\7p\2\2\60\61\7v\2\2\61\62\7g\2\2\62\63\7t\2\2\63\64"+
		"\7p\2\2\64\22\3\2\2\2\659\t\2\2\2\668\t\3\2\2\67\66\3\2\2\28;\3\2\2\2"+
		"9\67\3\2\2\29:\3\2\2\2:\24\3\2\2\2;9\3\2\2\2<@\7$\2\2=?\n\4\2\2>=\3\2"+
		"\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\7$\2\2D\26\3"+
		"\2\2\2EL\7\"\2\2FH\7\17\2\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IL\7\f\2\2JL"+
		"\7\13\2\2KE\3\2\2\2KG\3\2\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2"+
		"NO\3\2\2\2OP\b\f\2\2P\30\3\2\2\2QR\7\61\2\2RS\7,\2\2S^\3\2\2\2T]\n\5\2"+
		"\2UW\7/\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2"+
		"\2[]\7\61\2\2\\T\3\2\2\2\\X\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3"+
		"\2\2\2`^\3\2\2\2ab\7,\2\2bl\7\61\2\2cd\7\61\2\2dh\7\61\2\2eg\n\6\2\2f"+
		"e\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2il\3\2\2\2jh\3\2\2\2kQ\3\2\2\2"+
		"kc\3\2\2\2lm\3\2\2\2mn\b\r\3\2n\32\3\2\2\2\r\29@GKMX\\^hk";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}