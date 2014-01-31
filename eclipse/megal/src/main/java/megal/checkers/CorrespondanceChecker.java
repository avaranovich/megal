package megal.checkers;

import java.util.List;

public interface CorrespondanceChecker<X, Y> {
	megal.trivia.Pair<Boolean, List<megal.trivia.Pair<Fragment, Fragment>>> check(X source, Y target);
}