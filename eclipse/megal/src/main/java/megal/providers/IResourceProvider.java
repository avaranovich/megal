package megal.providers;

import megal.model.EDecl;

public interface IResourceProvider {
	String getURL(@SuppressWarnings("rawtypes") final EDecl eDecl);
}
