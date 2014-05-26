package org.softlang.rails.helpers;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ResourceHelper {

    public String getResourceContent(String relPath) {
        try {
            BufferedInputStream fis = (BufferedInputStream)this.getClass().getResource(relPath).getContent();
            StringBuilder builder = new StringBuilder();
            int ch;
            while((ch = fis.read()) != -1){
                builder.append((char)ch);
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return "";
    }

}
