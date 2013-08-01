/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megal.checkers.languages;

import com.google.common.io.Resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import megal.checkers.Checker;
import org.jruby.Ruby;
import org.jruby.parser.Parser;
import org.jruby.*;

/**
 *
 * @author Erwin Schens (erwinschens@uni-koblenz.de)
 */
public class RubyChecker implements Checker<URI> {

    public boolean check(URI target) {
        try {
            InputStream in = null;
            in = Resources.newInputStreamSupplier(target.toURL()).getInput();
            
            
            Ruby ruby = Ruby.newInstance();
            ruby.loadFile("rubyChecker",in,true);
            Parser parser = new Parser(ruby);
            
        } catch (FileNotFoundException fnfex) {
            return false;
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
