package ArrayProblems;

public class RotateArray{
	  // @include
	  public static void rotateArray(int rotateAmount, int[] A) {
	    rotateAmount %= A.length;
	    int numCycles = 2;
	    int cycleLength = A.length / numCycles;

	    for (int c = 0; c < numCycles; ++c) {
	      applyCyclicPermutation(rotateAmount, c, cycleLength, A);
	    }
	  }

	  private static void applyCyclicPermutation(int rotateAmount, int offset,
	                                             int cycleLength, int[] A) {
	    int temp = A[offset];
	    System.out.println(" temp = " + temp);
	    System.out.println(" offset = " + offset);
	    for (int i = 1; i < cycleLength; ++i) {
	      int val = A[(offset + i * rotateAmount) % A.length];
	      A[(offset + i * rotateAmount) % A.length] = temp; 
	      temp = val;
	      
	      for(int j : A){
			  System.out.print(j + " ");
	      }
	      System.out.println();
	    }
	    A[offset] = temp;
	  }
	  // @exclude
	  
	  
	  public static void main(String [] args){
		  
		  
		  RotateArray a = new RotateArray();
		  
		  int [] arr = {0,1,2,3,4,5};
		  
		  a.rotateArray(2, arr);
		  
		  for(int i : arr)
			  System.out.print(i + " ");
		  
		  
	  }
	  
	}