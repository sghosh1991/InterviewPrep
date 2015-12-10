package TwoSigma;

public class AddToMakePalindrome {
	
	
	
	 static void longestCommonSubsequence(String str1, String str2){
		 
		 int [][] T = new int[str2.length()][str1.length()];
		 
		 char [] str1Arr = str1.toCharArray();
		 char [] str2Arr = str2.toCharArray();
		 
		 
		 boolean matchFound = false; 
		 //Initialize the first row
		 
		 for(int i=0;i<T[0].length;i++){
			 
			 if(matchFound){
				 T[0][i] = 1;
				 continue;
			 }
			 
			 if(str2Arr[0] == str1Arr[i]) {				 
				 T[0][i] = 1;
				 matchFound = true;
			 }
 
		 }
		 
		 matchFound = false;
		 //Initialize the first col
		 
		 for(int i=0;i<T.length;i++){
			 
			 if(matchFound){
				 T[i][0] = 1;
				 continue;
			 }
			 
			 if(str1Arr[0] == str2Arr[i]) {				 
				 T[1][0] = 1;
				 matchFound = true;
			 }
 
		 }
		 
		 //Initialize remaining cells rowwise
		 
		 for(int i=1;i<T.length;i++){
			 
			 for(int j=1;j<T[0].length;j++){
				 
				 if(str1Arr[j] == str2Arr[i]){
					 T[i][j] = 1 + T[i-1][j-1];
				 }
				 else{
					
					 T[i][j] = Math.max(T[i][j-1], T[i-1][j]);
				 }
	 
			 } //end of innr for loop
 
		 } //end of outer for loop
		 
		 
		 printMatrix(T);
		 
	 }
	
	 
	 static void printMatrix(int [][] T){
		 
		 for(int i=0;i<T.length;i++){
			 
			 for(int j=0;j<T[0].length;j++){
				 System.out.print(T[i][j] + " ");
			 }
			 
			 System.out.println();
		 }
	 }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddToMakePalindrome.longestCommonSubsequence("abcde", "qxdbce");

	}

}
