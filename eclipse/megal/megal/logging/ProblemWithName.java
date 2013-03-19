package megal.logging;

/**
 * A problem tracking class for the log.
 * Problems consist of problem code and related name of a model element.
 */
public class ProblemWithName extends Problem {
	public String name;
	public ProblemWithName(ProblemCode code, String name) {
		this.code = code;
		this.name = name;
	}
}
