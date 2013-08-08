package megal.checkers.languages;

import java.io.FileInputStream;
import java.net.URI;
import org.jastadd.JastAddConfiguration;
import megal.checkers.Checker;

public class JastAddChecker implements Checker<URI> {

	@SuppressWarnings("deprecation")
	public boolean check(URI file) {
		
		if (!file.getPath().endsWith("JstFile")) {
			FileInputStream fis;
			try {
				System.out.println("*********file path: "+file.getPath());
				/*fis = new FileInputStream(file.getPath());
				JragParser jp = new JragParser(fis);
				jp.inputStream = fis;
				jp.setFileName(file.getPath());
				ASTCompilationUnit au = jp.CompilationUnit();
				*/
				String arg0[] = new String[2];
				arg0[1]=file.getPath();
				arg0[0]="--package=ast";
				//JastAdd jastadd = new JastAdd(new JastAddConfiguration(args, System.err));
			    //astadd.compile(out, err);
				//int exitVal = compile(args, System.out, System.err);
			    //if (exitVal != 0) {
			    // System.exit(exitVal);
				//}
				org.jastadd.JastAdd jastadd = new org.jastadd.JastAdd(new JastAddConfiguration(arg0, System.err));
				if(jastadd.compile(System.out, System.err)!=0)
					return false;
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

}