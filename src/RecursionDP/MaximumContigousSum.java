package RecursionDP;

import java.io.ObjectInputStream.GetField;

public class MaximumContigousSum {

	/**
	 * @param args
	 */
	
	/*
	 * KADANE'S ALGORITHM
	 */
	
	public static void findMaxContigousSum(int []arr){
		
		
		int globalMax = Integer.MIN_VALUE;
		int start=0,end=0;
		
		int s=arr[0];
		
		for(int i=1;i<arr.length;i++){
			
			
			if(Math.max(s, s+arr[i]) > globalMax){
				
				globalMax = Math.max(s, s+arr[i]);
				
				if(s>=0 && arr[i]>=0){
					end = i;
				}
				else if(s<0 && arr[i]>=0){
					start=i;
					end=i;
				}
				else if(s<0 && arr[i]<0){
					start=i;
					end=i;
				}
				
				
			}
			
			s = Math.max(s+arr[i],arr[i]);
			

		}
		
		System.out.println("The max sum is: " + globalMax);
		System.out.println("Window is from: start=" +  start + " --> end="+ end);
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {-2,-3,4,-1,-2,1,5,-3};
		findMaxContigousSum(arr);

	}

}
