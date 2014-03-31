package megal.checkers.languages;

import com.google.common.io.Resources;

import java.io.*;
import java.net.URI;
import java.util.List;
import megal.checkers.Checker;
import megal.providers.IVCSProvider;
import megal.providers.ProviderFactory;
import org.jruby.parser.Parser;

/**
 *
 * @author Erwin Schens (erwinschens@uni-koblenz.de)
 */
public class Ruby implements Checker<URI> {

    public boolean check(URI target) {
        try {
            String content = ProviderFactory.getForUrl(target).getContent();
            // in = Resources.newInputStreamSupplier(uri.toURL()).getInput();

            // convert String into InputStream
            InputStream in = new ByteArrayInputStream(content.getBytes());

            org.jruby.Ruby ruby = org.jruby.Ruby.newInstance();
            ruby.loadFile("rubyChecker", in, true);
            new Parser(ruby);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean check(List<URI> targets) {
        boolean check = true;
        for(URI t : targets){
            check = check && check(t); 
        }
        return check;
    }
}
