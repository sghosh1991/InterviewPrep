package MatrixProblems;

public class SpiralOrderPrint {

	/**
	 * @param args
	 */
	
	public static void printSpiralOrder(int [][] arr){
		
		int offset;
		
		for(int i=0;i<arr.length;i++)
			printBoundary(arr,i);
		
		
		
	}
	
	
	private static void printBoundary(int [][] arr, int offset){
		
		
		if(offset == arr.length - offset -1){
			System.out.println(arr[offset][offset]);
			return;
		}
		
		for(int j=offset;j<arr.length-offset-1;j++){
			
			System.out.print(" " + arr[offset][j]);
		}
		
		
		System.out.println();
		
		for(int i=offset;i<arr.length-offset-1;i++){
			
			System.out.print(" " + arr[i][arr.length-offset-1]);
		}
		
		System.out.println();
		
		for(int k=arr.length-offset-1;k>offset;k--){
			
			System.out.print(" " + arr[arr.length-offset-1][k]);
		}
		
		System.out.println();
		
		for(int m=arr.length-offset-1;m>offset;m--){
			
			System.out.print(" " + arr[m][offset]);
		}
		
		
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] arr = { {1,2,3}, {5,6,7} , {9,10,11} };
		
		
		//System.out.println(arr.length);
		
		printSpiralOrder(arr);
		

	}

}
