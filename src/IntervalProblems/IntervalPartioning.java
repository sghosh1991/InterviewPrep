package IntervalProblems;

import java.util.*;

import MyUtils.Pair;

public class IntervalPartioning {

	/**
	 * @param args
	 */
	
	//Comparator for sorting the classes as per the start time
	public class IntervalComparatorClass implements Comparator<Pair<Integer,Integer>>{
			
		public int compare(Pair<Integer,Integer> o1,Pair<Integer,Integer> o2){
			return o1.getX() - o2.getX();
		}
		
	}
	
	
	
	//Classrooms are denoted by classroom object
	public class ClassRoom implements Comparable<ClassRoom>{
		
		ArrayList<Integer> lectures; //contains the starting times of all the lectures scheduled in this class
		int blockedTill;
		
		public ClassRoom(Pair<Integer,Integer> lecture){
			lectures = new ArrayList<Integer>();
			this.lectures.add(lecture.getX());
			this.blockedTill = lecture.getY();
		}
		
		public int compareTo(ClassRoom C){
			
			return this.blockedTill - C.blockedTill;
		}
		
		public String toString(){
			
			String s="Classroom Schedule: -> ";
			
			for(int i: lectures)
				s += " " + i;
			
			return s;
		}
		
		

	}
	
	
	//A queue to keep the classrooms needed
	private PriorityQueue<ClassRoom> classrooms = new PriorityQueue<ClassRoom>();
	
	
	public void scheduleClasses(ArrayList<Pair<Integer,Integer>> lectures){
		
		Collections.sort(lectures, new IntervalComparatorClass());
		
//		for(Pair<Integer,Integer> x:lectures)
//			System.out.println(x);
		
		for(Pair<Integer,Integer> lecture: lectures){
			
			if(classrooms.size()>0 && isCompatible(lecture,classrooms.peek())){
				
				//System.out.println("IF");
				ClassRoom c = classrooms.poll();
				c.blockedTill = lecture.getY();
				c.lectures.add(lecture.getX());
				classrooms.add(c);
			}
			else{
				
				ClassRoom c = new ClassRoom(lecture);
				classrooms.add(c);
				//System.out.println("New classroom allocated");
				
			}

		}
		
//		ArrayList<ClassRoom> finalSchedule = new ArrayList<ClassRoom>(classrooms);
//		return finalSchedule;
		
	}
	
	
	
	private boolean isCompatible(Pair<Integer,Integer> lecture, ClassRoom classroom){
		
		if(classroom.blockedTill < lecture.getX())
			return true;
		else
			return false;
		
		
	}
	
	
	
	public void printSchedule(){
		
		int i=0;
		for(ClassRoom c: classrooms){
			System.out.println("Room#" + ++i + " " + c);
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Pair<Integer,Integer>> list = new ArrayList<Pair<Integer,Integer>>();
		Pair<Integer,Integer> p = new Pair(9,10);
		list.add(p);
		p=new Pair(9,10);
		list.add(p);
		p=new Pair(9,13);
		list.add(p);
		p=new Pair(11,13);
		list.add(p);
		p=new Pair(11,17);
		list.add(p);
		p=new Pair(14,15);
		list.add(p);
		p=new Pair(14,15);
		list.add(p);
		p=new Pair(16,17);
		list.add(p);
		p=new Pair(16,17);
		list.add(p);
		
		
		IntervalPartioning ip = new IntervalPartioning();
		
		ip.scheduleClasses(list);
		ip.printSchedule();

	}

}
