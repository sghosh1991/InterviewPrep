
public class minAppendPalindrome {

	/**
	 * @param args
	 */
	
	
	
	public static void minPalindrome(String str){
		
		StringBuffer s = new StringBuffer(str);
		
		int len = s.length();
		
		//check if palindrome first
		
		while(true){
			
			
			s.insert(0, "1");
			System.out.println("Current s = " + s);
			len = s.length();
			
			int rh = 0;
			int lh = 0;
			
			if(len%2 == 0){
				
				rh = len/2;
				lh = rh-1;
			}
			else{
				
				rh = len/2 + 1;
				lh = len/2 -1;
			}
			
			
			if(s.charAt(lh)=='1'){
				System.out.println(len);
				return;
			}
			else{
				
				while(s.charAt(rh++)==s.charAt(lh--));
				if(s.charAt(lh) == '1'){
					System.out.println(len);
					return;
				}
				
			}
				
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
