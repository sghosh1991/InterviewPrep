package MatrixProblems;
import java.util.*;

public class PeakFinding2d {

	/**
	 * @param args
	 */
	
	//Paradigm: Recursion
	
	public static void peak(int [][] arr, int leftCol, int rightCol){
		
		
		int midCol = (leftCol + rightCol)/2;
		
		
		//find Global maxima of the midCol column
		List<Integer> max = findGlobalMaxima(arr, midCol);
		int maxRow = max.get(1);
		int maxElement = max.get(0);
		
		if(leftCol == rightCol){
			System.out.println("There is no max ");
			return;
		}
		
		ArrayList<Integer> westSideElements = new ArrayList<Integer>();
		westSideElements.add(arr[maxRow-1][midCol-1]);
		westSideElements.add(arr[maxRow][midCol-1]);
		westSideElements.add(arr[maxRow+1][midCol-1]);
		int maxWestSide = Collections.max(westSideElements);
		
		System.out.println("Maxwest: " + maxWestSide);
		
		
		ArrayList<Integer> eastSideElements = new ArrayList<Integer>();
		eastSideElements.add(arr[maxRow-1][midCol+1]);
		eastSideElements.add(arr[maxRow][midCol+1]);
		eastSideElements.add(arr[maxRow+1][midCol+1]);
		int maxEastSide = Collections.max(eastSideElements);
		
		System.out.println("Maxeast: " + maxEastSide);
		
		
		
		
		if(maxWestSide > maxElement){
			
			System.out.println("Going west");
			peak(arr, leftCol, midCol-1);
		}
		
		else if(maxEastSide > maxElement){
			System.out.println("Going east");
			peak(arr,midCol+1,rightCol);
			
		}
			
		
		else{
			System.out.println("the max element is :" + maxElement);
			System.out.println("Position: Row:" + maxRow + " Column:" + midCol);
			return;
		}
	}
			
	
	
	
	public static ArrayList<Integer> findGlobalMaxima(int [][] arr, int midCol){
		
		//had to use arraylist as pair is not supported on my machine
		//max[1] has the max value
		//max[2] has the row number of the max value
		ArrayList<Integer> max = new ArrayList<Integer>(2);
		
		int globalMax = arr[0][midCol];
		int maxIdx = 0;
		for(int i=1;i<arr.length;i++){
			
			if(arr[i][midCol] > globalMax){
				globalMax = arr[i][midCol];
				maxIdx = i;
			}
		}
		
		
		
		max.add(globalMax);
		max.add(maxIdx);
		
		
		return max;
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][]arr = {{9,3,5,2,4,9,8},{7,2,5,1,4,0,3},{9,8,9,3,2,4,8},{7,6,3,1,3,2,3},{9,0,6,0,4,6,4},{8,19,8,0,5,3,0},{2,1,2,1,1,1,1}};
		
		peak(arr,0,arr[0].length);
		
		
		

	}

}
