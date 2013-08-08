package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class Net {

	public static boolean safeFileFromURI(File output, URI input){
		BufferedInputStream in = null;
    	FileOutputStream fout = null;
    	try
    	{
    		in = new BufferedInputStream(new URL(input.toString()).openStream());
    		fout = new FileOutputStream(output);
    		byte data[] = new byte[1024];
    		int count;
    		while ((count = in.read(data, 0, 1024)) != -1)
    		{
    			fout.write(data, 0, count);
    		}
    		
    	} catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	finally{
    		if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
    		if (fout != null)
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
    	}
    	return true;
	}
	
}
