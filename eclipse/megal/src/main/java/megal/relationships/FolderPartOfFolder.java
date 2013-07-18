package megal.relationships;

import megal.entities.Folder;
import megal.model.RTypeDecl;

public class FolderPartOfFolder extends partOf<Folder, Folder> {

	protected FolderPartOfFolder(Folder first, Folder second, RTypeDecl rTypeDecl) {
		super(first, second, rTypeDecl);
 	}

}
