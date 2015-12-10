package StringProblems;
import java.util.*;

public class scratch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		
		List<Integer> p = a.subList(0, 2);
		
		for(int i: p)
			System.out.println(i);
		
		a.set(0, 5);
		
		//System.out.print("dd");
		
		for(int i: p)
			System.out.println(i);
		
		
		
	}

}
