package megal.checkers;

import java.util.List;

public interface Checker<T> {
	boolean check(T target);
        
        boolean check(List<T> targets);
}
