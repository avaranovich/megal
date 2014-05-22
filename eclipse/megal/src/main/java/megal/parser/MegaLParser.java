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
		T__0=17, ID=18, NEWLINE=19, STRING=20, WS=21, COMMENT=22;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'->'", "'extern'", "')'", "'.'", "'+'", "'['", "'*'", 
		"'('", "':'", "'@'", "'<'", "'?'", "'#'", "'intern'", "'|'", "'!'", "ID", 
		"NEWLINE", "STRING", "WS", "COMMENT"
	};
	public static final int
		RULE_model = 0, RULE_decl = 1, RULE_edecl = 2, RULE_rdecl = 3, RULE_annotation = 4, 
		RULE_modifier = 5, RULE_etype = 6, RULE_genericarguments = 7, RULE_funappdecl = 8, 
		RULE_ename = 9, RULE_rname = 10, RULE_id = 11, RULE_etypename = 12, RULE_uqref = 13, 
		RULE_parent = 14, RULE_etypedecl = 15, RULE_rtypedecl = 16, RULE_dot = 17;
	public static final String[] ruleNames = {
		"model", "decl", "edecl", "rdecl", "annotation", "modifier", "etype", 
		"genericarguments", "funappdecl", "ename", "rname", "id", "etypename", 
		"uqref", "parent", "etypedecl", "rtypedecl", "dot"
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 13) | (1L << 15) | (1L << 17) | (1L << ID))) != 0)) {
				{
				{
				setState(36); ((ModelContext)_localctx).decl = decl();
				 root.getDecls().add(((ModelContext)_localctx).decl.d); 
				}
				}
				setState(43);
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
		public DotContext dot() {
			return getRuleContext(DotContext.class,0);
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
			setState(59);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(44); ((DeclContext)_localctx).edecl = edecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).edecl.d; 
				}
				break;

			case 2:
				{
				setState(47); ((DeclContext)_localctx).rdecl = rdecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).rdecl.d; 
				}
				break;

			case 3:
				{
				setState(50); ((DeclContext)_localctx).etypedecl = etypedecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).etypedecl.d; 
				}
				break;

			case 4:
				{
				setState(53); ((DeclContext)_localctx).rtypedecl = rtypedecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).rtypedecl.d; 
				}
				break;

			case 5:
				{
				setState(56); ((DeclContext)_localctx).funappdecl = funappdecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).funappdecl.d; 
				}
				break;
			}
			setState(61); dot();
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
			setState(67);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 13) | (1L << 15) | (1L << 17))) != 0)) {
				{
				setState(64); ((EdeclContext)_localctx).modifier = modifier();
				 m = ((EdeclContext)_localctx).modifier.m; 
				}
			}

			setState(69); ((EdeclContext)_localctx).ename = ename();
			setState(70); ((EdeclContext)_localctx).uqref = uqref();
			setState(71); ((EdeclContext)_localctx).parent = parent();
			setState(72); match(10);
			setState(73); ((EdeclContext)_localctx).etype = etype();
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
			setState(76); ((RdeclContext)_localctx).left = ename();
			setState(77); ((RdeclContext)_localctx).rname = rname();
			setState(78); ((RdeclContext)_localctx).right = ename();
			setState(79); ((RdeclContext)_localctx).ann = annotation();
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
			setState(87);
			_la = _input.LA(1);
			if (_la==14) {
				{
				setState(83); match(14);
				setState(84); ((AnnotationContext)_localctx).ename = ename();
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
			setState(97);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				setState(89); match(3);
				 ((ModifierContext)_localctx).m =  Modifier.Extern; 
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 2);
				{
				setState(91); match(15);
				 ((ModifierContext)_localctx).m =  Modifier.Intern; 
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 3);
				{
				setState(93); match(13);
				 ((ModifierContext)_localctx).m =  Modifier.Parameter; 
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 4);
				{
				setState(95); match(17);
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
			setState(100); ((EtypeContext)_localctx).etypename = etypename();
			setState(101); ((EtypeContext)_localctx).genericarguments = genericarguments();
			setState(106);
			switch (_input.LA(1)) {
			case 6:
				{
				setState(102); match(6);
				 c = EType.Cardinality.Plus; 
				}
				break;
			case 8:
				{
				setState(104); match(8);
				 c = EType.Cardinality.Star; 
				}
				break;
			case NEWLINE:
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
			setState(119);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(111); match(7);
				setState(112); ((GenericargumentsContext)_localctx).etypename = etypename();
				left = ((GenericargumentsContext)_localctx).etypename.n; 
				setState(114); match(2);
				setState(115); ((GenericargumentsContext)_localctx).etypename = etypename();
				right = ((GenericargumentsContext)_localctx).etypename.n; 
				setState(117); match(1);
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
			setState(124); ((FunappdeclContext)_localctx).ename = ename();
			 n = ((FunappdeclContext)_localctx).ename.n; 
			setState(126); match(9);
			setState(127); ((FunappdeclContext)_localctx).ename = ename();
			 arg = ((FunappdeclContext)_localctx).ename.n; 
			setState(129); match(4);
			setState(130); match(16);
			setState(131); match(2);
			setState(132); ((FunappdeclContext)_localctx).ename = ename();
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
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
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
		enterRule(_localctx, 18, RULE_ename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); ((EnameContext)_localctx).id = id();
			 ((EnameContext)_localctx).n =  (((EnameContext)_localctx).id!=null?_input.getText(((EnameContext)_localctx).id.start,((EnameContext)_localctx).id.stop):null); 
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
			setState(139); ((RnameContext)_localctx).ID = match(ID);
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID(int i) {
			return getToken(MegaLParser.ID, i);
		}
		public List<TerminalNode> ID() { return getTokens(MegaLParser.ID); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(ID);
			setState(145);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(143); match(5);
				setState(144); match(ID);
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

	public static class EtypenameContext extends ParserRuleContext {
		public String n;
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_etypename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); ((EtypenameContext)_localctx).id = id();
			 ((EtypenameContext)_localctx).n =  (((EtypenameContext)_localctx).id!=null?_input.getText(((EtypenameContext)_localctx).id.start,((EtypenameContext)_localctx).id.stop):null); 
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
		enterRule(_localctx, 26, RULE_uqref);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((UqrefContext)_localctx).s =  null; 
			setState(155);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(151); match(7);
				setState(152); ((UqrefContext)_localctx).STRING = match(STRING);
				 ((UqrefContext)_localctx).s =  (((UqrefContext)_localctx).STRING!=null?((UqrefContext)_localctx).STRING.getText():null).substring(1,(((UqrefContext)_localctx).STRING!=null?((UqrefContext)_localctx).STRING.getText():null).length()-2); 
				setState(154); match(1);
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
		enterRule(_localctx, 28, RULE_parent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ParentContext)_localctx).n =  null; 
			setState(162);
			_la = _input.LA(1);
			if (_la==11) {
				{
				setState(158); match(11);
				setState(159); ((ParentContext)_localctx).ename = ename();
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
		enterRule(_localctx, 30, RULE_etypedecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); ((EtypedeclContext)_localctx).name = etypename();
			setState(165); match(12);
			setState(166); ((EtypedeclContext)_localctx).supertype = etypename();
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
		enterRule(_localctx, 32, RULE_rtypedecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); ((RtypedeclContext)_localctx).name = rname();
			setState(170); match(12);
			setState(171); ((RtypedeclContext)_localctx).arg1 = etypename();
			setState(172); match(8);
			setState(173); ((RtypedeclContext)_localctx).arg2 = etypename();
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

	public static class DotContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(MegaLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MegaLParser.NEWLINE, i);
		}
		public DotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).enterDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegaLListener ) ((MegaLListener)listener).exitDot(this);
		}
	}

	public final DotContext dot() throws RecognitionException {
		DotContext _localctx = new DotContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_dot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(176); match(NEWLINE);
				}
				}
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
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
		"\2\3\30\u00b8\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\3\2\3\2\3\2\7\2*\n\2\f\2\16\2-\13\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3>\n\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\5\4F\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6Z\n\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7d\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bm\n\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tz\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\5"+
		"\r\u0094\n\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u009e\n\17\3"+
		"\20\3\20\3\20\3\20\3\20\5\20\u00a5\n\20\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\6\23\u00b4\n\23\r\23\16\23\u00b5\3"+
		"\23\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\2\u00b6\2+\3\2\2"+
		"\2\4=\3\2\2\2\6A\3\2\2\2\bN\3\2\2\2\nT\3\2\2\2\fc\3\2\2\2\16e\3\2\2\2"+
		"\20p\3\2\2\2\22}\3\2\2\2\24\u008a\3\2\2\2\26\u008d\3\2\2\2\30\u0090\3"+
		"\2\2\2\32\u0095\3\2\2\2\34\u0098\3\2\2\2\36\u009f\3\2\2\2 \u00a6\3\2\2"+
		"\2\"\u00ab\3\2\2\2$\u00b3\3\2\2\2&\'\5\4\3\2\'(\b\2\1\2(*\3\2\2\2)&\3"+
		"\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3\3\2\2\2-+\3\2\2\2./\5\6\4\2/\60"+
		"\b\3\1\2\60>\3\2\2\2\61\62\5\b\5\2\62\63\b\3\1\2\63>\3\2\2\2\64\65\5 "+
		"\21\2\65\66\b\3\1\2\66>\3\2\2\2\678\5\"\22\289\b\3\1\29>\3\2\2\2:;\5\22"+
		"\n\2;<\b\3\1\2<>\3\2\2\2=.\3\2\2\2=\61\3\2\2\2=\64\3\2\2\2=\67\3\2\2\2"+
		"=:\3\2\2\2>?\3\2\2\2?@\5$\23\2@\5\3\2\2\2AE\b\4\1\2BC\5\f\7\2CD\b\4\1"+
		"\2DF\3\2\2\2EB\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\5\24\13\2HI\5\34\17\2IJ\5"+
		"\36\20\2JK\7\f\2\2KL\5\16\b\2LM\b\4\1\2M\7\3\2\2\2NO\5\24\13\2OP\5\26"+
		"\f\2PQ\5\24\13\2QR\5\n\6\2RS\b\5\1\2S\t\3\2\2\2TY\b\6\1\2UV\7\20\2\2V"+
		"W\5\24\13\2WX\b\6\1\2XZ\3\2\2\2YU\3\2\2\2YZ\3\2\2\2Z\13\3\2\2\2[\\\7\5"+
		"\2\2\\d\b\7\1\2]^\7\21\2\2^d\b\7\1\2_`\7\17\2\2`d\b\7\1\2ab\7\23\2\2b"+
		"d\b\7\1\2c[\3\2\2\2c]\3\2\2\2c_\3\2\2\2ca\3\2\2\2d\r\3\2\2\2ef\b\b\1\2"+
		"fg\5\32\16\2gl\5\20\t\2hi\7\b\2\2im\b\b\1\2jk\7\n\2\2km\b\b\1\2lh\3\2"+
		"\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\b\b\1\2o\17\3\2\2\2py\b\t\1\2qr\7"+
		"\t\2\2rs\5\32\16\2st\b\t\1\2tu\7\4\2\2uv\5\32\16\2vw\b\t\1\2wx\7\3\2\2"+
		"xz\3\2\2\2yq\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\b\t\1\2|\21\3\2\2\2}~\b\n\1"+
		"\2~\177\5\24\13\2\177\u0080\b\n\1\2\u0080\u0081\7\13\2\2\u0081\u0082\5"+
		"\24\13\2\u0082\u0083\b\n\1\2\u0083\u0084\7\6\2\2\u0084\u0085\7\22\2\2"+
		"\u0085\u0086\7\4\2\2\u0086\u0087\5\24\13\2\u0087\u0088\b\n\1\2\u0088\u0089"+
		"\b\n\1\2\u0089\23\3\2\2\2\u008a\u008b\5\30\r\2\u008b\u008c\b\13\1\2\u008c"+
		"\25\3\2\2\2\u008d\u008e\7\24\2\2\u008e\u008f\b\f\1\2\u008f\27\3\2\2\2"+
		"\u0090\u0093\7\24\2\2\u0091\u0092\7\7\2\2\u0092\u0094\7\24\2\2\u0093\u0091"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\31\3\2\2\2\u0095\u0096\5\30\r\2\u0096"+
		"\u0097\b\16\1\2\u0097\33\3\2\2\2\u0098\u009d\b\17\1\2\u0099\u009a\7\t"+
		"\2\2\u009a\u009b\7\26\2\2\u009b\u009c\b\17\1\2\u009c\u009e\7\3\2\2\u009d"+
		"\u0099\3\2\2\2\u009d\u009e\3\2\2\2\u009e\35\3\2\2\2\u009f\u00a4\b\20\1"+
		"\2\u00a0\u00a1\7\r\2\2\u00a1\u00a2\5\24\13\2\u00a2\u00a3\b\20\1\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\37\3\2\2"+
		"\2\u00a6\u00a7\5\32\16\2\u00a7\u00a8\7\16\2\2\u00a8\u00a9\5\32\16\2\u00a9"+
		"\u00aa\b\21\1\2\u00aa!\3\2\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00ad\7\16\2"+
		"\2\u00ad\u00ae\5\32\16\2\u00ae\u00af\7\n\2\2\u00af\u00b0\5\32\16\2\u00b0"+
		"\u00b1\b\22\1\2\u00b1#\3\2\2\2\u00b2\u00b4\7\25\2\2\u00b3\u00b2\3\2\2"+
		"\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6%"+
		"\3\2\2\2\r+=EYcly\u0093\u009d\u00a4\u00b5";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}