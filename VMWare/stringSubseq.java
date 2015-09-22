package VMWare;

import java.util.ArrayList;
import java.util.*;

public class stringSubseq {

	/**
	 * @param args
	 */
	

	
	public static ArrayList<String> generateChildren(String str, HashSet<String> visited){
		
		ArrayList<String> children = new ArrayList<String>();
		
		String child;
		
		for(int i=0;i<str.length();i++){
			
			child = str.substring(0,i) + str.substring(i+1);
						
			if(!visited.contains(child)){
				//child = chArr.toString();
				if(!child.equals("")){
					children.add(child);
				}
				
				
			}
		}
		
		return children;
	}
	
	
	public static String[] buildSubsets(String s){
		
		
		HashSet<String> visited = null;
		
			
		visited = new HashSet<String>();
		
		//String s = "abcdef";
		visited.add(s);
		
		dfsHelper(s, visited);
		
		
		List<String> ans = new ArrayList<String>();
		
		for(String x : visited){
			ans.add(x);
		}
		
		Collections.sort(ans);
		
		String [] answer = new String[visited.size()];
		
		ans.toArray(answer);
		
		
				
		return answer;
		
			
	}
	
	
	private static void dfsHelper(String str,HashSet<String> visited){
		
		visited.add(str);

		if(str.equals("")){
			return;
		}
		
		ArrayList<String> children = generateChildren(str, visited);
		//System.out.println(visited);
	
		for(String s: children){
			
			if(!visited.contains(s)){
				//parentChildMap.put(s,str);
				dfsHelper(s,visited);
			}
						
		}

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abc";
		
		stringSubseq l = new stringSubseq();
		
		l.buildSubsets(s);
		

	}

}
