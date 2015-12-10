package RecursionDP;
import java.util.*;

public class PhoneNumberWithRestriction {

	/**
	 * @param args
	 */
	
	public static void generatePhoneNumbers(int n){
		
		HashSet<Integer> allowedList = new HashSet<Integer>();
		
		allowedList.add(1);
		allowedList.add(2);
		allowedList.add(3);
		allowedList.add(5);
		allowedList.add(6);
		allowedList.add(7);
		allowedList.add(8);
		allowedList.add(9);
		allowedList.add(0);
		
		int [] partialResult = new int[n];
		int previousDisallowed = -1;
		
		//printNumbers(allowedList, partialResult, previousDisallowed, 0, n);
		
		
		/*//Start with 4 end with 4
		int [] partial = new int[n-2];
		//allowedList.add(4);
		previousDisallowed = 4;
		printNumbers(allowedList, partial, 4, 0, n-2);*/
		
		
		//if contains 4, 4 should be at first
		int [] partial = new int[n];
		//partial[0]=4;
		printNumbers(allowedList, partial, -1, 0, n);
			
		
	}
	
	public static void printNumbers(HashSet<Integer> allowedList, int [] partialResult,int prevDisallowed, int nextIdx, int phoneNumberLength){
		
		
		HashSet<Integer> newAllowedSet ;
		
		//Base Condition
		if(nextIdx == phoneNumberLength){
			
			//System.out.print("4");
			for(int i=0;i<nextIdx;i++){
				System.out.print(partialResult[i]);
			}
			//System.out.print("4");
			System.out.println();
		}
		
		
		//Recurse
		else{
			
			for(int i : allowedList){
				
				newAllowedSet = new HashSet<Integer>(allowedList); //new set neede
				//otherwise the set is modified in one recursion step
				//when the call returns the iterator of the set will see that while it was iterating
				//in the parent the set was modified.
				//so it will throw up a concurrent modification exception
				
				partialResult[nextIdx] = i;
				newAllowedSet.remove(i);
				
				if(prevDisallowed >= 0){
					newAllowedSet.add(prevDisallowed);
				}
				
//				if(nextIdx == phoneNumberLength-2){
//					newAllowedSet.remove(4);
//				}
				
			
				printNumbers(newAllowedSet,partialResult,i,nextIdx+1,phoneNumberLength);
				
			}
			
			
		}

	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		generatePhoneNumbers(4);

	}

}
