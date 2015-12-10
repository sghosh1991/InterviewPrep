package standardSorts;

import java.util.Arrays;

public class SearchArrayUnknownLength {



	public static int binarySearch(int a[],int lo,int hi, int key) throws ArrayIndexOutOfBoundsException {

		int mid = (lo+hi)/2;

		while(lo<=hi){
			
			mid = (lo+hi)/2;
			System.out.println("hi = "+ hi + " lo = " + lo + "mid = " + mid + " a[mid] =" +a[mid]);
			if(a[mid]==key){
				
				System.out.println("Found");
				return mid;
			}
				
			else if(a[mid]>key){
				
				System.out.println("Greater ");
				hi=mid-1;
			}
				
			else{
				
				System.out.println("Lesser");
				lo=mid+1;
			}

		}

		return -1;

	}

	public static int search(int a[],int k){

		int lo=0;
		int hi,i=0,searchIndex=0;
		int index=-1;

		try{
			
			System.out.println("Entering while loop");
			
			while(a[searchIndex]<=k){
				
				if(a[searchIndex]==k){
					return searchIndex;
				}
				searchIndex=(int)Math.pow(2,i);
				System.out.println("searchIndex = "+searchIndex + " value of i=" + i);
				i++;
				
			}
			System.out.println("Exiting while loop..Value of searchIndex ="+searchIndex);
			if(a[searchIndex]>k){
				//call modified binary search with hi and lo values
				lo = searchIndex/2 +1;
				hi = searchIndex-1;
				System.out.println("Calling binary search 1 with lo =" + lo + " hi = " + hi + " key = " + k);
				index = binarySearch(a,lo,hi,k);

			}

		}
		catch(ArrayIndexOutOfBoundsException e){
			
			System.out.println("Array out of bounds 1 searchIndex = " + searchIndex);

			lo = searchIndex/2 +1;
			hi = searchIndex-1;

			for(;;){

				try{

					System.out.println("Calling binary search with lo =" + lo + " hi = " + hi + " key = " + k);
					index=binarySearch(a, lo,hi,k);
					if(index >-1)
						return index;

				}


				catch (ArrayIndexOutOfBoundsException ex){
					
					System.out.println("Array out bounds 2 for index = " + searchIndex);
					
					hi--;
					continue;
					
				}

			}


		}
		
		return index;


	}

	public static void main(String[] args) {
		
		int a[] = {2,12,13,25,30,34,41,56,78,87};		
		/*for(int i=0;i<120;i++){
			
			a[i]= (int)(Math.random()) * 500;
		}*/
		
		int index = search(a,35);
		System.out.println("searching...." + index);
		if(index>-1){
			System.out.println("Element at index "+ index + " is : "+a[index]);
		}
		
		
		
	}

}
