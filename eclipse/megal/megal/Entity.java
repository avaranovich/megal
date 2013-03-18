package megal;

import megal.model.EDecl;

public interface Entity {
	boolean tryResolve(EDecl entity);
}
