package Microsoft;
import java.util.*;

public class Anagram {

	/**
	 * @param args
	 */
	
	static int count = 0;
	
	public static HashMap<Character,Integer> buildHash(String str){
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		char[] charArr = str.toCharArray();
		
		for(char c:charArr){
			
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}
			else{
				map.put(c, 1);
			}
		}
		
		return map;
		
	}
	
	
	public static boolean checkPalindromePossible(HashMap<Character,Integer> map,int len){
		
				
		if(len % 2 == 0){
			
			for(char c: map.keySet()){
				
				if(map.get(c)!= len/2){
					System.out.println("Returning false");
					return false;
				}
			}
			System.out.println("Returning true");
			return true;
			
			
		}
		
		else{
			
			int count = 0;
			for(char c: map.keySet()){
			
				if(map.get(c)%2 != 0){
					count++;
					if(count>1){
						System.out.println("Returning false");
						return false;
					}
					
				}
			}
			System.out.println("Returning true");
			return true;
	
		}

		
	}
	
	
	public static int countOdds(HashMap<Character,Integer> map){
		
		int x=0;
		
		for(char c:map.keySet()){
			
			if(map.get(c)%2 != 0){
				
				x++;
				
			}
			
						
		}
		
		if(x!= 0 ){
			
			count *= x;
		}
		
		
		return count;
		
	}
	
	
	public static HashMap<Character,Integer> removeOddOccuringElement(HashMap<Character,Integer> map){
		
		HashMap<Character,Integer> mapCopy = new HashMap<Character,Integer>();
		mapCopy.putAll(map);
		
		for(char c: map.keySet()){
			
			if(map.get(c)%2 != 0){
				
				
				mapCopy.put(c, mapCopy.get(c)-1);
				if(mapCopy.get(c)==0){
					mapCopy.remove(c);
				}
				
				break;
				
				
			}
			
			
		}
		
		return mapCopy;
	}
	
	
	public static void check(String str){
		
		
		HashMap<Character,Integer> map = buildHash(str);
		
		//System.out.println("map initial: " + map);
		
		int len = str.length();
		
		
		while(true){
			
			
			if(len%2 == 0){
				
				if(!checkPalindromePossible(map,len)){
					//if this anagram cannot be a palindrome
					map = removeOddOccuringElement(map);
					len --;
					//System.out.println("Len = " + len + "map now: " + map);
		
					}
			
				else{
					
					//we can make a palindrome
					
					//System.out.println("Answer: " + countPermutations(map));
					
					return;
					
				}

			}
			
			else{
				
				//length is odd
				
				if(!checkPalindromePossible(map,len)){
					//if this anagram cannot be a palindrome
					map = removeOddOccuringElement(map);
					len --;
					//System.out.println("Len = " + len + "map now: " + map);
		
					}
				
				else{
					
					System.out.println(countPermutations(map)) ;
					
					return;
				}
				
				
			}
			
		}
		
	
	
	
	}//function end
	

	
	public static int countPermutations(HashMap<Character,Integer> map){
		
		int numHalfSide = 0;
		int duplicates = 0;
		
		for(char c:  map.keySet()){
			
			
			if(map.get(c)%2 == 0){
				numHalfSide += map.get(c)/2;
				
				if(map.get(c)/2 > 1){
					
					duplicates += 1;
				}
			}
		}
		
		
		System.out.println("num: " + numHalfSide + " dup: " + duplicates);
		
		return (int)(fact(numHalfSide)/fact(duplicates));
		
		
	}
	
	
	
	
	public static long fact(int n){
		
		if(n==0) return 1;
		if(n==1) return 1;
		
		long fact = 1;
		
		for(int i = n;i>=2;i--){
			
			fact *= i;
			
		}
		
		return fact;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		check("agqagdt");
		

	}

}
