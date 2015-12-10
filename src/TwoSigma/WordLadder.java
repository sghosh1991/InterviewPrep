package TwoSigma;

import java.awt.geom.GeneralPath;
import java.util.*;

public class WordLadder {
	
	HashSet<String> visitedSet =  new HashSet<String>(); 
	HashSet<String> dictionary = null;
	String start = "";
	String end = "";
	ArrayList<String> path = new ArrayList<String>();
	
	
	public WordLadder(String start, String end, HashSet<String> dict){
		
		this.start = start;
		this.end = end;
		this.dictionary = dict;
	}
	
	
	public ArrayList<String> getChildren(String s){
		
		ArrayList<String> children = new ArrayList<String>();
		
		StringBuffer sBuff; 
		
		for(int i = 0; i< s.length();i++){
			
			sBuff = new StringBuffer(s);
			
			for(char c = 'a'; c <= 'z';c++){
				
				sBuff.setCharAt(i, c);
				
				if(sBuff.toString().equals(end)){
					
					System.out.println("Found path");
					System.exit(0);
				}
				
				if(!visitedSet.contains(sBuff.toString())){
					
					visitedSet.add(sBuff.toString());
					
					if(dictionary.contains(sBuff.toString())){
						children.add(sBuff.toString());
					}
					
				}
				
			}

		}
		
		System.out.println("Printing children for " + s);
		for(String s1: children){
			
			System.out.print(s1 + " ");
		}
		
		
		return children;
	}
	
	
	public void findShortestPath(){
		
		LinkedList<String> queue = new LinkedList<String>();
		
		queue.add(start);
		
		while(!queue.isEmpty()){
			
			printQ(queue);
			
			String head = queue.poll();
			
			System.out.println("Head is : " + head);
			
			
			if(head.equals(end)){
				
				System.out.println("Found path");
			}
			
			
			for(String s: getChildren(head)){
				queue.add(s);
			}
			
			System.out.println();
			
		}
	
	}
	
	
	public void printQ(LinkedList<String> q){
		
		System.out.println("Quue now");
		for(String s : q){
			System.out.print(s + " ");
		}
		System.out.println();
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> dict = new HashSet<String>();
		
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		
		
		WordLadder w = new WordLadder("hit", "cog", dict);
		w.findShortestPath();
	}

}
