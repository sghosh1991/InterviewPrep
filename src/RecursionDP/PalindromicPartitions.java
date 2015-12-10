package RecursionDP;
import java.util.*;
import RecursionDP.*;

public class PalindromicPartitions {

	/**
	 * @param args
	 */
	
	
	public static void partition(String str){
		
		int strLength = str.length();
		int [][]T = new int[strLength][strLength];
		ArrayList<Integer> splits = new ArrayList<Integer>();
		SplitPoints min = new SplitPoints(-1,Integer.MAX_VALUE);
		SplitPoints temp;
		int splitPositions[][] = new int[strLength][strLength];
		
		
		//Initialization. initialize palindromes of length 1 and length 2
		
		//Length = 1 -> diagonal elements 
		for(int i=0;i<strLength;i++){
			T[i][i]=0;
			splitPositions[i][i]=-1;
		}
		
		//Length = 2
		for(int i=0;i<strLength-1;i++){
			
			if(str.charAt(i)==str.charAt(i+1)){
				T[i][i+1]=0;
				splitPositions[i][i+1]=-1;
			}
			else{
				T[i][i+1]=1;
				splitPositions[i][i+1]=i;
			}
		}
		
		
		//Compute the number of partitions for the remaining lengths
		for(int len=3;len<=strLength;len++){
			
			for(int i=0;i<=strLength-len;i++){
				
				if(isPalindrome(str.substring(i,i+len))){
					T[i][i+len-1]=0;
					splitPositions[i][i+len-1]=-1; //-1 denotes we have hit a palindrme
				}
				else{
					//splits.clear();
					min.numOfPartitions=Integer.MAX_VALUE;
					//iterate over all possible splits and take the minimum one
					for(int j = i;j<i+len-1;j++){
						//splits.add(T[i][j]+T[j+1][i+len-1]+1);
						temp = new SplitPoints(j, T[i][j]+T[j+1][i+len-1]+1);
						
						//System.out.println("New split: point -->" + temp.splitPoint + " splits: "+temp.numOfPartitions);
						
						if(temp.compareTo(min) < 0)
							min=temp;
						
						//System.out.println("min: " + min.splitPoint + "-> partition: "+ min.numOfPartitions);
						
					}
					//Collections.sort(splits);
					//T[i][i+len-1]=splits.get(0);
					T[i][i+len-1]=min.numOfPartitions;
					splitPositions[i][i+len-1]=min.splitPoint;
							
				}
				
			} //end of substrings of length len
		}//end of looping over each length
		
		
//		showMatrix(T);
//		System.out.println("=================");
//		showMatrix(splitPositions);
//		System.out.println("=================");
		showPalindromes(splitPositions,str,0,strLength-1);
		
		
	}
	
	
	private static void showPalindromes(int [][]arr,String str,int left,int right){
		
		try{
			
		
		int split;
		
		//System.out.println("Called with : left=" +left + " right=" + right);
		
		if(arr[left][right] == -1){
			System.out.println(str.substring(left,right+1));
			return;
			
		}
		
		
					
		split = arr[left][right];
		showPalindromes(arr,str,left,split);
		showPalindromes(arr,str,split+1,right);
		
		return;
		}
		catch(Exception e){
			//return;
			
		}
		
	}
	
	
	private static boolean isPalindrome(String str){
		
		//Returns if the string istr is a palindrome or not
		char[] strArr = str.toCharArray();
		int start = 0;
		int end = strArr.length-1;
		char temp;
		
		while(start<end){
			
			if(strArr[start]!=strArr[end])
				return false;
			start++;
			end--;
		}
		
		return true;
	}
	
	
	private static void showMatrix(int[][] arr){
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				System.out.print(arr[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcbmstoprpotqq";
		//System.out.println(isPalindrome(s));
		partition(s);
		

	}

}
