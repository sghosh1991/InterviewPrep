package RecursionDP;
import java.util.*;


/*
 * 
 * Enumerate all possible anagrams of a random string
 *  where capital letters, numbers, and symbols are not 
 *  allowed to move within the string.
 * 
 */

public class AllAnagramsExceptCapitals {

	/**
	 * @param args
	 */
	
	
	public static ArrayList<String> insertCharacter(String str,char ch){
		
		/*
		 * returns the string by inserting ch at all avalibale locations
		 * str = abc ch =d
		 * __a__b__c ----> __ = available locations for d
		 * dabc, adbc, abdc, abcd are the result
		 * 
		 */
		//System.out.println("In insert");
		StringBuffer s;
		ArrayList<String> anagrams = new ArrayList<String>();
		for(int i = 0;i<= str.length();i++){
			s = new StringBuffer(str);
			s.insert(i, ch);
			anagrams.add(new String(s));
			
		}	
		return anagrams;
	}
	
	
		
	public static ArrayList<String> generateAnagrams(String str){
		
		char anagramsBeginingWith;
		String permuteString;
		ArrayList<String> partialResult=null;
		
		//System.out.println("Called with : " + str);
		
		if(str.length() == 2){
			
			anagramsBeginingWith = str.charAt(0);
			permuteString = str.substring(1);
			partialResult = new ArrayList<String>();
			StringBuffer s = new StringBuffer(permuteString);
			s.insert(0, anagramsBeginingWith);
			partialResult.add(new String(s));
			s = new StringBuffer(permuteString);
			s.append(anagramsBeginingWith);
			partialResult.add(new String(s));
			return partialResult;
			
			
		}
		
		else{
			
			//System.out.println("In else. Permuting " + str);
			//for(int i=0;i<str.length();i++){
				int i = 0;
				anagramsBeginingWith = str.charAt(i);
				permuteString = str.substring(0,i) + str.substring(i+1);
				//System.out.println("i =" + i + "anagrambegin :" + anagramsBeginingWith + " permutestr: " + permuteString);
				partialResult = generateAnagrams(permuteString);
				
				
				
				
				ArrayList<String> list = new ArrayList<String>();
				for(String s:partialResult){
					list.addAll(insertCharacter(s, anagramsBeginingWith));
					
				}
				
				return list;
			//}
			
			
		}
		
		//return null;
	}
	
	
	public static void specialAnagrams(String str){
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		//to keep the parts of the string except the specia chacaters
		//The list will have the substrings that will
		//be combined together the string that needs to be permutated
		//abcDfgHi ==> abc,fg,i ==>generatePermutations(abcfgi)
		
		List<String> substrings = new ArrayList<String>(); 
		int startIdx = 0;
		
		for(int i=0;i<str.length();i++){
			
			
			int endIdx=1;
			char ch = str.charAt(i);
			if((int)ch <=57 && (int)ch >=48){
				endIdx = i;
				
				//System.out.println("end: " + endIdx + " start: " + startIdx);
				map.put(ch, i);
				substrings.add(str.substring(startIdx,endIdx));
				startIdx=endIdx+1;
			}
		}
		
		substrings.add(str.substring(startIdx));
		
		String toPermute="";
		for(String s:substrings)
			toPermute += s;
		 
		ArrayList<String> anagrams = generateAnagrams(toPermute);
		
		for(String s:anagrams)
			System.out.println(s);
		
		ArrayList<String> finalAnagramList = new ArrayList<String>();
		
		//for each string insert the special characers in appropiate positions
		int originalIdx;
		for(String s:anagrams){
			
			StringBuffer sb = new StringBuffer(s);
			for(char c:map.keySet()){
				
				originalIdx = map.get(c);
				sb.insert(originalIdx, c);
							
			}
			finalAnagramList.add(new String(sb));
			
		}
		
		for(String s: finalAnagramList)
			System.out.println(s);
		System.out.print(finalAnagramList.size());
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		specialAnagrams("abcdef");
		
//		System.out.println(l.size());
//		
//		for(String s:l)
//			System.out.println(s);
		
		
	}

}
