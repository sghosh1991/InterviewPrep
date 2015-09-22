package standardSorts;

public class LongestContiniousSum {

	
	public static int largestContiniusSum(int a[]){
		
		int maxSum= Integer.MIN_VALUE;
		int sum=0;
		
		for(int i = 0;i<a.length;i++){
			
			
			sum += a[i];
			
			if(sum < 0){
				
				sum=0;
			}
			
			if(sum > maxSum){
				maxSum = sum;
			}
			
		}
		
		return maxSum;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {3,5,5,-6,-9,8,4};
		System.out.println("The maximum sum is : " + largestContiniusSum(a));
	}

}
