package TwoSigma;

public class CountInversions {

	static int [] aux;
	static int inversions;
	
	public CountInversions(int [] arr){
		aux = new int[arr.length];
	}
	public static void merge(int[] arr, int lo, int mid, int hi){
		
		int i = lo;
		int j = mid+1;
		int k = lo;
		
		for(;;){
			
			if(arr[i] < arr[j]) { aux[k] = arr[i++] ; k++;}
			else if(arr[i] > arr[j]) {aux[k] = arr[j++]; k++; inversions+= mid-i+1;}
			else{
				
				aux[k] = arr[i];
				i++;
				j++;
				k++;
			}
			
			if((i > mid) || (j > hi)){break;}
	
		}
		
		System.out.println("after merge " + "k :" + k + " i : " + i + " j: " + j);
		
		if(i>mid){
			for(;k<=hi;k++){
				aux[k] = arr[j++];
			}
		}
		else{
			for(;k<=hi;k++){
				aux[k] = arr[i++];
			}
		}
		
		for(k=lo;k<=hi;k++){
			arr[k] = aux[k];
		}
		
		System.out.println("Merging : " + lo + " : " + mid + " with " + (mid+1) + " : " + hi);
		for(i=lo;i<=hi;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}
	
	public static void sort(int [] arr, int lo, int hi){
		
		
		System.out.println("Calling sort with " + lo + " : " + hi);
		
		if(lo>=hi) return;
		
		int mid =  (lo+hi)/2;
		
		sort(arr,lo,mid);
		sort(arr,mid+1,hi);
		merge(arr, lo, mid, hi);
	
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {6,3,4,5,2,7};
		CountInversions c = new CountInversions(arr);
		System.out.println(arr.length);
		sort(arr, 0, arr.length-1);
		
		for(int i: arr){
			System.out.println(i);
		}
		
		System.out.println("Inversions : " + CountInversions.inversions);
	}

}
