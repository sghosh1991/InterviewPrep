package HeapProblems;

/*
 * Calculate the average of a stream of numbers except the top 3 numbers
 * which can be considered as outliers
 */

public class AverageExceptOutliers {
	
	
	public static float getAverageExceptOutliers(){
		
		float average = 0;
		int sum = 0;
		int count=0;
		
		int [] arr = {7,12,798,4,6,53,20,9,1000,4};
		
		TopKElements outliers = new TopKElements(3);
		for(int i:arr){
			outliers.add(i);
			count++;
			sum+= i;
		}
		
		System.out.println("Outliers are: =====> ");
		outliers.printHeap();
		
		while(outliers.iterator().hasNext()){
			
			sum = sum - outliers.remove();
			count--;
		}
		
		System.out.println(sum + ":" + count);
		
		average = (float)sum/count;
		
		return average;
	}
	
	public static void main(String args[]){
		
		System.out.println("The average is: " + getAverageExceptOutliers());
		
	}

}
