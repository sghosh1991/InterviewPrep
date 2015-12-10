package RecursionDP;
import java.util.*;

public class EditDistance {
	
	
	public static void constructEditTable(String str1,String str2){
		
		/*
		 * We are trying to convert str1 to str2
		 * 
		 */
		
		int rows = str2.length()+1;
		int cols = str1.length()+1;
		int [][] T = new int[rows][cols];
		char [] str1Arr = str1.toCharArray();
		char [] str2Arr = str2.toCharArray();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		
		//Initialize the 1st row and 1st column
		for(int i=0;i<rows;i++)
			T[i][0]=i;
		for(int i=0;i<cols;i++)
			T[0][i]=i;
		
		//showTable(T);
		
		//Fill up the remaining table
		for(int i=1;i<rows;i++){
			for(int j=1;j<cols;j++){
				
				if(str1Arr[j-1] == str2Arr[i-1]){
					T[i][j]=T[i-1][j-1];
				}
				else{
					temp.clear();
					temp.add(T[i-1][j]); //top element
					temp.add(T[i][j-1]); //left element
					temp.add(T[i-1][j-1]); //diagonal element
					T[i][j] = (Integer)(Collections.min(temp)) + 1;
				}
				
				
			}
		}
		
		showTable(T);
		traceback(T,str1Arr,str2Arr);
		
	}
	
	
	
	public static void traceback(int [][]arr,char [] str1Arr,char []str2Arr){
		
		/*
		 * Reconstructs the edit sequence as per rules:
		 * 	1. Move diagonal with same row/col elements -> no edir
		 * 	2. Move diagonal with different row/col elements -> replace
		 * 	3.	Move left -> delete
		 * 	4. Move Top -> insert
		 */
		
		
		int row = arr.length-1;
		int col = arr[0].length-1;
		
		while(row>0 && col>0){
			
			//System.out.println("str1[" + col + "]: " + str1Arr[col-1] + "----- str2Arr[" + row + "]: " +str2Arr[row-1] );
			
			if(str1Arr[col-1] == str2Arr[row-1]){
				row--;
				col--;
			}
			else{
				
				//Check from which part did arr[row][col] come
				
				//System.out.println(arr[row-1][col] + ":" + arr[row][col-1]+ ":"+arr[row-1][col-1]);
				
				
				//Top check
				if(arr[row-1][col]+1 == arr[row][col]){
					System.out.println("Add " + str2Arr[row-1]);
					row--;
				}
				
				//Left check
				if(arr[row][col-1]+1 == arr[row][col]){
					System.out.println("Delete " + str1Arr[col-1]);
					col--;
				}
				
				//Diagonal check
				if(arr[row-1][col-1]+1 == arr[row][col]){
					System.out.println("Replace " + str1Arr[col-1]);
					row--;
					col--;
				}
		
			}
						
		}
		
		return;
	}
	
	
	public static void showTable(int [][]arr){
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	
	public static void main(String [] args){
		
		constructEditTable("abcdef", "azced");
		constructEditTable("azced", "abcdef");
	}
	
	
}
