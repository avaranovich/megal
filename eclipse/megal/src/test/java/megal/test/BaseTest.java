package megal.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Before;

import megal.Context;
import megal.Tool;
import megal.logging.Log;
import megal.model.Model;

public abstract class BaseTest {
	
	@Before
	public void setUp(){
		//
		// This code needs to be factored/abstracted.
		//
		Model model = new Model();
		Log log = new Log();
		Context.model = model;
		Context.log = log;
		
		Tool.parse(getResorucePath("/prelude.megal"));
	}
	
	protected String getResorucePath(String relPath){
		return this.getClass().getResource(relPath).getPath();
	}
	
	protected String getResourceContent(String relPath){
		String pprintSrcPath =  getResorucePath(relPath);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(pprintSrcPath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	    try {
	        try {
				String src = IOUtils.toString(inputStream);
				return src;
			} catch (IOException e) {
				e.printStackTrace();
			}
	    } finally {
	    	if (inputStream != null){
		        try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	}
	    }
	    
		return "";
	}
}
