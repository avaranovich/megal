package megal.checkers.languages;

import java.net.URI;


import megal.checkers.Checker;

public class True implements Checker<URI>{

	@SuppressWarnings("deprecation")
	public boolean check(URI file) {
		return true;
	}

}
