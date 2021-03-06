package standardSorts;

public class InsertionSort {
	
	public static void sort(Comparable[] a)
	{
		int i,j;
		
		for(i=1;i<a.length;i++){
			
			for(j=i; j>0 && less(a[j],a[j-1]);j--){
				exch(a,j,j-1);
			}
			
		}
		
		
	}

	
	private static  boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
				}

	
	private static void exch(Comparable[] a, int i, int j){
		
		Comparable t = a[i]; a[i] = a[j]; a[j]= t;
	}
	
	
	public static boolean isSortedAscending(Comparable[] a){
		
		for(int i=0;i<a.length-1;i++){
			if(!less(a[i],a[i+1]))
				return false;
		}
		return true;
	}
	
	
	private static void show(Comparable[] a)
	{ // Print the array, on a single line.
	for (int i = 0; i < a.length; i++)
	System.out.print(a[i] + " ");
	System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"S","A","N","T","O","S","H"};
		sort(a);
		assert isSortedAscending(a);
		show(a);

	}

	
	
}
