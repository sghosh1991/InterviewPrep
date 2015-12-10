package MatrixProblems;

import java.util.Arrays;

public class SnakeSequence {

	/**
	 * @param args
	 */
	
	/*
	 * 
	 * 
	 * 
	 */
	
public static void findSnakeSequence(int [][] arr){
		
		/*
		 * T[i][j] contains the length of the longest increasing sequence BEGINING at arr[i][j]
		 * 
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
		showTable(arr);
		System.out.println("========");
		showTable(T);
		System.out.println("========");
		printSnakeSequence(arr,T);
		
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
		
		int down=0,right=0; 

		
		//Down
		if(validIndex(arr.length, arr[0].length, i+1, j) && (Math.abs(arr[i+1][j] - arr[i][j])==1)){
			down = fillDPTable(arr, T, i+1, j);
		}
	
		//Right
		if(validIndex(arr.length, arr[0].length, i, j+1) && (Math.abs(arr[i][j+1] - arr[i][j])==1)){
			right = fillDPTable(arr, T, i, j+1);
		}
		
		T[i][j] = Math.max(down,right)+1;
		System.out.println("T[" + i + "][" + j + "]: " + T[i][j] +  " DOWN: " +down + " RIGHT" + right);
		
		return T[i][j];
	}
	
	public static boolean validIndex(int row,int col,int i,int j){
		
		//returns true if the index to be examined is valid
		if(i<0 || j<0 || i>=row || j >= col){
			return false;
		}
		return true;
		
	}
	
	
	public static void printSnakeSequence(int [][]arr, int[][] T){
		
		int snakeSequence = Integer.MIN_VALUE;
		int snakeSeq_x=0;
		int snakeSeq_y=0;
		
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[0].length;j++){
				if(T[i][j]>snakeSequence){
					snakeSequence = T[i][j];
					snakeSeq_x = i;
					snakeSeq_y = j;
				}
			}
		}
		
		System.out.println("MAX: " + T[snakeSeq_x][snakeSeq_y]);
		
		int x=snakeSequence;
		
		while(x!=1){
			
			
			//System.out.println("LIS_x: " + LIS_x + "LIS_y: " + LIS_y + " x: " +x);
			
			
			//Down
			if(validIndex(arr.length, arr[0].length, snakeSeq_x+1, snakeSeq_y) && (T[snakeSeq_x+1][snakeSeq_y] - T[snakeSeq_x][snakeSeq_y] == -1)){
				System.out.print(arr[snakeSeq_x][snakeSeq_y] + "-->");
				snakeSeq_x++;
				x--;
				//continue;
			}
			
			
			
			//Right
			else if(validIndex(arr.length, arr[0].length, snakeSeq_x, snakeSeq_y+1) && (T[snakeSeq_x][snakeSeq_y+1] - T[snakeSeq_x][snakeSeq_y] == -1)){
				System.out.print(arr[snakeSeq_x][snakeSeq_y] + "-->");
				snakeSeq_y++;
				x--;
				//continue;
			}
			
			//
		}
	
		System.out.println(arr[snakeSeq_x][snakeSeq_y]);
		
		
	}
	
	
		
	public static void showTable(int [][]arr){
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] arr = {{1,3,2,6,8},{-9,7,1,-1,2},{1,5,0,1,9}};
		
		findSnakeSequence(arr);

	}

}
