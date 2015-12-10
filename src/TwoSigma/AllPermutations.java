package TwoSigma;

import java.util.ArrayList;

public class AllPermutations {
	
	
	public void permutate(String str){
		
		for(String s: permutate(str,0)){
			System.out.println(s);
		}
		
	}
	
	private ArrayList<String> permutate(String str, int processed){
		
		ArrayList<String> res = new ArrayList<String>();
		
 		if(str.length() == 1){
			
			res.add(str);
			return res;
		}
 		else{
 			
 			for(int i=0;i<str.length();i++){
 				
 				String before = str.substring(0,i);
 				String after = str.substring(i+1,str.length());
 				char firstChar = str.charAt(i);
 				ArrayList<String> temp = null;
 				
 				temp = permutate(before+after, processed+1);
 				
 				for(String s: temp){
 					
 					res.add(firstChar + s);
 				}
	
 			}
 			
 			return res;
 			
 			
 		}
	
	}
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AllPermutations p = new AllPermutations();
		
		String s = "abcd";
		
		p.permutate(s);

	}

}
