package megal.trivia;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;

public class Tree <X>{
	
	private List<Node<X>> nodes;
	
	public Tree(){
		nodes = new ArrayList<Node<X>>();
	}
	
	public Node<X> find(X value){
		for(Node<X> node: nodes){
			if (node.getValue().equals(value)){
				return node;
			}
			else{
				Integer idx = node.getChildren().indexOf(value);
				return node.getChildren().get(idx);
			}
		}
		
		return null;
	}
	
	public boolean contains(Node<X> node){
		return nodes.contains(node);
	}
		
	public Node<X> add(X value){
		Node<X> n = new Node<X>(value);
		this.nodes.add(n);
		return n;
	}
	
	public Node<X> add(X value, Node<X> parent){
		Node<X> n = new Node<X>(value);
		
		if (parent == null){
			nodes.add(n);
		} else{
			n = parent.addChild(value);
		}
		
		return n;
	}
	
	public void print(){
		Function<Node<X>, Void> print = new Function<Node<X>, Void>() {
			  public Void apply(Node<X> n) {
				 System.out.println(n.getValue() + ";");
				 return null;
			  }
			};
			
		for (Node<X> n: this.nodes){
			printPostorder(n, print);
		}
	}
	
	public List<Node<X>> getNodesPostOrder(){
		return null;
	}
	
	/* Given a tree, print its nodes according to the
	  "bottom-up" postorder traversal. */
	private void printPostorder(Node<X> node, Function<Node<X>, Void> action){
	     if (node == null)
	        return;
	 
	     for(Node<X> n: node.getChildren()){
	    	 printPostorder(n, action);
	     }
	 
	     action.apply(node);
	}
}
