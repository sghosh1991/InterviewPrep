package standardSorts;

public class QuickSort {
	
	
	public void partition(Comparable[] a,int lo,int hi)
	{
		int key = lo;
		int stopLs,stopRs;
		
		while(lo<hi){
			
			//left scan
			while(true){
				if(!less(a[lo],a[key])){
					stopLs = lo;
					break;
					
				}
				lo++;
			}
			
			while(true){
				if(less(a[hi],a[key])){
					stopRs = hi;
					break;
					
				}
				hi--;
			}
			
			if(lo<hi){
				exch(a,lo,hi);
			}
				
		}
		
		exch(a,key,hi);
		
		
	}
	
	private static  boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
				}

	
	private static void exch(Comparable[] a, int i, int j){
		
		Comparable t = a[i]; a[i] = a[j]; a[j]= t;
	}
	
	
	public static void main(String[] args) {
		String s="abc";
		System.out.println(s.substring(2, 2));

	}

}
