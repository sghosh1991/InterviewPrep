package RecursionDP;

public class CoinChange_V1 {

	/**
	 * @param args
	 */
	
	/*
	 * Given unlimied supply of coins of each denomination find the minimum number of coins needed to make a change
	 * 
	 */
	
	public static void minCoinChange(int [] denominations, int sum){
		
		int [][] dpTable = new int [denominations.length][sum+1];
		
		//Initialization. Col1 = 0
		//minimum # of coins to get a sum of zero = 0
		
		for(int i=0;i<dpTable.length;i++){
			dpTable[i][0] = 0;
		}
		
		//Initialization top row
		for(int i=1;i<dpTable[0].length;i++){
			
			if( i % denominations[0] ==0){
				dpTable[0][i]=i/denominations[0];
			}
			else{
				dpTable[i][0]=0;
			}
			
		}
		
		//showTable(dpTable);
		
		//Fill up remaining table
		for(int i=1;i<dpTable.length;i++){
			for(int j=1;j<dpTable[0].length;j++){
				
				//System.out.println(denominations[i] + ":" + i);
				if(denominations[i] > j){
					//System.out.println("In if");
					dpTable[i][j] = dpTable[i-1][j];
				}
				else{
					//System.out.println("In else");
					dpTable[i][j] = Math.min(dpTable[i-1][j], dpTable[i][j-denominations[i]]+1);
				}
	
			}

		}
		
		showTable(dpTable);
		getDenominations(dpTable,denominations);
		
	}
	
	public static void getDenominations(int [][]dpTable, int [] denominations){
		
		int i=dpTable.length-1;
		int j = dpTable[0].length-1;
				
		while(dpTable[i][j] !=0){
			
			if(dpTable[i][j] == dpTable[i-1][j]){
				
				i--;
			}
			
			else{
				
				System.out.print(denominations[i]);
				j = j-denominations[i];
			}
			
		}
		
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
		int []arr = {1,5,6,8};
		minCoinChange(arr,11);

	}

}
