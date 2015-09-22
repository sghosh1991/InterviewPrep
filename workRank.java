import java.util.*;


public class workRank {

	/**
	 * @param args
	 */
	
	public static void rank(String [] words){
		
		
		int [] arr= new int[words.length];
        
        for(int k=0;k<words.length;k++){
			
			
		
		
			char [] strArr = words[k].toCharArray();
			
			char [] original = Arrays.copyOf(strArr, strArr.length);
			
			Arrays.sort(strArr);
			
			HashMap<Character, Integer> map = new HashMap<Character,Integer>();
			
			for(char ch:strArr){
				
				if(map.containsKey(ch)){
					map.put(ch, map.get(ch)+1);
				}
				else{
					map.put(ch, 1);
				}
			}
			
			
			int i = 0;
			int j=0;
			long rank=0;
			
					
			while(i < original.length){
				
				
				if(strArr[j] == 'X'){
					j++;
					continue;
				}
				
				if(strArr[j]!=original[i]){
					
					rank += (factorial((original.length - i -1)))/(getDenominatorFact(map,strArr[j]));
					j++;
					
				}
				
				else{
					
					map.put(strArr[j], map.get(strArr[j])-1);
					strArr[j] = 'X';
					j=0;
					i++;
					//rank += (original.length - i -1)/(getDenominatorFact(map,strArr[j]));
					
					
				}
	
			}
			
			arr[k]= (int)((double)rank % (Math.pow(10,9) + 7));
		}
        
        
        for(int x:arr){
        	System.out.print(x + " ");
        }
		
		
	}
	
	
	public static long getDenominatorFact(HashMap<Character,Integer> map, char ch){
		
		long result = 1;
		
		for(char c: map.keySet()){
			
			if(c == ch){
				//System.out.println("Factorial of " + c + (map.get(c)-1));
				result *= factorial(map.get(c)-1);
			}
			else{
				//System.out.println("Factorial of " + c + (map.get(c)));
				result *= factorial(map.get(c));
			}
			
			//System.out.println("partial result " + result);

		}
		
		//System.out.println("denominatorfact: " + result);
		
		return result;
	}
	
	
	public static long factorial(int n){
		
		long fact = 1;
		
		//System.out.println("Factorial of " + n);
		
		if (n==0){
			return 1;
		}
		
		for(int i=n;i>1;i--){
			
			fact *= i;
		}
		
		//System.out.println("Returning " + fact);
		
		return fact;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String [] arr = {"bac" , "aaa" ,"abba"};
		
		rank(arr);
	}

}
