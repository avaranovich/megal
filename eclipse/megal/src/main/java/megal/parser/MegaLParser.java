// Generated from MegaL.g4 by ANTLR 4.0

package megal.parser;

import megal.*;
import megal.model.*;

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
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, ID=18, STRING=19, WS=20, COMMENT=21, NEWLINE=22;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'->'", "'extern'", "'.'", "')'", "'+'", "'['", "'*'", 
		"':'", "'('", "'@'", "'<'", "'?'", "'#'", "'intern'", "'|'", "'!'", "ID", 
		"STRING", "WS", "COMMENT", "NEWLINE"
	};
	public static final int
		RULE_model = 0, RULE_decl = 1, RULE_edecl = 2, RULE_rdecl = 3, RULE_annotation = 4, 
		RULE_modifier = 5, RULE_etype = 6, RULE_genericarguments = 7, RULE_funappdecl = 8, 
		RULE_ename = 9, RULE_rname = 10, RULE_etypename = 11, RULE_uqref = 12, 
		RULE_parent = 13, RULE_etypedecl = 14, RULE_rtypedecl = 15;
	public static final String[] ruleNames = {
		"model", "decl", "edecl", "rdecl", "annotation", "modifier", "etype", 
		"genericarguments", "funappdecl", "ename", "rname", "etypename", "uqref", 
		"parent", "etypedecl", "rtypedecl"
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 13) | (1L << 15) | (1L << 17) | (1L << ID))) != 0)) {
				{
				{
				setState(32); ((ModelContext)_localctx).decl = decl();
				 root.getDecls().add(((ModelContext)_localctx).decl.d); 
				}
				}
				setState(39);
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
		public EtypedeclContext etypedecl;
		public RtypedeclContext rtypedecl;
		public FunappdeclContext funappdecl;
		public EdeclContext edecl() {
			return getRuleContext(EdeclContext.class,0);
		}
		public RtypedeclContext rtypedecl() {
			return getRuleContext(RtypedeclContext.class,0);
		}
		public RdeclContext rdecl() {
			return getRuleContext(RdeclContext.class,0);
		}
		public FunappdeclContext funappdecl() {
			return getRuleContext(FunappdeclContext.class,0);
		}
		public EtypedeclContext etypedecl() {
			return getRuleContext(EtypedeclContext.class,0);
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
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(40); ((DeclContext)_localctx).edecl = edecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).edecl.d; 
				}
				break;

			case 2:
				{
				setState(43); ((DeclContext)_localctx).rdecl = rdecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).rdecl.d; 
				}
				break;

			case 3:
				{
				setState(46); ((DeclContext)_localctx).etypedecl = etypedecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).etypedecl.d; 
				}
				break;

			case 4:
				{
				setState(49); ((DeclContext)_localctx).rtypedecl = rtypedecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).rtypedecl.d; 
				}
				break;

			case 5:
				{
				setState(52); ((DeclContext)_localctx).funappdecl = funappdecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).funappdecl.d; 
				}
				break;
			}
			setState(57); match(4);
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
		public UqrefContext uqref;
		public ParentContext parent;
		public EtypeContext etype;
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public UqrefContext uqref() {
			return getRuleContext(UqrefContext.class,0);
		}
		public EnameContext ename() {
			return getRuleContext(EnameContext.class,0);
		}
		public ParentContext parent() {
			return getRuleContext(ParentContext.class,0);
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
			setState(63);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 13) | (1L << 15) | (1L << 17))) != 0)) {
				{
				setState(60); ((EdeclContext)_localctx).modifier = modifier();
				 m = ((EdeclContext)_localctx).modifier.m; 
				}
			}

			setState(65); ((EdeclContext)_localctx).ename = ename();
			setState(66); ((EdeclContext)_localctx).uqref = uqref();
			setState(67); ((EdeclContext)_localctx).parent = parent();
			setState(68); match(9);
			setState(69); ((EdeclContext)_localctx).etype = etype();
			 ((EdeclContext)_localctx).d =  new EDecl(m, ((EdeclContext)_localctx).etype.t, ((EdeclContext)_localctx).ename.n, ((EdeclContext)_localctx).uqref.s, ((EdeclContext)_localctx).parent.n); 
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
		public EnameContext left;
		public RnameContext rname;
		public EnameContext right;
		public AnnotationContext ann;
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public List<EnameContext> ename() {
			return getRuleContexts(EnameContext.class);
		}
		public RnameContext rname() {
			return getRuleContext(RnameContext.class,0);
		}
		public EnameContext ename(int i) {
			return getRuleContext(EnameContext.class,i);
		}
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
			setState(72); ((RdeclContext)_localctx).left = ename();
			setState(73); ((RdeclContext)_localctx).rname = rname();
			setState(74); ((RdeclContext)_localctx).right = ename();
			setState(75); ((RdeclContext)_localctx).ann = annotation();
			 ((RdeclContext)_localctx).d =  new RDecl(((RdeclContext)_localctx).rname.n, ((RdeclContext)_localctx).left.n, ((RdeclContext)_localctx).right.n, ((RdeclContext)_localctx).ann.s); 
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

	public static class AnnotationContext extends ParserRuleContext {
		public String s;
		public EnameContext ename;
		public EnameContext ename() {
			return getRuleContext(EnameContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((AnnotationContext)_localctx).s =  null; 
			setState(83);
			_la = _input.LA(1);
			if (_la==14) {
				{
				setState(79); match(14);
				setState(80); ((AnnotationContext)_localctx).ename = ename();
				 ((AnnotationContext)_localctx).s =  ((AnnotationContext)_localctx).ename.n; 
				}
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
		enterRule(_localctx, 10, RULE_modifier);
		try {
			setState(93);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				setState(85); match(3);
				 ((ModifierContext)_localctx).m =  Modifier.Extern; 
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 2);
				{
				setState(87); match(15);
				 ((ModifierContext)_localctx).m =  Modifier.Intern; 
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 3);
				{
				setState(89); match(13);
				 ((ModifierContext)_localctx).m =  Modifier.Parameter; 
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 4);
				{
				setState(91); match(17);
				 ((ModifierContext)_localctx).m =  Modifier.Dependent; 
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
		public EtypenameContext etypename;
		public GenericargumentsContext genericarguments;
		public EtypenameContext etypename() {
			return getRuleContext(EtypenameContext.class,0);
		}
		public GenericargumentsContext genericarguments() {
			return getRuleContext(GenericargumentsContext.class,0);
		}
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
		enterRule(_localctx, 12, RULE_etype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 EType.Cardinality c = EType.Cardinality.None; 
			setState(96); ((EtypeContext)_localctx).etypename = etypename();
			setState(97); ((EtypeContext)_localctx).genericarguments = genericarguments();
			setState(102);
			switch (_input.LA(1)) {
			case 6:
				{
				setState(98); match(6);
				 c = EType.Cardinality.Plus; 
				}
				break;
			case 8:
				{
				setState(100); match(8);
				 c = EType.Cardinality.Star; 
				}
				break;
			case 4:
				break;
			default:
				throw new NoViableAltException(this);
			}
			 ((EtypeContext)_localctx).t =  new EType(((EtypeContext)_localctx).etypename.n, c, ((EtypeContext)_localctx).genericarguments.g); 
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

	public static class GenericargumentsContext extends ParserRuleContext {
		public GenericArguments g;
		public EtypenameContext etypename;
		public EtypenameContext etypename(int i) {
			return getRuleContext(EtypenameContext.class,i);
		}
		public List<EtypenameContext> etypename() {
			return getRuleContexts(EtypenameContext.class);
		}
		public GenericargumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericarguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterGenericarguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitGenericarguments(this);
		}
	}

	public final GenericargumentsContext genericarguments() throws RecognitionException {
		GenericargumentsContext _localctx = new GenericargumentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_genericarguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((GenericargumentsContext)_localctx).g =  null; String left = null; String right = null; 
			setState(115);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(107); match(7);
				setState(108); ((GenericargumentsContext)_localctx).etypename = etypename();
				left = ((GenericargumentsContext)_localctx).etypename.n; 
				setState(110); match(2);
				setState(111); ((GenericargumentsContext)_localctx).etypename = etypename();
				right = ((GenericargumentsContext)_localctx).etypename.n; 
				setState(113); match(1);
				}
			}

			 ((GenericargumentsContext)_localctx).g =  new GenericArguments(left, right); 
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

	public static class FunappdeclContext extends ParserRuleContext {
		public FunAppDecl d;
		public EnameContext ename;
		public List<EnameContext> ename() {
			return getRuleContexts(EnameContext.class);
		}
		public EnameContext ename(int i) {
			return getRuleContext(EnameContext.class,i);
		}
		public FunappdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funappdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterFunappdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitFunappdecl(this);
		}
	}

	public final FunappdeclContext funappdecl() throws RecognitionException {
		FunappdeclContext _localctx = new FunappdeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funappdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunappdeclContext)_localctx).d =  null; String n = null; String arg = null; String res = null; 
			setState(120); ((FunappdeclContext)_localctx).ename = ename();
			 n = ((FunappdeclContext)_localctx).ename.n; 
			setState(122); match(10);
			setState(123); ((FunappdeclContext)_localctx).ename = ename();
			 arg = ((FunappdeclContext)_localctx).ename.n; 
			setState(125); match(5);
			setState(126); match(16);
			setState(127); match(2);
			setState(128); ((FunappdeclContext)_localctx).ename = ename();
			 res = ((FunappdeclContext)_localctx).ename.n; 
			 ((FunappdeclContext)_localctx).d =  new FunAppDecl(n, arg, res); 
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
		public String n;
		public Token ID;
		public TerminalNode ID() { return getToken(MegaLParser.ID, 0); }
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
		enterRule(_localctx, 18, RULE_ename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); ((EnameContext)_localctx).ID = match(ID);
			 ((EnameContext)_localctx).n =  (((EnameContext)_localctx).ID!=null?((EnameContext)_localctx).ID.getText():null); 
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

	public static class RnameContext extends ParserRuleContext {
		public String n;
		public Token ID;
		public TerminalNode ID() { return getToken(MegaLParser.ID, 0); }
		public RnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterRname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitRname(this);
		}
	}

	public final RnameContext rname() throws RecognitionException {
		RnameContext _localctx = new RnameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); ((RnameContext)_localctx).ID = match(ID);
			 ((RnameContext)_localctx).n =  (((RnameContext)_localctx).ID!=null?((RnameContext)_localctx).ID.getText():null); 
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

	public static class EtypenameContext extends ParserRuleContext {
		public String n;
		public Token ID;
		public TerminalNode ID() { return getToken(MegaLParser.ID, 0); }
		public EtypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etypename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterEtypename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitEtypename(this);
		}
	}

	public final EtypenameContext etypename() throws RecognitionException {
		EtypenameContext _localctx = new EtypenameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_etypename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); ((EtypenameContext)_localctx).ID = match(ID);
			 ((EtypenameContext)_localctx).n =  (((EtypenameContext)_localctx).ID!=null?((EtypenameContext)_localctx).ID.getText():null); 
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

	public static class UqrefContext extends ParserRuleContext {
		public String s;
		public Token STRING;
		public TerminalNode STRING() { return getToken(MegaLParser.STRING, 0); }
		public UqrefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uqref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterUqref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitUqref(this);
		}
	}

	public final UqrefContext uqref() throws RecognitionException {
		UqrefContext _localctx = new UqrefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_uqref);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((UqrefContext)_localctx).s =  null; 
			setState(146);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(142); match(7);
				setState(143); ((UqrefContext)_localctx).STRING = match(STRING);
				 ((UqrefContext)_localctx).s =  (((UqrefContext)_localctx).STRING!=null?((UqrefContext)_localctx).STRING.getText():null).substring(1,(((UqrefContext)_localctx).STRING!=null?((UqrefContext)_localctx).STRING.getText():null).length()-2); 
				setState(145); match(1);
				}
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

	public static class ParentContext extends ParserRuleContext {
		public String n;
		public EnameContext ename;
		public EnameContext ename() {
			return getRuleContext(EnameContext.class,0);
		}
		public ParentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitParent(this);
		}
	}

	public final ParentContext parent() throws RecognitionException {
		ParentContext _localctx = new ParentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ParentContext)_localctx).n =  null; 
			setState(153);
			_la = _input.LA(1);
			if (_la==11) {
				{
				setState(149); match(11);
				setState(150); ((ParentContext)_localctx).ename = ename();
				 ((ParentContext)_localctx).n =  ((ParentContext)_localctx).ename.n; 
				}
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

	public static class EtypedeclContext extends ParserRuleContext {
		public ETypeDecl d;
		public EtypenameContext name;
		public EtypenameContext supertype;
		public EtypenameContext etypename(int i) {
			return getRuleContext(EtypenameContext.class,i);
		}
		public List<EtypenameContext> etypename() {
			return getRuleContexts(EtypenameContext.class);
		}
		public EtypedeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etypedecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterEtypedecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitEtypedecl(this);
		}
	}

	public final EtypedeclContext etypedecl() throws RecognitionException {
		EtypedeclContext _localctx = new EtypedeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_etypedecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); ((EtypedeclContext)_localctx).name = etypename();
			setState(156); match(12);
			setState(157); ((EtypedeclContext)_localctx).supertype = etypename();
			 ((EtypedeclContext)_localctx).d =  new ETypeDecl(((EtypedeclContext)_localctx).name.n, ((EtypedeclContext)_localctx).supertype.n); 
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

	public static class RtypedeclContext extends ParserRuleContext {
		public RTypeDecl d;
		public RnameContext name;
		public EtypenameContext arg1;
		public EtypenameContext arg2;
		public EtypenameContext etypename(int i) {
			return getRuleContext(EtypenameContext.class,i);
		}
		public List<EtypenameContext> etypename() {
			return getRuleContexts(EtypenameContext.class);
		}
		public RnameContext rname() {
			return getRuleContext(RnameContext.class,0);
		}
		public RtypedeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rtypedecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterRtypedecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitRtypedecl(this);
		}
	}

	public final RtypedeclContext rtypedecl() throws RecognitionException {
		RtypedeclContext _localctx = new RtypedeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_rtypedecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); ((RtypedeclContext)_localctx).name = rname();
			setState(161); match(12);
			setState(162); ((RtypedeclContext)_localctx).arg1 = etypename();
			setState(163); match(8);
			setState(164); ((RtypedeclContext)_localctx).arg2 = etypename();
			 ((RtypedeclContext)_localctx).d =  new RTypeDecl(((RtypedeclContext)_localctx).name.n, ((RtypedeclContext)_localctx).arg1.n, ((RtypedeclContext)_localctx).arg2.n); 
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
		"\2\3\30\u00aa\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\3\2\3\2\3\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3:\n\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\5\4B\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\5\6V\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7`\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\bi\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\tv\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\5\16\u0095\n\16\3\17\3\17\3\17\3\17\3\17\5\17\u009c\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\2\22\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \2\2\u00a8\2\'\3\2\2\2\49\3\2\2\2\6=\3\2"+
		"\2\2\bJ\3\2\2\2\nP\3\2\2\2\f_\3\2\2\2\16a\3\2\2\2\20l\3\2\2\2\22y\3\2"+
		"\2\2\24\u0086\3\2\2\2\26\u0089\3\2\2\2\30\u008c\3\2\2\2\32\u008f\3\2\2"+
		"\2\34\u0096\3\2\2\2\36\u009d\3\2\2\2 \u00a2\3\2\2\2\"#\5\4\3\2#$\b\2\1"+
		"\2$&\3\2\2\2%\"\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)\'"+
		"\3\2\2\2*+\5\6\4\2+,\b\3\1\2,:\3\2\2\2-.\5\b\5\2./\b\3\1\2/:\3\2\2\2\60"+
		"\61\5\36\20\2\61\62\b\3\1\2\62:\3\2\2\2\63\64\5 \21\2\64\65\b\3\1\2\65"+
		":\3\2\2\2\66\67\5\22\n\2\678\b\3\1\28:\3\2\2\29*\3\2\2\29-\3\2\2\29\60"+
		"\3\2\2\29\63\3\2\2\29\66\3\2\2\2:;\3\2\2\2;<\7\6\2\2<\5\3\2\2\2=A\b\4"+
		"\1\2>?\5\f\7\2?@\b\4\1\2@B\3\2\2\2A>\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\5\24"+
		"\13\2DE\5\32\16\2EF\5\34\17\2FG\7\13\2\2GH\5\16\b\2HI\b\4\1\2I\7\3\2\2"+
		"\2JK\5\24\13\2KL\5\26\f\2LM\5\24\13\2MN\5\n\6\2NO\b\5\1\2O\t\3\2\2\2P"+
		"U\b\6\1\2QR\7\20\2\2RS\5\24\13\2ST\b\6\1\2TV\3\2\2\2UQ\3\2\2\2UV\3\2\2"+
		"\2V\13\3\2\2\2WX\7\5\2\2X`\b\7\1\2YZ\7\21\2\2Z`\b\7\1\2[\\\7\17\2\2\\"+
		"`\b\7\1\2]^\7\23\2\2^`\b\7\1\2_W\3\2\2\2_Y\3\2\2\2_[\3\2\2\2_]\3\2\2\2"+
		"`\r\3\2\2\2ab\b\b\1\2bc\5\30\r\2ch\5\20\t\2de\7\b\2\2ei\b\b\1\2fg\7\n"+
		"\2\2gi\b\b\1\2hd\3\2\2\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\b\b\1\2k\17\3"+
		"\2\2\2lu\b\t\1\2mn\7\t\2\2no\5\30\r\2op\b\t\1\2pq\7\4\2\2qr\5\30\r\2r"+
		"s\b\t\1\2st\7\3\2\2tv\3\2\2\2um\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\b\t\1\2"+
		"x\21\3\2\2\2yz\b\n\1\2z{\5\24\13\2{|\b\n\1\2|}\7\f\2\2}~\5\24\13\2~\177"+
		"\b\n\1\2\177\u0080\7\7\2\2\u0080\u0081\7\22\2\2\u0081\u0082\7\4\2\2\u0082"+
		"\u0083\5\24\13\2\u0083\u0084\b\n\1\2\u0084\u0085\b\n\1\2\u0085\23\3\2"+
		"\2\2\u0086\u0087\7\24\2\2\u0087\u0088\b\13\1\2\u0088\25\3\2\2\2\u0089"+
		"\u008a\7\24\2\2\u008a\u008b\b\f\1\2\u008b\27\3\2\2\2\u008c\u008d\7\24"+
		"\2\2\u008d\u008e\b\r\1\2\u008e\31\3\2\2\2\u008f\u0094\b\16\1\2\u0090\u0091"+
		"\7\t\2\2\u0091\u0092\7\25\2\2\u0092\u0093\b\16\1\2\u0093\u0095\7\3\2\2"+
		"\u0094\u0090\3\2\2\2\u0094\u0095\3\2\2\2\u0095\33\3\2\2\2\u0096\u009b"+
		"\b\17\1\2\u0097\u0098\7\r\2\2\u0098\u0099\5\24\13\2\u0099\u009a\b\17\1"+
		"\2\u009a\u009c\3\2\2\2\u009b\u0097\3\2\2\2\u009b\u009c\3\2\2\2\u009c\35"+
		"\3\2\2\2\u009d\u009e\5\30\r\2\u009e\u009f\7\16\2\2\u009f\u00a0\5\30\r"+
		"\2\u00a0\u00a1\b\20\1\2\u00a1\37\3\2\2\2\u00a2\u00a3\5\26\f\2\u00a3\u00a4"+
		"\7\16\2\2\u00a4\u00a5\5\30\r\2\u00a5\u00a6\7\n\2\2\u00a6\u00a7\5\30\r"+
		"\2\u00a7\u00a8\b\21\1\2\u00a8!\3\2\2\2\13\'9AU_hu\u0094\u009b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}