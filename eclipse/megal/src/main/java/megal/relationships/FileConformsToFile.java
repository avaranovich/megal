package megal.relationships;

import megal.entities.File;
import megal.model.RTypeDecl;
import megal.relationships.core.conformsTo;

public class FileConformsToFile extends conformsTo<File, File> {

	protected FileConformsToFile(File first, File second, RTypeDecl rTypeDecl) {
		super(first, second, rTypeDecl);
	}

}
