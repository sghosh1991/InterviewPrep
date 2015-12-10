package TwoSigma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * Ip = [cat, dog, bananna, walk, walker, dogwalker]
 * Op = dogwalker
 * as dogwalker is the longest word which can be made from other words in the array
 * 
 * @author santosh
 *
 */


public class LongestWordMadeOfOtherWords {
	
	public class LengthComparator implements Comparator<String>{
		
		public int compare(String s1, String s2){
			
			return s1.length() - s2.length();
		}
	
	}
	
	
	
	public void get(ArrayList<String> arr){
				
		Collections.sort(arr, new LengthComparator());
		
		for(String s: arr){
			System.out.println(s);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] arr = {"cat", "dog","walk","bananna","walker","dogwalker"};
		
		ArrayList<String> sArr = new ArrayList<String>();
		for(String s: arr){
			sArr.add(s);
		}
		
		
		LongestWordMadeOfOtherWords s = new LongestWordMadeOfOtherWords();
		
		s.get(sArr);
		
		//Collections.sort(arr, new LengthComparator());

	}

}
