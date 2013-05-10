package megal.test;

import megal.trivia.Node;
import megal.trivia.Tree;

import org.junit.Test;

public class TypeResolutionTest extends BaseTest {
	
	@Test
	public void overloadingTest(){
		Tree<String> tree = new Tree<String>();
		Node<String> entity = tree.add("Entity");
		Node<String> artifact = tree.add("Artifact", entity);
		tree.add("Technology", entity);
		tree.add("Concept", entity);
		tree.add("File", artifact);
		Node<String> set = tree.add("Set", entity);
		Node<String> language = tree.add("Language", set);
		
		tree.print();
		
		System.out.println("Hierarchy for Language:");
		for(Node<String> n: language.getUpperHirerarchy()){
			System.out.println(n.getValue());
		}
		
		System.out.println("Hierarchy for Entity:");
		for(Node<String> n: entity.getUpperHirerarchy()){
			System.out.println(n.getValue());
		}
		
		System.out.println("Hierarchy for Artifact:");
		for(Node<String> n: artifact.getUpperHirerarchy()){
			System.out.println(n.getValue());
		}
	}
}
