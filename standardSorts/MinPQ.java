package standardSorts;
import java.util.*;

public class MinPQ {
	
	public static class myComparator implements Comparator<Integer>{
		
		public int compare(Integer a,Integer b){
			return b-a;
		}
	}
	
	myComparator cmp = new myComparator();
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3,cmp);
	
	public void getTopK(){
		
		
		int[] arr = {3,4,5,1,2,-3,9,4,6,7,0};
		
		for(int i=0;i<arr.length;i++){
			
			if(i>2){
				System.out.print("Moved : " + pq.poll() + "\n");
			}
			
			pq.offer(arr[i]);
			
			System.out.println("Printing...");
			for(Integer c: pq){
				
				System.out.print(c + " ");
				
			}
			System.out.println("");
			
			
		}
		
		/*for(Integer i : pq){
			System.out.print(i+" ");
		}*/
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinPQ x = new MinPQ();
		x.getTopK();
	}

}
