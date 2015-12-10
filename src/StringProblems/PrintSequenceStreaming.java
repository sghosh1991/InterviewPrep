package StringProblems;

public class PrintSequenceStreaming {
	
	
	
	public static void printSequence(String str){
		
		
		char[] arr = str.toCharArray();
		StringBuffer seq = new StringBuffer();
		int i =1;
		seq.append(arr[0]);
		int prev = Integer.parseInt(new Character(seq.charAt(seq.length()-1)).toString());
		
		while(i<arr.length){
			
			int curr = Integer.parseInt(new Character(arr[i]).toString());
			
			
			if( curr == 1+prev){
				seq.append(arr[i]);
			}
			else{
				
				if(seq.length()>1){
					System.out.println(new String(seq) + ";");
					
				}
				
				seq.delete(0, seq.length());
				seq.append(arr[i]);
				
			}
			
			i++;
			prev = curr;
				
		}
		
		if(seq.length()>1){
			System.out.println(new String(seq) + ";");
			
		}
		
	}
	
	public static void main(String args[]){
		
		printSequence("4846678912356012356");
	}

}
