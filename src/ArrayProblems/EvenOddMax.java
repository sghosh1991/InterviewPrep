package ArrayProblems;
import java.io.*;

public class EvenOddMax {

	/**
	 * @param args
	 */
	
	public static void evenOddMax(){
		
		try{
			
			FileReader file = new FileReader("/home/santosh/Desktop/testData");
			BufferedReader br = new BufferedReader(file);
			String line;
			int evenMin=Integer.MAX_VALUE;
			int oddMax=Integer.MIN_VALUE;
			int currentNum=-1;
			while((line = br.readLine())!=null){
				
				currentNum = Integer.parseInt(line);
				if(currentNum % 2 == 0){
					//even min
					if(currentNum < evenMin){
						evenMin = currentNum;
					}
				}
				else{
					
					//odd max
					//even min
					if(currentNum > oddMax){
						oddMax = currentNum;
					}
					
				}
			}
			System.out.println("Even min: " + evenMin + " Odd Max: " + oddMax);
		}
		catch(Exception e){
			
			System.out.println("ERROR");
		}
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		evenOddMax();

	}

}
