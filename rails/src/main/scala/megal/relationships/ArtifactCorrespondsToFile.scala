package megal
package relationships

import megal.model.RTypeDecl
import megal.relationships.core.correspondsTo

class ArtifactCorrespondsToFile[Artefact, File] extends correspondsTo[Artefact, File] {
  def correspondsTo (first: Artefact, second: File, rTypeDecl: RTypeDecl)  {
    super.correspondsTo(first, second, rTypeDecl)
  }
}