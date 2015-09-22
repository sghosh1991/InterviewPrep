package StringProblems;

public class LookAndSay {

	/**
	 * @param args
	 */
	
	
	private static String nextNumber(String s){
		
		//StringBuffer ret = new StringBuffer("");
		String ret="";
		int count;
		char [] strArr = s.toCharArray();
		
		
		for(int i =0 ; i<strArr.length;i++){
			
			count = 1;
			
			while(i<strArr.length-1 && strArr[i] == strArr[i+1]){
				i++;
				count++;
			}
			//System.out.println("DEBUG: " + count + " strArr[" + i + " ] : " +strArr[i]);
//			ret.append(count);
//			ret.append(strArr[i]);
			
			ret += count;
			ret += new Character(strArr[i]).toString();
			
			
		}
		
		return ret.toString();		
		
	}
	
	public static void generateSquence(int n){
		
		String s = "1";
		
		System.out.println(s);
		
		for(int i=0;i<n;i++){
			
			s = nextNumber(s);
			
			System.out.println(s);
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateSquence(4);

	}

}
