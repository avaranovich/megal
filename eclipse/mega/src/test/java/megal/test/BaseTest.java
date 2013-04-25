package megal.test;

public abstract class BaseTest {
	
	String getResorucePath(String relPath){
		return this.getClass().getResource(relPath).getPath();
	}
}
