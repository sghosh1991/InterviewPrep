package VMWare;

import java.util.*;

public class matrixLex {

	/**
	 * @param args
	 */
	
	
	static void gridLand(String s1) {

		
		
		int xDest = Integer.parseInt(s1.substring(0,1));
		
		int yDest = Integer.parseInt(s1.substring(1,2));
		
		int k = Integer.parseInt(s1.substring(2,3));
		
		
		
		HashMap<String,String> parentChildMap = new HashMap<String,String>();
		
		LinkedList<String> queue = new LinkedList<String>();
		
		ArrayList<String> shortestPaths = new ArrayList<String>();
		
		queue.offer("00K");
		
		ArrayList<String> children = null;
		int i =0;
		String dest = Integer.toString(xDest)+Integer.toString(yDest);
		System.out.println(dest);
		
		while(!queue.isEmpty()){
			
			System.out.println("Queue now: " + queue);
						
			children = generateChildren(queue.peek(), parentChildMap, xDest, yDest);
			
			
			
			for(String s : children){
				
				if(s.substring(0, 2).equals(dest)){
					
					String sp = generatePath(s,parentChildMap);
					shortestPaths.add(sp);
					
				}
				else{
					queue.offer(s);
				}
			}
			
			queue.poll();
			System.out.println(shortestPaths);

		}
		
		Collections.sort(shortestPaths);
		
		System.out.println(shortestPaths);

		
		System.out.println(shortestPaths.get(k));
		
		
		
		 
		
    }

	
	
	public static String generatePath(String s,HashMap<String,String> parentChildMap){
		
		
		StringBuffer sp = new StringBuffer();
		
		System.out.println("In generate path :" + s);
		System.out.println(parentChildMap);
		
		//System.out.println("SSSSSSSSSSSSSSSSSSSSSS");
		
		while(!s.substring(2, 3).equals("K")){
			
			sp.append(s.charAt(2));
			s = parentChildMap.get(s);
			System.out.print(s + " ");
		}
		
		System.out.println();
		//sp.append(s);
		
		sp.reverse();
		
		return new String(sp);
		
	}
	
	
	public static ArrayList<String> generateChildren(String str,HashMap<String,String> parentChildMap,int xMax, int yMax){
		
		ArrayList<String> children =  new ArrayList<String>();
		
		String s = str.substring(0,2);
		
		int x = Integer.parseInt(s.substring(0, 1));
		int y = Integer.parseInt(s.substring(1, 2));
		
		//vertical
		if(validMove(x+1, y, xMax, yMax)){
			s = Integer.toString(x+1) + Integer.toString(y) + "V";
			//System.out.println(x + " " + y);
			children.add(s);
			parentChildMap.put(s, str);
		}
		
		//horizontal
		if(validMove(x, y+1, xMax, yMax)){
			//System.out.println(x + " " + y);
			s = Integer.toString(x) + Integer.toString(y+1) + "H";
			children.add(s);
			parentChildMap.put(s, str);
		}
		
		
		System.out.println("Children of " + str + " : " + children);
		System.out.println(parentChildMap);
		return children;
		
	}
	
	
	
	public static boolean validMove(int x, int y, int xMax, int yMax){
		
		if(x > xMax || y > yMax){
			return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		gridLand("223");
		
		

	}

}
