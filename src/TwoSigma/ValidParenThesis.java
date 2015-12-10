package TwoSigma;

import java.util.ArrayList;

public class ValidParenThesis {
	
	
	public static void generateParens(StringBuffer partialResult, int leftParen, int rightParen,ArrayList<String> result){
		
		
		//System.out.println("Called with leftparen: " + leftParen + " Right parens: " + rightParen + ":"+ partialResult);
		
		if(leftParen > rightParen) return;
		
		else if(leftParen == 0 && rightParen == 0) {
			
			result.add(partialResult.toString());
			
			return;
		}
		
		else{
			
			
			if(leftParen > 0){
				
				partialResult.append('(');
				//System.out.println("Calling with left paren");
				generateParens(partialResult, leftParen-1, rightParen, result);
				partialResult.deleteCharAt(partialResult.length()-1);
				//leftParen++;
				//System.out.println("Returned from left paren " + partialResult + " : " + "left " + leftParen + " right " + rightParen);
				
				
			}
			
			if(rightParen > 0){
				
				partialResult.append(')');
				//System.out.println("Calling with right paren");
				generateParens(partialResult, leftParen, rightParen-1, result);
				partialResult.deleteCharAt(partialResult.length()-1);
				
				//System.out.println("Returned from right paren " + partialResult + " : " + "left " + leftParen + " right " + rightParen);
				
			}

			
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer s = new StringBuffer();
		ArrayList<String> arr = new ArrayList<String>();
		generateParens(s, 4, 4, arr);
		
		for(String s1: arr){
			System.out.println(s1);
		}

	}

}
