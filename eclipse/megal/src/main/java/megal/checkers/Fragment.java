package megal.checkers;

public class Fragment {
	private String source;
	private String path;
	private String classifier;
	
	public Fragment(String classifier, String source, String path){
		this.classifier   = classifier;
		this.source = source;
		this.path   = path;
	}
	
	public String getSource(){
		return this.source;
	}
	
	public String getPath(){
		return this.path;
	}
	
	public String getName(){
		return this.classifier;
	}
}