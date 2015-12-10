package TwoSigma;

import MyUtils.Pair;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value. 
 * Your algorithm's runtime complexity must be in the order of O(log n). If the target is not found 
 * in the array, return [-1, -1]. 
 * For example, given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author santosh
 *
 */

public class FindRangeOfInteger {
	
	
	
	private int getLeftIndex(int [] arr, int target){
		
		int leftIndex = -1;
		int lo = 0;
		int hi = arr.length-1;
		
		while(lo<=hi){
			
			int mid = (lo+hi)/2;
			
			if(arr[mid] == target){
				
				leftIndex = mid;
				hi = mid-1;
			}
			else if(arr[mid] > target){
				hi = mid-1;
			}
			else{
				
				lo = mid+1;
			}
			
		}
		
		
		if(arr[lo]!=target){
			
			leftIndex = -1;
		}
				
		return leftIndex;
	
	}
	
	
private int getRightIndex(int [] arr, int target){
		
		int rightIndex = -1;
		int lo = 0;
		int hi = arr.length-1;
		
		while(lo<=hi){
			
			int mid = (lo+hi)/2;
			
			if(arr[mid] == target){
				
				rightIndex = mid;
				lo = mid+1;
			}
			else if(arr[mid] > target){
				hi = mid-1;
			}
			else{
				
				lo = mid+1;
			}
			
		}
		
		
		if(arr[hi]!=target){
			
			rightIndex = -1;
		}
				
		return rightIndex;
	
	}
	
	
	

	public Pair<Integer,Integer> getRange(int [] arr, int target){
		
		Pair<Integer,Integer> range = new Pair<Integer,Integer>(-1,-1);
		
		range.setX(getLeftIndex(arr, target));
		range.setY(getRightIndex(arr, target));
				
		return range;
	}
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		FindRangeOfInteger f = new FindRangeOfInteger();
		
		int [] arr = {5,7,7,8,8,10};
		
		int target = 8;
		
		System.out.println(f.getRange(arr, target));

	}

}
