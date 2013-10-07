package megal.analysis;

import static megal.Context.eventBus;
import megal.events.NotWellFormedRelationshipDetected;
import megal.events.RelationshipEvaluationFailed;
import megal.events.RelationshipEvaluationStarted;
import megal.model.RDecl;
import megal.model.Visitor;
import megal.relationships.WeakRel;
import megal.relationships.core.Relationship;

/*
 * Checks all the relationships in the megamodel.
 */
public class Checking extends Visitor { 

	public void visit(RDecl decl) {
		Relationship<?,?> rel = decl.getRelationship();
		
		if (!rel.wellFormed()){
			eventBus.post(new NotWellFormedRelationshipDetected(decl));
			return;
		}
		
		// check if the relationship is "weak"
		if (rel.getClass().isAnnotationPresent(WeakRel.class)){
			// we don't evaluate it
			eventBus.post(new RelationshipEvaluationStarted(rel.getLeft(), rel.getRight(), rel));
		}
		else{
			System.out.println(String.format("Evaluating relationship %s %s : %s using %s", 
					rel.getLeft(), rel.getTypeDecl().getName(), rel.getRight(), rel.getSrc()));
			
			eventBus.post(new RelationshipEvaluationStarted(rel.getLeft(), rel.getRight(), rel));
			boolean res = rel.evaluate();
			if (res == false){
				eventBus.post(new RelationshipEvaluationFailed(rel.getLeft(), rel.getRight(), rel));
			}
		}		
	}
}
