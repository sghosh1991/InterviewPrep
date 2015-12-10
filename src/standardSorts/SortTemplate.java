package standardSorts;

public abstract class SortTemplate {

	public abstract void sort(Comparable[] a);
	
	
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
	
	
}
