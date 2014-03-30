package megal.checkers;

public class Fragment {
	private String source;
	private String path;
	private String name;
	
	public Fragment(String name, String source, String path){
		this.name   = name;
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
		return this.name;
	}
}