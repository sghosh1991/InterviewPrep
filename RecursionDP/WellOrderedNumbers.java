package RecursionDP;

/*
 * 
 * Given a number n print all possible numbers 
 * of length n such that each digit is smaller than the digit 
 * to its right. n=3 123,124,125....789
 */


public class WellOrderedNumbers {


	public static void printWellOrderedNumbers(int [] arr, int nextIdx, int startWith, int lengthRemaining){
	
			if(lengthRemaining < 0){
				
				for(int i=0;i<nextIdx;i++){
					System.out.print(arr[i]);
				}
				System.out.println();
				return;
			}
		
			else{
				
				/*
				 * For well ordered alphabets just change j's limit to 26-lengthRemianing
				 * arr[nextIdx] = j+64; //ASCII
				 * for printing out on base case cast it back to char
				 */
				
				for(int j=startWith;j<=9-lengthRemaining;j++){
					
					arr[nextIdx] = j;
					printWellOrderedNumbers(arr, nextIdx+1, j+1, lengthRemaining-1);
				}

			}
			
			return;
	}
	
	
	public static void wellOrderedNumbers(int k){
		
		/*
		 * Top level function. Sends proper arguments to
		 * printWellOrderedNumbers
		 */
		
		int []arr = new int[k];
		printWellOrderedNumbers(arr, 0, 1, k-1);
		
	}

	public static void main(String args[]){
		
		//int [] arr=new int[3];
		wellOrderedNumbers(2);
		
	}
}
