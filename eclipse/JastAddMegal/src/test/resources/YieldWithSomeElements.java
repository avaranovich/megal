import java.util.HashSet;
import java.util.Arrays;

public class YieldWithSomeElements {
	public static HashSet<Integer> even(int to){
		for(int i=0;i<to;i+=2){
			yield return i;
		}
	}
}