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
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, ID=11, STRING=12, WS=13, COMMENT=14;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'.'", "'extern'", "'+'", "'*'", "'['", "':'", "'@'", 
		"'<'", "'intern'", "ID", "STRING", "WS", "COMMENT"
	};
	public static final int
		RULE_model = 0, RULE_decl = 1, RULE_edecl = 2, RULE_rdecl = 3, RULE_modifier = 4, 
		RULE_etype = 5, RULE_ename = 6, RULE_rname = 7, RULE_etypename = 8, RULE_uqref = 9, 
		RULE_parent = 10, RULE_etdecl = 11, RULE_rtdecl = 12;
	public static final String[] ruleNames = {
		"model", "decl", "edecl", "rdecl", "modifier", "etype", "ename", "rname", 
		"etypename", "uqref", "parent", "etdecl", "rtdecl"
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
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 10) | (1L << ID))) != 0)) {
				{
				{
				setState(26); ((ModelContext)_localctx).decl = decl();
				 root.getDecls().add(((ModelContext)_localctx).decl.d); 
				}
				}
				setState(33);
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
			setState(46);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(34); ((DeclContext)_localctx).edecl = edecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).edecl.d; 
				}
				break;

			case 2:
				{
				setState(37); ((DeclContext)_localctx).rdecl = rdecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).rdecl.d; 
				}
				break;

			case 3:
				{
				setState(40); ((DeclContext)_localctx).etdecl = etdecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).etdecl.d; 
				}
				break;

			case 4:
				{
				setState(43); ((DeclContext)_localctx).rtdecl = rtdecl();
				 ((DeclContext)_localctx).d =  ((DeclContext)_localctx).rtdecl.d; 
				}
				break;
			}
			setState(48); match(2);
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
			setState(54);
			_la = _input.LA(1);
			if (_la==3 || _la==10) {
				{
				setState(51); ((EdeclContext)_localctx).modifier = modifier();
				 m = ((EdeclContext)_localctx).modifier.m; 
				}
			}

			setState(56); ((EdeclContext)_localctx).ename = ename();
			setState(57); ((EdeclContext)_localctx).uqref = uqref();
			setState(58); ((EdeclContext)_localctx).parent = parent();
			setState(59); match(7);
			setState(60); ((EdeclContext)_localctx).etype = etype();
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
			setState(63); ((RdeclContext)_localctx).left = ename();
			setState(64); ((RdeclContext)_localctx).rname = rname();
			setState(65); ((RdeclContext)_localctx).right = ename();
			 ((RdeclContext)_localctx).d =  new RDecl(((RdeclContext)_localctx).rname.n, ((RdeclContext)_localctx).left.n, ((RdeclContext)_localctx).right.n); 
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
			setState(72);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); match(3);
				 ((ModifierContext)_localctx).m =  Modifier.Extern; 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); match(10);
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
		public EtypenameContext etypename;
		public EtypenameContext etypename() {
			return getRuleContext(EtypenameContext.class,0);
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
		enterRule(_localctx, 10, RULE_etype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 EType.Cardinality c = EType.Cardinality.None; 
			setState(75); ((EtypeContext)_localctx).etypename = etypename();
			setState(80);
			switch (_input.LA(1)) {
			case 4:
				{
				setState(76); match(4);
				 c = EType.Cardinality.Plus; 
				}
				break;
			case 5:
				{
				setState(78); match(5);
				 c = EType.Cardinality.Star; 
				}
				break;
			case 2:
				break;
			default:
				throw new NoViableAltException(this);
			}
			 ((EtypeContext)_localctx).t =  new EType(((EtypeContext)_localctx).etypename.n, c); 
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
		enterRule(_localctx, 12, RULE_ename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); ((EnameContext)_localctx).ID = match(ID);
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
		enterRule(_localctx, 14, RULE_rname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); ((RnameContext)_localctx).ID = match(ID);
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
		enterRule(_localctx, 16, RULE_etypename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); ((EtypenameContext)_localctx).ID = match(ID);
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
		enterRule(_localctx, 18, RULE_uqref);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((UqrefContext)_localctx).s =  null; 
			setState(98);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(94); match(6);
				setState(95); ((UqrefContext)_localctx).STRING = match(STRING);
				 ((UqrefContext)_localctx).s =  (((UqrefContext)_localctx).STRING!=null?((UqrefContext)_localctx).STRING.getText():null).substring(1,(((UqrefContext)_localctx).STRING!=null?((UqrefContext)_localctx).STRING.getText():null).length()-2); 
				setState(97); match(1);
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
		enterRule(_localctx, 20, RULE_parent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ParentContext)_localctx).n =  null; 
			setState(105);
			_la = _input.LA(1);
			if (_la==8) {
				{
				setState(101); match(8);
				setState(102); ((ParentContext)_localctx).ename = ename();
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

	public static class EtdeclContext extends ParserRuleContext {
		public ETDecl d;
		public EtypenameContext subtype;
		public EtypenameContext supertype;
		public EtypenameContext etypename(int i) {
			return getRuleContext(EtypenameContext.class,i);
		}
		public List<EtypenameContext> etypename() {
			return getRuleContexts(EtypenameContext.class);
		}
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
		enterRule(_localctx, 22, RULE_etdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); ((EtdeclContext)_localctx).subtype = etypename();
			setState(108); match(9);
			setState(109); ((EtdeclContext)_localctx).supertype = etypename();
			 ((EtdeclContext)_localctx).d =  new ETDecl(((EtdeclContext)_localctx).subtype.n, ((EtdeclContext)_localctx).supertype.n); 
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
		public RnameContext r;
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
		enterRule(_localctx, 24, RULE_rtdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); ((RtdeclContext)_localctx).r = rname();
			setState(113); match(9);
			setState(114); ((RtdeclContext)_localctx).arg1 = etypename();
			setState(115); match(5);
			setState(116); ((RtdeclContext)_localctx).arg2 = etypename();
			 ((RtdeclContext)_localctx).d =  new RTDecl(((RtdeclContext)_localctx).r.n, ((RtdeclContext)_localctx).arg1.n, ((RtdeclContext)_localctx).arg2.n); 
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
		"\2\3\20z\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\7\2 \n\2\f"+
		"\2\16\2#\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\5\49\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6K\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7S\n"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\5\13e\n\13\3\f\3\f\3\f\3\f\3\f\5\fl\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2"+
		"\2v\2!\3\2\2\2\4\60\3\2\2\2\6\64\3\2\2\2\bA\3\2\2\2\nJ\3\2\2\2\fL\3\2"+
		"\2\2\16V\3\2\2\2\20Y\3\2\2\2\22\\\3\2\2\2\24_\3\2\2\2\26f\3\2\2\2\30m"+
		"\3\2\2\2\32r\3\2\2\2\34\35\5\4\3\2\35\36\b\2\1\2\36 \3\2\2\2\37\34\3\2"+
		"\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\3\3\2\2\2#!\3\2\2\2$%\5\6\4\2"+
		"%&\b\3\1\2&\61\3\2\2\2\'(\5\b\5\2()\b\3\1\2)\61\3\2\2\2*+\5\30\r\2+,\b"+
		"\3\1\2,\61\3\2\2\2-.\5\32\16\2./\b\3\1\2/\61\3\2\2\2\60$\3\2\2\2\60\'"+
		"\3\2\2\2\60*\3\2\2\2\60-\3\2\2\2\61\62\3\2\2\2\62\63\7\4\2\2\63\5\3\2"+
		"\2\2\648\b\4\1\2\65\66\5\n\6\2\66\67\b\4\1\2\679\3\2\2\28\65\3\2\2\28"+
		"9\3\2\2\29:\3\2\2\2:;\5\16\b\2;<\5\24\13\2<=\5\26\f\2=>\7\t\2\2>?\5\f"+
		"\7\2?@\b\4\1\2@\7\3\2\2\2AB\5\16\b\2BC\5\20\t\2CD\5\16\b\2DE\b\5\1\2E"+
		"\t\3\2\2\2FG\7\5\2\2GK\b\6\1\2HI\7\f\2\2IK\b\6\1\2JF\3\2\2\2JH\3\2\2\2"+
		"K\13\3\2\2\2LM\b\7\1\2MR\5\22\n\2NO\7\6\2\2OS\b\7\1\2PQ\7\7\2\2QS\b\7"+
		"\1\2RN\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\7\1\2U\r\3\2\2\2VW\7"+
		"\r\2\2WX\b\b\1\2X\17\3\2\2\2YZ\7\r\2\2Z[\b\t\1\2[\21\3\2\2\2\\]\7\r\2"+
		"\2]^\b\n\1\2^\23\3\2\2\2_d\b\13\1\2`a\7\b\2\2ab\7\16\2\2bc\b\13\1\2ce"+
		"\7\3\2\2d`\3\2\2\2de\3\2\2\2e\25\3\2\2\2fk\b\f\1\2gh\7\n\2\2hi\5\16\b"+
		"\2ij\b\f\1\2jl\3\2\2\2kg\3\2\2\2kl\3\2\2\2l\27\3\2\2\2mn\5\22\n\2no\7"+
		"\13\2\2op\5\22\n\2pq\b\r\1\2q\31\3\2\2\2rs\5\20\t\2st\7\13\2\2tu\5\22"+
		"\n\2uv\7\7\2\2vw\5\22\n\2wx\b\16\1\2x\33\3\2\2\2\t!\608JRdk";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}