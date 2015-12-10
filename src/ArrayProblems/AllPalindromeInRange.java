package ArrayProblems;
import java.util.*;

public class AllPalindromeInRange {

	/**
	 * @param args
	 */
	
	
	public static ArrayList<Integer> digitize(int num){
		
		//breaks the number in digits and puts them in an arraylist
		
		ArrayList<Integer> digitizedNum = new ArrayList<Integer>();

		while(num >0){
			digitizedNum.add(0, num%10);
			num = num/10;
		}
		
//		for(int i: digitizedNum)
//			System.out.println(i);
		
		return digitizedNum;
		
	}
	
	
	public static int convertToNum(ArrayList<Integer> digitizedNum){
		
		int num=0;
		int i = 0;
		while(i<digitizedNum.size()){
			
			num = num*10 + digitizedNum.get(i);
			i++;
		}
		//System.out.println(num);
		return num;
	}
	
	
	public static void nextPalindromeNumber(int num){
		
		ArrayList<Integer> digitizedNum = digitize(num);
		
		int size = digitizedNum.size();
		
		ArrayList<Integer> leftHalf,rightHalf;
		
		leftHalf = null;
		rightHalf = null;
		//mirorredNum = null;
		
		System.out.println(num);
		
		while(true){
			
				size = digitizedNum.size();
				
				if(size % 2 == 0){
					
					//the  number has even number of digits
					
					//1. mirror the left side digits to right
					
					for(int i=0,k=size-1;i<=k;i++,k--){
						
						int temp = digitizedNum.get(i);
						digitizedNum.set(k, digitizedNum.get(i));
						digitizedNum.set(i, temp);
						
						
					}
					
					System.out.println("Mirrored num: " + convertToNum(digitizedNum));
					
					if(convertToNum(digitizedNum)>num){
						
						System.out.println(convertToNum(digitizedNum));
						return;
					}
					else{
						
						//increase the middle two elements 
						if(digitizedNum.get(size/2) == 9 || digitizedNum.get(size/2-1)==9){
							
							digitizedNum = roundUp(digitizedNum);
							
							continue;
							
						}
						
						else{
							
							digitizedNum.set(size/2 -1, digitizedNum.get(size/2 -1)+1);
							digitizedNum.set(size/2, digitizedNum.get(size/2)+1);
											
						}

					} //end of increasing the middle two elements
					
				} //end of even sized number clause
				
				
				else{
					
					//1. mirror the left side digits to right
					
					for(int i=0,k=size-1;i<=k;i++,k--){
						
						int temp = digitizedNum.get(i);
						digitizedNum.set(k, digitizedNum.get(i));
						digitizedNum.set(i, temp);
						
						
					}
					
					System.out.println("Mirrored num: " + convertToNum(digitizedNum));
					
					if(convertToNum(digitizedNum)>num){
						
						System.out.println(convertToNum(digitizedNum));
						return;
					}
					else{
						
						//increase the middle element 
						if(digitizedNum.get(size/2) == 9){
							
							digitizedNum = roundUp(digitizedNum);
							
							continue;
							
						}
						
						else{
							
							digitizedNum.set(size/2, digitizedNum.get(size/2)+1);
																		
						}

					} //end of increasing the middle two elements
					
					
					
					
				}//end of odd sized number
				
				System.out.println("======Next iteration=======");
				for(int i: digitizedNum)
					System.out.print(i);
				
		
		} //end of while
		
		
	}
	
	
	
	public static ArrayList<Integer> roundUp(ArrayList<Integer> num){
		
		//This function rounds up the num to next higher hundered or thousand or 10,000 etc
		// 4892 ==> 5000 , 123==>200
		
		ArrayList<Integer> roundUpNum = new ArrayList<Integer>(Collections.nCopies(num.size(), 0));
		
		if(num.get(0) == 9){
			
			roundUpNum.add(0, 1);
			
		}
		else{
			
			roundUpNum.set(0, num.get(0)+1);
		}
		
		return roundUpNum;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//digitizeToNum(digitize(458));
		
		nextPalindromeNumber(9999);

	}

}
