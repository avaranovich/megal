package megal;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class ConfigRegistry {
	private static ConfigRegistry instance = null;
	protected Config config;
	
	protected ConfigRegistry(String file) throws IOException {
		Gson g = new Gson();
		String content;
		File f = new File(file);
		FileReader reader = null;
		
		try {
			reader = new FileReader(f);
		    char[] chars = new char[(int) file.length()];
		    reader.read(chars);
		    content = new String(chars);
		} finally {
			if (reader != null){
				reader.close();
			}
		}
		
		config = g.fromJson(content, Config.class);
	}
	
	public Config getConfig() { return config; }
	   
	public static ConfigRegistry fromFile(String file) {
		if(instance == null) {
			try {
				instance = new ConfigRegistry(file);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return instance;
	}
}