package MatrixProblems;
import MyUtils.*;
import java.util.*;

public class SaddlePoint {

	/**
	 * @param args
	 */
	
	public static void findSaddlePoint(int [][]arr){
		
		ArrayList<Pair<Integer,Integer>> colMinPoint = new ArrayList<Pair<Integer,Integer>>();
		ArrayList<Pair<Integer,Integer>> rowMaxPoint = new ArrayList<Pair<Integer,Integer>>();
		
		colMinPoint.add(null);
		colMinPoint.add(null);
		colMinPoint.add(null);
		
		int [] colMin = new int[arr[0].length];
			
		
		for(int i=0;i<colMin.length;i++)
			colMin[i] = Integer.MAX_VALUE;
		
		
		for(int i=0;i<arr.length;i++){
			
			int rowMaxGlobal = Integer.MIN_VALUE;
			int rowMax_x=0;
			int rowMax_y=0;
			for(int j=0;j<arr[0].length;j++){
				
				if(arr[i][j] > rowMaxGlobal){
					rowMaxGlobal = arr[i][j];
					rowMax_x = i;
					rowMax_y = j;
					
				}
				
				if(colMin[j] > arr[i][j]){
					colMin[j] = arr[i][j];
					colMinPoint.set(j, new Pair(i,j));
				}
				
				
			}
			
			rowMaxPoint.add(new Pair(rowMax_x,rowMax_y)); 
			
		}
		
		showArr(colMinPoint);
		showArr(rowMaxPoint);
		
		//find max of column mins
		Pair<Integer,Integer> maxOfColMin_Point = new Pair<Integer,Integer>(0,0);
		int max = colMin[0];
		for(int i=0;i<colMin.length;i++){
			if(max < colMin[i]){
				max = i;
				maxOfColMin_Point = colMinPoint.get(i);
						
			}
		}
		
		Pair<Integer,Integer> minOfRowMax_Point = new Pair<Integer,Integer>(0,0);
		int min = Integer.MAX_VALUE;
		for(Pair<Integer,Integer> p:rowMaxPoint){
			if(arr[p.getX()][p.getY()] < min){
				min = arr[p.getX()][p.getY()];
				minOfRowMax_Point = p;
			}
			
		}
		
		
		System.out.println(" Max of min cols at :" + maxOfColMin_Point);
		System.out.println(" Min of max rows :" + minOfRowMax_Point);
		
		
	}
	
	public static void showArr(ArrayList<Pair<Integer,Integer>> arr){
			
			for(int i=0;i<arr.size();i++){
				
				System.out.println(arr.get(i));
			}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] arr = {{2,-2,-3},{1,0,2},{-1,-1,3}};
		
		findSaddlePoint(arr);

	}

}
