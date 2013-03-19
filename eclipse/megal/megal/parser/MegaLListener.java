// Generated from MegaL.g4 by ANTLR 4.0

package megal.parser;

import megal.*;
import megal.model.*;
import java.util.List;
import java.util.LinkedList;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MegaLListener extends ParseTreeListener {
	void enterModel(MegaLParser.ModelContext ctx);
	void exitModel(MegaLParser.ModelContext ctx);

	void enterRname(MegaLParser.RnameContext ctx);
	void exitRname(MegaLParser.RnameContext ctx);

	void enterParent(MegaLParser.ParentContext ctx);
	void exitParent(MegaLParser.ParentContext ctx);

	void enterModifier(MegaLParser.ModifierContext ctx);
	void exitModifier(MegaLParser.ModifierContext ctx);

	void enterEdecl(MegaLParser.EdeclContext ctx);
	void exitEdecl(MegaLParser.EdeclContext ctx);

	void enterRdecl(MegaLParser.RdeclContext ctx);
	void exitRdecl(MegaLParser.RdeclContext ctx);

	void enterEname(MegaLParser.EnameContext ctx);
	void exitEname(MegaLParser.EnameContext ctx);

	void enterUqref(MegaLParser.UqrefContext ctx);
	void exitUqref(MegaLParser.UqrefContext ctx);

	void enterRtdecl(MegaLParser.RtdeclContext ctx);
	void exitRtdecl(MegaLParser.RtdeclContext ctx);

	void enterEtypename(MegaLParser.EtypenameContext ctx);
	void exitEtypename(MegaLParser.EtypenameContext ctx);

	void enterEtdecl(MegaLParser.EtdeclContext ctx);
	void exitEtdecl(MegaLParser.EtdeclContext ctx);

	void enterEtype(MegaLParser.EtypeContext ctx);
	void exitEtype(MegaLParser.EtypeContext ctx);

	void enterDecl(MegaLParser.DeclContext ctx);
	void exitDecl(MegaLParser.DeclContext ctx);
}