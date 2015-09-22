package HeapProblems;

import java.util.*;


public class TopKElements{

	private static PriorityQueue<Integer> heap;
	private int capacity;
	private int size=0;
	
	public static class CustomComparator implements Comparator<Integer>{
		
		public int compare(Integer o1,Integer o2){
			
			return (o1-o2); //max heap
		}
	}
	
	public TopKElements(int capacity){
		
		this.capacity = capacity;
		this.heap = new PriorityQueue<Integer>(capacity, new CustomComparator());
		
	}
	
	public void add(int element){
		++size;
		if(size>capacity){
			
			int x = heap.comparator().compare(heap.peek(),element );
			
			//Add a new element only if it is larger than the head element
			/*
			 * Heap tells us that the head element is the smallest(min heap)
			 * If the new element is smaller than heap then it can never be in top k
			 * Only if it is larger than the head then it has got a chance to be in top k
			 * 
			 */
			
			if(x<0){
			heap.remove();
			heap.offer(element);
			size--;
			}
			
		}
		else
			heap.offer(element); //Add the element is there is capacity
		
		
		//printHeap();
	}
	
	
	public int remove(){
		return this.heap.remove();
	}
	
	public Iterator<Integer> iterator(){
		return this.heap.iterator();
	}
	
	
	public void printHeap(){
		
		System.out.println("The PQ is:\t" + this.heap);
		
	}
	
	
}
