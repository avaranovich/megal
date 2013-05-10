package megal.trivia;

import java.util.ArrayList;
import java.util.List;


public class Node<X> {
	
	private X value;
	private List<Node<X>> children;
	private Node<X> parent;
	
	public Node(X value){
		this.value = value;
		this.parent = null;
		this.children = new ArrayList<Node<X>>() ;
	}
	
	public List<Node<X>> getChildren() {
		return children;
	}

	public X getValue() {
		return value;
	}
	
	public Node<X> getParent() {
		return parent;
	}
	
	public void setParent(Node<X> value){
		if (value == parent){
			return;
		}

		this.parent = value; 
	}
	
	public List<Node<X>> getUpperHirerarchy(){
		List<Node<X>> parents = new ArrayList<Node<X>>();
		
		Node<X> parent = this.getParent();
		if (parent != null){
			parents.add(parent);
			parents.addAll(parent.getUpperHirerarchy());
		}
				
		return parents;
	}
	
	public Node<X> addChild(X value){
		Node<X> n = new Node<X>(value);
		n.setParent(this);
		this.children.add(n);
		
		return n;
	}
}
