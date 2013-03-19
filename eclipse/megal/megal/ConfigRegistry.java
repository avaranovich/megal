package megal;

public class ConfigRegistry {
	private static ConfigRegistry instance = null;
	protected ConfigRegistry() {
		// Exists only to defeat instantiation.
	}
	public static ConfigRegistry getInstance() {
		if(instance == null) {
	         instance = new ConfigRegistry();
	     }
	     return instance;
	}
	   
	public static ConfigRegistry fromFile(String file) {
		if(instance == null) {
			instance = new ConfigRegistry();
		}
		return instance;
	}
}
