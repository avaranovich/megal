// Generated from MegaL.g4 by ANTLR 4.0

package megal.parser;

import megal.*;
import megal.model.*;
import java.util.List;
import java.util.LinkedList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MegaLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, ID=9, 
		STRING=10, WS=11, COMMENT=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "'extern'", "'+'", "'*'", "':'", "'@'", "'<'", "'intern'", 
		"ID", "STRING", "WS", "COMMENT"
	};
	public static final int
		RULE_model = 0, RULE_decl = 1, RULE_edecl = 2, RULE_rdecl = 3, RULE_modifier = 4, 
		RULE_etype = 5, RULE_ename = 6, RULE_name = 7, RULE_etdecl = 8, RULE_rtdecl = 9;
	public static final String[] ruleNames = {
		"model", "decl", "edecl", "rdecl", "modifier", "etype", "ename", "name", 
		"etdecl", "rtdecl"
	};

	@Override
	public String getGrammarFileName() { return "MegaL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


		public Model root;

	public MegaLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ModelContext extends ParserRuleContext {
		public DeclContext decl;
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitModel(this);
		}
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(20); ((ModelContext)_localctx).decl = decl();
				 root.getDecls().add(((ModelContext)_localctx).decl.d); 
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public Decl d;
		public EdeclContext edecl;
		public RdeclContext rdecl;
		public EtdeclContext etdecl;
		public RtdeclContext rtdecl;
		public EdeclContext edecl() {
			return getRuleContext(EdeclContext.class,0);
		}
		public RtdeclContext rtdecl() {
			return getRuleContext(RtdeclContext.class,0);
		}
		public RdeclContext rdecl() {
			return getRuleContext(RdeclContext.class,0);
		}
		public EtdeclContext etdecl() {
			return getRuleContext(EtdeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(28); ((DeclContext)_localctx).edecl = edecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).edecl.d; 
				}
				break;

			case 2:
				{
				setState(31); ((DeclContext)_localctx).rdecl = rdecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).rdecl.d; 
				}
				break;

			case 3:
				{
				setState(34); ((DeclContext)_localctx).etdecl = etdecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).etdecl.d; 
				}
				break;

			case 4:
				{
				setState(37); ((DeclContext)_localctx).rtdecl = rtdecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).rtdecl.d; 
				}
				break;
			}
			setState(42); match(1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EdeclContext extends ParserRuleContext {
		public EDecl d;
		public ModifierContext modifier;
		public EnameContext ename;
		public EtypeContext etype;
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public EnameContext ename() {
			return getRuleContext(EnameContext.class,0);
		}
		public EtypeContext etype() {
			return getRuleContext(EtypeContext.class,0);
		}
		public EdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterEdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitEdecl(this);
		}
	}

	public final EdeclContext edecl() throws RecognitionException {
		EdeclContext _localctx = new EdeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_edecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Modifier m = null; 
			setState(48);
			_la = _input.LA(1);
			if (_la==2 || _la==8) {
				{
				setState(45); ((EdeclContext)_localctx).modifier = modifier();
				 m = ((EdeclContext)_localctx).modifier.m; 
				}
			}

			setState(50); ((EdeclContext)_localctx).ename = ename();
			setState(51); match(5);
			setState(52); ((EdeclContext)_localctx).etype = etype();
			 ((EdeclContext)_localctx).d =  new EDecl(m, ((EdeclContext)_localctx).etype.t, ((EdeclContext)_localctx).ename.n); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RdeclContext extends ParserRuleContext {
		public RDecl d;
		public NameContext left;
		public Token ID;
		public NameContext right;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode ID() { return getToken(MegaLParser.ID, 0); }
		public RdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterRdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitRdecl(this);
		}
	}

	public final RdeclContext rdecl() throws RecognitionException {
		RdeclContext _localctx = new RdeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); ((RdeclContext)_localctx).left = name();
			setState(56); ((RdeclContext)_localctx).ID = match(ID);
			setState(57); ((RdeclContext)_localctx).right = name();
			 ((RdeclContext)_localctx).d =  new RDecl((((RdeclContext)_localctx).ID!=null?((RdeclContext)_localctx).ID.getText():null), ((RdeclContext)_localctx).left.n, ((RdeclContext)_localctx).right.n); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierContext extends ParserRuleContext {
		public Modifier m;
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitModifier(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_modifier);
		try {
			setState(64);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				setState(60); match(2);
				 ((ModifierContext)_localctx).m =  Modifier.Extern; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 2);
				{
				setState(62); match(8);
				 ((ModifierContext)_localctx).m =  Modifier.Intern; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EtypeContext extends ParserRuleContext {
		public EType t;
		public Token ID;
		public TerminalNode ID() { return getToken(MegaLParser.ID, 0); }
		public EtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterEtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitEtype(this);
		}
	}

	public final EtypeContext etype() throws RecognitionException {
		EtypeContext _localctx = new EtypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_etype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 EType.Cardinality c = EType.Cardinality.None; 
			setState(67); ((EtypeContext)_localctx).ID = match(ID);
			setState(72);
			switch (_input.LA(1)) {
			case 3:
				{
				setState(68); match(3);
				 c = EType.Cardinality.Plus; 
				}
				break;
			case 4:
				{
				setState(70); match(4);
				 c = EType.Cardinality.Star; 
				}
				break;
			case 1:
				break;
			default:
				throw new NoViableAltException(this);
			}
			 ((EtypeContext)_localctx).t =  new EType((((EtypeContext)_localctx).ID!=null?((EtypeContext)_localctx).ID.getText():null), c); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnameContext extends ParserRuleContext {
		public List<String> n;
		public NameContext n1;
		public NameContext n2;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public EnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterEname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitEname(this);
		}
	}

	public final EnameContext ename() throws RecognitionException {
		EnameContext _localctx = new EnameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<String> n = new LinkedList<String>(); 
			setState(77); ((EnameContext)_localctx).n1 = name();
			 n.add(((EnameContext)_localctx).n1.n); 
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6) {
				{
				{
				setState(79); match(6);
				setState(80); ((EnameContext)_localctx).n2 = name();
				 n.add(((EnameContext)_localctx).n2.n); 
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public String n;
		public Token ID;
		public Token STRING;
		public TerminalNode ID() { return getToken(MegaLParser.ID, 0); }
		public TerminalNode STRING() { return getToken(MegaLParser.STRING, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(88); ((NameContext)_localctx).ID = match(ID);
				 ((NameContext)_localctx).n =  (((NameContext)_localctx).ID!=null?((NameContext)_localctx).ID.getText():null); 
				}
				break;
			case STRING:
				{
				setState(90); ((NameContext)_localctx).STRING = match(STRING);
				 ((NameContext)_localctx).n =  (((NameContext)_localctx).STRING!=null?((NameContext)_localctx).STRING.getText():null).substring(1,(((NameContext)_localctx).STRING!=null?((NameContext)_localctx).STRING.getText():null).length()-2); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EtdeclContext extends ParserRuleContext {
		public ETDecl d;
		public Token subtype;
		public Token supertype;
		public TerminalNode ID(int i) {
			return getToken(MegaLParser.ID, i);
		}
		public List<TerminalNode> ID() { return getTokens(MegaLParser.ID); }
		public EtdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterEtdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitEtdecl(this);
		}
	}

	public final EtdeclContext etdecl() throws RecognitionException {
		EtdeclContext _localctx = new EtdeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_etdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); ((EtdeclContext)_localctx).subtype = match(ID);
			setState(95); match(7);
			setState(96); ((EtdeclContext)_localctx).supertype = match(ID);
			 ((EtdeclContext)_localctx).d =  new ETDecl((((EtdeclContext)_localctx).subtype!=null?((EtdeclContext)_localctx).subtype.getText():null), (((EtdeclContext)_localctx).supertype!=null?((EtdeclContext)_localctx).supertype.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RtdeclContext extends ParserRuleContext {
		public RTDecl d;
		public Token r;
		public Token arg1;
		public Token arg2;
		public TerminalNode ID(int i) {
			return getToken(MegaLParser.ID, i);
		}
		public List<TerminalNode> ID() { return getTokens(MegaLParser.ID); }
		public RtdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rtdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterRtdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitRtdecl(this);
		}
	}

	public final RtdeclContext rtdecl() throws RecognitionException {
		RtdeclContext _localctx = new RtdeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rtdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); ((RtdeclContext)_localctx).r = match(ID);
			setState(100); match(7);
			setState(101); ((RtdeclContext)_localctx).arg1 = match(ID);
			setState(102); match(4);
			setState(103); ((RtdeclContext)_localctx).arg2 = match(ID);
			 ((RtdeclContext)_localctx).d =  new RTDecl((((RtdeclContext)_localctx).r!=null?((RtdeclContext)_localctx).r.getText():null), (((RtdeclContext)_localctx).arg1!=null?((RtdeclContext)_localctx).arg1.getText():null), (((RtdeclContext)_localctx).arg2!=null?((RtdeclContext)_localctx).arg2.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\16m\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\3\2\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\5\4\63\n\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\5\6C\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7K\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\7\bV\n\b\f\b\16\bY\13\b\3\t\3\t\3\t\3\t\5\t_\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\2\f\2\4\6\b\n\f\16\20"+
		"\22\24\2\2l\2\33\3\2\2\2\4*\3\2\2\2\6.\3\2\2\2\b9\3\2\2\2\nB\3\2\2\2\f"+
		"D\3\2\2\2\16N\3\2\2\2\20^\3\2\2\2\22`\3\2\2\2\24e\3\2\2\2\26\27\5\4\3"+
		"\2\27\30\b\2\1\2\30\32\3\2\2\2\31\26\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2"+
		"\2\33\34\3\2\2\2\34\3\3\2\2\2\35\33\3\2\2\2\36\37\5\6\4\2\37 \b\3\1\2"+
		" +\3\2\2\2!\"\5\b\5\2\"#\b\3\1\2#+\3\2\2\2$%\5\22\n\2%&\b\3\1\2&+\3\2"+
		"\2\2\'(\5\24\13\2()\b\3\1\2)+\3\2\2\2*\36\3\2\2\2*!\3\2\2\2*$\3\2\2\2"+
		"*\'\3\2\2\2+,\3\2\2\2,-\7\3\2\2-\5\3\2\2\2.\62\b\4\1\2/\60\5\n\6\2\60"+
		"\61\b\4\1\2\61\63\3\2\2\2\62/\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65"+
		"\5\16\b\2\65\66\7\7\2\2\66\67\5\f\7\2\678\b\4\1\28\7\3\2\2\29:\5\20\t"+
		"\2:;\7\13\2\2;<\5\20\t\2<=\b\5\1\2=\t\3\2\2\2>?\7\4\2\2?C\b\6\1\2@A\7"+
		"\n\2\2AC\b\6\1\2B>\3\2\2\2B@\3\2\2\2C\13\3\2\2\2DE\b\7\1\2EJ\7\13\2\2"+
		"FG\7\5\2\2GK\b\7\1\2HI\7\6\2\2IK\b\7\1\2JF\3\2\2\2JH\3\2\2\2JK\3\2\2\2"+
		"KL\3\2\2\2LM\b\7\1\2M\r\3\2\2\2NO\b\b\1\2OP\5\20\t\2PW\b\b\1\2QR\7\b\2"+
		"\2RS\5\20\t\2ST\b\b\1\2TV\3\2\2\2UQ\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2"+
		"\2\2X\17\3\2\2\2YW\3\2\2\2Z[\7\13\2\2[_\b\t\1\2\\]\7\f\2\2]_\b\t\1\2^"+
		"Z\3\2\2\2^\\\3\2\2\2_\21\3\2\2\2`a\7\13\2\2ab\7\t\2\2bc\7\13\2\2cd\b\n"+
		"\1\2d\23\3\2\2\2ef\7\13\2\2fg\7\t\2\2gh\7\13\2\2hi\7\6\2\2ij\7\13\2\2"+
		"jk\b\13\1\2k\25\3\2\2\2\t\33*\62BJW^";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}