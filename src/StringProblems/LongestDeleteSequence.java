package StringProblems;

import java.util.*;

public class LongestDeleteSequence {

	/**
	 * @param args
	 */
	
	private static HashSet<String> dictionary;
	private static int longestPathLength;
	private static String longestPathEndingNode;
	private static HashMap<String,String> finalMap;
	
	public LongestDeleteSequence(String[] arr){
		
		longestPathLength = Integer.MIN_VALUE;
		longestPathEndingNode = null;
		dictionary = new HashSet<String>();
		for(String s: arr){
			dictionary.add(s);
		}
		finalMap =  new HashMap<String,String>();
	}
	
	public static ArrayList<String> generateChildren(String str, HashSet<String> visited){
		
		ArrayList<String> children = new ArrayList<String>();
		
		String child;
		
		for(int i=0;i<str.length();i++){
			
			child = str.substring(0,i) + str.substring(i+1);
			
			
			
			if(dictionary.contains(child) && !visited.contains(child)){
				//child = chArr.toString();
				children.add(child);
				//visited.add(child);
			}
		}
		
		//System.out.println("Child of " + str + " generated: " + children);
		
	
		return children;
	}
	
	
	public static int longest_chain(String []arr){
		
		//String[] arr = {"abc", "abcd", "abcde", "abcdef", "acdef", "adef", "aef", "adef", "cbd"};
		HashMap<String,String> parentChildMap = null;
		HashSet<String> visited = null;
		
		for(String s:arr){
			
			visited = new HashSet<String>();
			parentChildMap = new HashMap<String,String>();
			//String s = "abcdef";
			visited.add(s);
			parentChildMap.put(s, null);
			dfsHelper(s, visited, parentChildMap, 1);

		
		}
		
		
		System.out.println(longestPathLength);
		return longestPathLength;
		//printLongestPath(longestPathEndingNode, finalMap);
		

		
	}
	
	
	private static void dfsHelper(String str,HashSet<String> visited,HashMap<String,String> parentChildMap, int pathLength){
		
		visited.add(str);
		
		if(pathLength > longestPathLength ){
			longestPathLength = pathLength;
			longestPathEndingNode = str;
			finalMap.clear();
			finalMap.putAll(parentChildMap);
		}
		
		ArrayList<String> children = generateChildren(str, visited);
		//System.out.println(visited);
	
		for(String s: children){
			
			if(!visited.contains(s)){
				parentChildMap.put(s,str);
				dfsHelper(s,visited,parentChildMap,pathLength+1);
			}
						
		}

	}
	
	
	
	public static void printLongestPath(String str,HashMap<String,String> parentChildMap){
		
		Stack<String> stack = new Stack<String>();
		while(str!=null){
			
			stack.push(str);
			str = parentChildMap.get(str);
			
		}
		
		String s=null;
		while(!stack.isEmpty()){
			s=stack.pop();
			if(stack.isEmpty()){
				System.out.print(s);
			}
			else{
				System.out.print(s + " -> ");
			}
			
		}
		
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num;
		
		
		Scanner sc  = new Scanner (System.in);
		num  = sc.nextInt();
		
		String[] arr = new String[num];
		int i = 0;
		
		while(i<num){
			
			arr[i] = sc.next();
			//System.out.println(i);
			i++;
		}
		
		LongestDeleteSequence l = new LongestDeleteSequence(arr);
		
		l.longest_chain(arr);
		

	}

}
