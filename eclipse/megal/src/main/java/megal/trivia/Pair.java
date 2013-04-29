package megal.trivia;

public class Pair<X,Y> {

	public X first;
	public Y second;
	
	public Pair(X first, Y second) {
		this.first = first;
		this.second = second;
	}
	
	 @Override public boolean equals(Object aThat) {
		 //check for self-comparison
		 if (this == aThat) return true;
		 
		 if (!(aThat instanceof Pair<?,?>)) return false;
		 
		 Pair<?,?> that = (Pair<?,?>)aThat;
		 
		 return ((this.first.equals(that.first)) && (this.second.equals(that.second)));	
	 }
	 
	 @Override public String toString(){
		return "(" + first +"," + second + ")"; 
	 }
}
