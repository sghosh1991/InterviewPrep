package MyUtils;
import java.util.*;

public class IntervalComparator implements Comparator<Pair<Integer,Integer>>{
	
	public int compare(Pair<Integer,Integer> o1,Pair<Integer,Integer> o2){
		return o1.getX() - o2.getX();
	}
	
}
