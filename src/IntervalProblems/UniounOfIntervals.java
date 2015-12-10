package IntervalProblems;

import java.util.Comparator;
import java.util.*;
import MyUtils.Pair;

/*
 * Given a set of intervals compute their union
 * Also contains a method to add a closed interval to a set of disjoint intervals
 * 
 */


public class UniounOfIntervals {

	/**
	 * @param args
	 */
	
	private ArrayList<Pair<Integer,Integer>> intervalList;
	private ArrayList<Pair<Integer,Integer>> unionOfIntervals;
	
	public class IntervalComparatorClass implements Comparator<Pair<Integer,Integer>>{
		
		public int compare(Pair<Integer,Integer> o1,Pair<Integer,Integer> o2){
			return o1.getX() - o2.getX();
		}
		
	}

	
	public UniounOfIntervals(ArrayList<Pair<Integer,Integer>> arr){
	
		Collections.sort(arr, new IntervalComparatorClass());
		this.intervalList = arr;
	}
	
	public void printIntervalList(){
		
		for(Pair<Integer,Integer> x:intervalList)
			System.out.println(x);
	}
	
	
	
	public void printUnionOfIntervals(){
		
		for(Pair<Integer,Integer> x:unionOfIntervals)
			System.out.println(x);
	}
	
	public ArrayList<Pair<Integer,Integer>> union(){
		
		unionOfIntervals = new ArrayList<Pair<Integer,Integer>>();
		Pair<Integer,Integer> s,t;
		
		
		//t will contain the merged interval. s will iterate over the unprocessed intervals
		//if t and s are mergable we merge it and set t to the merged interval
		//we add t to the final list if we get a disjoint adjacent t and s pair.
		
		t=intervalList.get(0);
		
		
		for(int i=1;i<intervalList.size();i++){
			
			s = intervalList.get(i);
			if(t.getY() < s.getX()){
				//No merging possible
				unionOfIntervals.add(t);
				//System.out.println("added " + t + " to list");
				t = s;
								
			}
			
			else if(t.getY() >= s.getX()){
				
				//System.out.print("Unified " + t + " with " + s + " to get ");
				t = unify(t,s);
				//System.out.println(t);
				
			}
		
		}
		
		unionOfIntervals.add(t);
		
		
		return unionOfIntervals;
		
	}
	
	
	
	
	
	public void addClosedinterval(Pair<Integer,Integer> interval){
		
		ArrayList<Pair<Integer,Integer>> result = new ArrayList<Pair<Integer,Integer>>();
	
		//first add to the answer all such intervals that cannot intersect with the given interval
		int i=0;
		
		
		while(i< unionOfIntervals.size() && interval.getX() > unionOfIntervals.get(i).getY()){
			result.add(unionOfIntervals.get(i));
			i++;
		}
		
		//System.out.println("After skipping i=" + i);
		
		//i now points to the interval with whom an intersection MAY be possible
		while(i<unionOfIntervals.size() && unionOfIntervals.get(i).getX() <= interval.getY()){
			
			//System.out.println("unify " + interval + " with " + unionOfIntervals.get(i));
			interval = unify(interval,unionOfIntervals.get(i));
			//System.out.println("Mergerd interval: " + interval);
			i++;
			
		}
		
		result.add(interval);
		
		
		//Simply add the remaining disjoint intervals to the result
		while(i<unionOfIntervals.size()){
			result.add(unionOfIntervals.get(i++));
		}
			
	
		for(Pair<Integer,Integer> x: result)
			System.out.println(x);
			
	}
	
	
	
	
	public Pair<Integer,Integer> unify(Pair<Integer,Integer> int1,Pair<Integer,Integer> int2 ){
		
		/*
		 * Unify has to be generic. I should be able to throw any two unifiable intervals 
		 * and it should unify them.
		 * So first classify the intervals  as left(t) and right(t)
		 * based on their left end points
		 * 
		 */
		
		Pair<Integer,Integer> t,s;
		
		if(int1.getX() <= int2.getX()){
			t = int1;
			s= int2;
		}
		else{
			
			t=int2;
			s=int1;
		}
		
				
		Pair<Integer,Integer> union = new Pair(0,0);
		
		if(t.getY() == s.getX()){
			
			union.setX(t.getX());
			union.setY(s.getY());
		}
		
		else {
			
			union.setX(Math.min(t.getX(), s.getX()));
			union.setY(Math.max(t.getY(), s.getY()));
			
		}
		
		return union;
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Pair<Integer,Integer>> list = new ArrayList<Pair<Integer,Integer>>();
		Pair<Integer,Integer> p = new Pair(0,3);
		list.add(p);
		p=new Pair(16,17);
		list.add(p);
		p=new Pair(3,4);
		list.add(p);
		p=new Pair(2,4);
		list.add(p);
		p=new Pair(9,11);
		list.add(p);
		p=new Pair(5,7);
		list.add(p);
		p=new Pair(12,14);
		list.add(p);
		p=new Pair(8,11);
		list.add(p);
		
		
		UniounOfIntervals u = new UniounOfIntervals(list);
		
		//u.printIntervalList();
		u.union();
		u.printUnionOfIntervals();
		
		System.out.println("Adding (6,9");
		u.addClosedinterval(new Pair(6,9));
		//u.printUnionOfIntervals();
		
		

	}

}
