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
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, ID=11, STRING=12, WS=13, COMMENT=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "'.'", "'extern'", "'+'", "'*'", "'['", "':'", "'@'", "'<'", "'intern'", 
		"ID", "STRING", "WS", "COMMENT"
	};
	public static final String[] ruleNames = {
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "ID", "STRING", "WS", "COMMENT"
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
		case 12: WS_action((RuleContext)_localctx, actionIndex); break;

		case 13: COMMENT_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4\20w\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\7\f@\n\f\f\f\16"+
		"\fC\13\f\3\r\3\r\7\rG\n\r\f\r\16\rJ\13\r\3\r\3\r\3\16\3\16\5\16P\n\16"+
		"\3\16\3\16\6\16T\n\16\r\16\16\16U\3\16\3\16\3\17\3\17\3\17\3\17\3\17\7"+
		"\17_\n\17\f\17\16\17b\13\17\3\17\7\17e\n\17\f\17\16\17h\13\17\3\17\3\17"+
		"\3\17\3\17\3\17\7\17o\n\17\f\17\16\17r\13\17\5\17t\n\17\3\17\3\17\2\20"+
		"\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27"+
		"\r\1\31\16\1\33\17\2\35\20\3\3\2\7\4C\\c|\6\62;C\\aac|\3$$\3,,\4\f\f\17"+
		"\17\u0081\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2"+
		"\2\7#\3\2\2\2\t*\3\2\2\2\13,\3\2\2\2\r.\3\2\2\2\17\60\3\2\2\2\21\62\3"+
		"\2\2\2\23\64\3\2\2\2\25\66\3\2\2\2\27=\3\2\2\2\31D\3\2\2\2\33S\3\2\2\2"+
		"\35s\3\2\2\2\37 \7_\2\2 \4\3\2\2\2!\"\7\60\2\2\"\6\3\2\2\2#$\7g\2\2$%"+
		"\7z\2\2%&\7v\2\2&\'\7g\2\2\'(\7t\2\2()\7p\2\2)\b\3\2\2\2*+\7-\2\2+\n\3"+
		"\2\2\2,-\7,\2\2-\f\3\2\2\2./\7]\2\2/\16\3\2\2\2\60\61\7<\2\2\61\20\3\2"+
		"\2\2\62\63\7B\2\2\63\22\3\2\2\2\64\65\7>\2\2\65\24\3\2\2\2\66\67\7k\2"+
		"\2\678\7p\2\289\7v\2\29:\7g\2\2:;\7t\2\2;<\7p\2\2<\26\3\2\2\2=A\t\2\2"+
		"\2>@\t\3\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\30\3\2\2\2CA\3\2"+
		"\2\2DH\7$\2\2EG\n\4\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2"+
		"\2\2JH\3\2\2\2KL\7$\2\2L\32\3\2\2\2MT\7\"\2\2NP\7\17\2\2ON\3\2\2\2OP\3"+
		"\2\2\2PQ\3\2\2\2QT\7\f\2\2RT\7\13\2\2SM\3\2\2\2SO\3\2\2\2SR\3\2\2\2TU"+
		"\3\2\2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\b\16\2\2X\34\3\2\2\2YZ\7\61\2"+
		"\2Z[\7,\2\2[f\3\2\2\2\\e\n\5\2\2]_\7/\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2"+
		"\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2ce\7\61\2\2d\\\3\2\2\2d`\3\2\2\2eh\3\2"+
		"\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7,\2\2jt\7\61\2\2kl\7\61"+
		"\2\2lp\7\61\2\2mo\n\6\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qt\3"+
		"\2\2\2rp\3\2\2\2sY\3\2\2\2sk\3\2\2\2tu\3\2\2\2uv\b\17\3\2v\36\3\2\2\2"+
		"\r\2AHOSU`dfps";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}