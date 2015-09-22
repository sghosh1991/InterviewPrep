package RecursionDP;
import java.util.*;
import RecursionDP.AllAnagramsExceptCapitals;

public class AllCombinations {

	/**
	 * @param args
	 */
	//Holds all the combination strings.
	static ArrayList<String> combinations = new ArrayList<String>();
	
	public static void combinationGenerator(char [] arr){
		
		/*
		 * TopLevel functions that generates the permutations of length 1...arr.length
		 * 
		 */
		
		char [] partialResult =  new char [arr.length];
		int processedIdx = 0;
		int nextIdx = 0;
		
		for(int i=1;i<=arr.length;i++){	
			generateCombinations(arr,partialResult,processedIdx,nextIdx,i);
		}	
		
//		for(String s:combinations)
//			System.out.println(s);
		
		return;
	}
	
	
	
	private static void generateCombinations(char [] arr, char [] partialResult, int processedIdx, int nextIdx, int combinationLength){
		
		
		/*
		 * Generates all combinations of the characters in array arr.
		 * Output: populates the "combinations" list with the strings
		 * Input: partialResult[] of size equal to arr
		 * 		  processedIdx = 0, nextIdx = 0, combinationLength = k
		 * 		  k => the lenth of each of the combinations
		 * if you need all the combinations like when generating the power set
		 * ue the top level function combinationGenerator
		 */
		
		
		
		/*
		 * processedIdx = keeps track of which number in arr has been processed 
		 * nextIdx = this holds the value of the index where the next number in the partialResult[] should be put
		 * combinationLength = this is decremented at each new call
		 * 
		 */
	
		
		if(combinationLength == 0){
			
			String s="";
			for(int i=0;i<nextIdx;i++){
				//System.out.print(partialResult[i] + ",");
				s += partialResult[i];
			
			}
			combinations.add(s);
			
			//System.out.println();
			return;
		}
		
		
		else{
			
			for(int j=processedIdx ; j<= arr.length - combinationLength;j++){
				
				partialResult[nextIdx] = arr[j];
				
				generateCombinations(arr, partialResult, j+1, nextIdx+1, combinationLength-1);
							
			}
		}
				
	}
	
	
	
	
	public static void generatePermsK(String str,int k){
		
		//Generate Permutations of Size k from the string
		
		/*
		 * generate combinations of size k 
		 * Permute each of those permutations
		 * 
		 */
		char [] partialResult =  new char [str.length()];
		int processedIdx = 0;
		int nextIdx = 0;
		char []arr = str.toCharArray();
		generateCombinations(arr, partialResult, processedIdx, nextIdx, k);
		
		ArrayList<String> permutations = null;
		
		for(String s:combinations){
			
			permutations = AllAnagramsExceptCapitals.generateAnagrams(s);
			showPermutations(permutations);
			
		}
				
	}
	
	
	public static void showPermutations(ArrayList<String> permutations){
		
		System.out.println("=============Printing Permutations============");
		
		for(String s:permutations)
			System.out.println(s);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int [] arr = {1,2,3,4};
		String s = "1234";
		//combinationGenerator(s.toCharArray());
		
		generatePermsK(s,3);
		
	}

}
