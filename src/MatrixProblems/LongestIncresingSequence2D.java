package MatrixProblems;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

/*
 * Find the longest increasing sequence in a 2D array while moving top,left,down,right but not diagonal
 * 
 */


public class LongestIncresingSequence2D {

	/**
	 * @param args
	 */
	
	public static void findLongestSequence(int [][] arr){
		
		/*
		 * T[i][j] contains the length of the longest increasing sequence BEGINING at arr[i][j]
		 * This is VERY DIFFERENT from the LIS in 1D where the DP solution has an auxilliary array
		 * aux[] where aux[i] represents the LIS ENDING at arr[i]
		 */
		
		int [][] T = new  int [arr.length][arr[0].length];
		
		//Initially fill every element in T with 0
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				T[i][j]=0;
			}
		}
		
		//Fill temp 
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				if(T[i][j]==0){
					fillDPTable(arr, T, i, j);
				}
			}
		}
		
		showTable(T);
		printLIS(arr,T);
		
	}
	
	public static int fillDPTable(int [][]arr,int [][] T, int i,int j){
	
		System.out.println("calling with i:" + i + " j:" + j + " T[i][j]: " + T[i][j]); 
		
		/*
		 *Caching in action 
		 */
		if(T[i][j]!=0)
			return T[i][j];
		
		
		//up,down,left,right represent the max LIS starting at the up,dow,right,left element of
		//the current element i.e arr[i][j]
		
		int up=0,down=0,left=0,right=0; 
		
		//Up
		if(validIndex(arr.length, arr[0].length, i-1, j) && (arr[i-1][j] > arr[i][j])){
			up = fillDPTable(arr, T, i-1, j);
		}
		
		//Down
		if(validIndex(arr.length, arr[0].length, i+1, j) && (arr[i+1][j] > arr[i][j])){
			down = fillDPTable(arr, T, i+1, j);
		}
		
		//Left
		if(validIndex(arr.length, arr[0].length, i, j-1) && (arr[i][j-1] > arr[i][j])){
			left = fillDPTable(arr, T, i, j-1);
		}
		
		//Right
		if(validIndex(arr.length, arr[0].length, i, j+1) && (arr[i][j+1] > arr[i][j])){
			right = fillDPTable(arr, T, i, j+1);
		}
		
		T[i][j] = maxLIS(up, down, left, right)+1;
		System.out.println("T[" + i + "][" + j + "]: " + T[i][j] + " UP: " + up + " DOWN: " +down + " LEFT" + left + " RIGHT" + right);
		
		return T[i][j];
	}
	
	public static boolean validIndex(int row,int col,int i,int j){
		
		//returns true if the index to be examined is valid
		if(i<0 || j<0 || i>=row || j >= col){
			return false;
		}
		return true;
		
	}
	
	
	public static int maxLIS(int up,int down, int left, int right){
		
		int []arr = {up,down,left,right};
		Arrays.sort(arr);
		return arr[3];
	}
	
	
	public static void showTable(int [][]arr){
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public static void printLIS(int [][]arr,int  [][]T){
		
		
		int LISLength = Integer.MIN_VALUE;
		int LIS_x=0;
		int LIS_y=0;
		
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[0].length;j++){
				if(T[i][j]>LISLength){
					LISLength = T[i][j];
					LIS_x = i;
					LIS_y = j;
				}
			}
		}
		
		System.out.println("MAX: " + T[LIS_x][LIS_y]);
		
		int x=LISLength;
		
		while(x!=1){
			
			
			//System.out.println("LIS_x: " + LIS_x + "LIS_y: " + LIS_y + " x: " +x);
			
			//Up
			if(validIndex(arr.length, arr[0].length, LIS_x-1, LIS_y) && (T[LIS_x-1][LIS_y] - T[LIS_x][LIS_y] == -1)){
				System.out.print(arr[LIS_x][LIS_y] + "-->");
				LIS_x--;
				x--;
				//continue;
			}
			
			//Down
			else if(validIndex(arr.length, arr[0].length, LIS_x+1, LIS_y) && (T[LIS_x+1][LIS_y] - T[LIS_x][LIS_y] == -1)){
				System.out.print(arr[LIS_x][LIS_y] + "-->");
				LIS_x++;
				x--;
				//continue;
			}
			
			//Left
			else if(validIndex(arr.length, arr[0].length, LIS_x, LIS_y-1) && (T[LIS_x][LIS_y-1] - T[LIS_x][LIS_y] == -1)){
				System.out.print(arr[LIS_x][LIS_y] + "-->");
				x--;
				LIS_y--;
				//continue;
			}
			
			//Right
			else if(validIndex(arr.length, arr[0].length, LIS_x, LIS_y+1) && (T[LIS_x][LIS_y+1] - T[LIS_x][LIS_y] == -1)){
				System.out.print(arr[LIS_x][LIS_y] + "-->");
				LIS_y++;
				x--;
				//continue;
			}
			
			//
		}
	
		System.out.println(arr[LIS_x][LIS_y]);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] arr = {{2,1,6},{4,5,8},{0,6,7}};
		
		
		findLongestSequence(arr);
		showTable(arr);
	}

}
