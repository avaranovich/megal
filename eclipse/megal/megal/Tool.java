package megal;

import megal.model.*;
import megal.analysis.*;
import megal.parser.MegaLParser;

import java.io.IOException;

/**
 * Parse the megamodel.
 * Analyze it in all kinds of ways.
 * Resolve it, of course.
 * Any sort of issue is to report with a non-zero exit code.
 */
public class Tool {
	public static void main(String[] args) throws IOException {
		try {
			Model m = MegaLParser.parse(args[0]);
			if (! (TypeNames.check(m)))
				throw new MegaLException();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
