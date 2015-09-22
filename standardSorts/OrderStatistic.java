package standardSorts;

public class OrderStatistic {


	
		public static int largestKthElement(int a[], int lo,int hi,int k){
			
			int index;
			index = partition(a, lo, hi);
			System.out.println("Debug: index =" + index);
			int result;
			int kOrg=k;
			
			while(true){
				
				if(index == kOrg){
					result= a[index];
					break;
				}
				
				else if(index > k){
					
					hi=index-1;
					System.out.println("Debug: Index Greater index =" + index + " k = " + k);
					index= partition(a,lo,hi);
				}
				
				
				else{
					k=k-index-1;
					lo=index+1;
					System.out.println("Debug: Index Smaller index =" + index + " k = " + k);
					index= partition(a,lo,hi);
				}
				
				
			}
			
			
			
			
			return result;
			
			
			
			
		}
		

	
	public static int partition(int a[],int lo,int hi){


		int leftPtr=lo+1;
		int pivot = a[lo];
		int rightPtr = hi;
		
		System.out.println("In Partition... lo =" + lo + " hi= " + hi);
		
		while(true){


			//left scan
			while(a[leftPtr] < pivot){

				if(leftPtr == hi+1){
					leftPtr--;
					break;
				}
				leftPtr++;
			}

			System.out.println("After left scan leftPtr " + leftPtr);

			//right scan
			while(a[rightPtr] > pivot){

				if(rightPtr == lo)
					break;

				rightPtr--;
			}


			System.out.println("After right scan rightPtr " + rightPtr);

			if(leftPtr >= rightPtr) break;
			swap(a,leftPtr,rightPtr);	
/*
			for(int j=0;j<a.length;j++){
				System.out.print(a[j] + " ");
			}
			System.out.println();*/
		}

		swap(a,lo,rightPtr);

/*		for(int j=0;j<a.length;j++){
			System.out.println(a[j]);
		}
*/
		return rightPtr;

	}

	public static int[] swap(int a[],int i,int j){
		int temp;
		temp = a[i];
		a[i]=a[j];
		a[j]=temp;

		return a;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]={4,8,10,1,3,4,2,10};
		int k=6;
		//System.out.println("Index of " + a[0] + " " + partition(a,0,a.length-1));
		System.out.println(" K = " + k + " " + largestKthElement(a, 0, a.length-1, k));

	}

}
