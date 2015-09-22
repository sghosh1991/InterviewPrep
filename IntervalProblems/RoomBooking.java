package IntervalProblems;
import java.util.*;

import MyUtils.*;

public class RoomBooking {

	
	public class ScheduleComparatorClass implements Comparator<Pair<Integer,Integer>>{
		
		public int compare(Pair<Integer,Integer> o1,Pair<Integer,Integer> o2){
			return o1.getX() - o2.getX();
		}
		
	}
	
	public class Room {
		
		ArrayList<Pair<Integer,Integer>> schedules;
		public Room(){
			schedules = new ArrayList<Pair<Integer,Integer>>();
		}

	}
	
	public static ArrayList<Room> allRooms;
	
	public RoomBooking(int rooms){
		allRooms = new ArrayList<Room>();
		for(int i=0;i<rooms;i++){
			
			allRooms.add(new Room());
		}
		
	}

	public static void book(Pair<Integer,Integer> intervalToAdd, int roomId){
		
		Room r = allRooms.get(roomId-1);
		boolean bookingPossible = true;
		
		for(Pair<Integer,Integer> p: r.schedules){
			
			if(intervalToAdd.getX() > p.getY()){
				continue;
			}
			
			else{
				
				if(intervalToAdd.getY() <= p.getX()){
					bookingPossible = true;
					break;
				}
				else{
					bookingPossible = false;
					break;

				}
				
				
			}
		}
		
		if(bookingPossible){
			
			r.schedules.add(intervalToAdd);
			//Collections.sort(r.schedules,new ScheduleComparatorClass());
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
