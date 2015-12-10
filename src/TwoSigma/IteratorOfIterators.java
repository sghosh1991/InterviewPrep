package TwoSigma;

import java.util.*;


public class IteratorOfIterators {
	
	Iterator<ArrayList<Integer>> outerIter = null;
	Iterator<Integer> innerIter = null;
	Integer nextElement = null;
	List<ArrayList<Integer>> listOfLists = null;
	
	public IteratorOfIterators(List<ArrayList<Integer>> list){
		
		this.outerIter = list.iterator();
		this.listOfLists = list;
	
	}
	
	
	public boolean hasNext(){
		
		if(outerIter.hasNext() != false){
			
			//System.out.println("Outer iter has next");
			return true;
		}
		
		//System.out.println("Outer iter has no  next");
		
		return false;
		
		
	}
	
	
	public Integer next(){
		
		List<Integer> innerList = outerIter.next();
		
		if(innerList.size() == 0){
			
			//remove the entry till you get a non empty list
			
			do{
				
				outerIter.remove();
				
				if(outerIter.hasNext()){
					
					innerList = outerIter.next();
				}
				else{
					
					outerIter = listOfLists.iterator();
					if(outerIter.hasNext()){
						innerList = outerIter.next();
					}
					else
						return null;
					
				}
				
			}while(innerList.size() == 0);

		}
		
		//now we have a list where the size > 0
		//return the next element fromt this list
		
		innerIter = innerList.iterator();
		Integer next  = innerIter.next();
		innerIter.remove();
		
		if(innerIter.hasNext() == false){
			outerIter.remove();
		}
		if(outerIter.hasNext() == false){
			outerIter = listOfLists.iterator();
		}
		
		
		return next;
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		//a.add(1);
		//a.add(2);
		//a.add(3);
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		
		b.add(4);
		
		
		ArrayList<Integer> c = new ArrayList<Integer>();
		//c.add(5);
		//c.add(6);
		
		listOfList.add(a);
		listOfList.add(b);
		listOfList.add(c);
		
		
		IteratorOfIterators it = new IteratorOfIterators(listOfList);
		
		while(it.hasNext()){
			
			System.out.println(it.next());
			
			
		}

	}

}
