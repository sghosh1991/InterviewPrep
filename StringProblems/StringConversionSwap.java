package StringProblems;
import java.util.*;



public class StringConversionSwap {

	/**
	 * @param args
	 */
	
	
	public static void convertString(String str,String target){
		
		LinkedList<String> queue = new LinkedList<String>();
		
		HashSet<String> set = new HashSet<String>();
		String head;
		//ArrayList<StringConversionNode> visited = new ArrayList<StringConversionNode>();
		HashMap<String,String> map = new HashMap<String,String>();
		ArrayList<String> children;
		
		set.add(str);
		map.put(str,null);
		queue.add(str);
		
		//System.out.println(queue.peek());
		
		while(!queue.isEmpty()){
			
			head = queue.remove();
			//System.out.println(head);
			
			
//			if(head.equals(target)){
//				break;
//			}
			
			children = generateChildren(head, set);
			queue.addAll(children);
			for(String s:children){
				map.put(s,head);
				if(s.equals(target)){
					showPath(map,target);
					
					return;
				}
			}
			//while(true);
		}
		
		
		
	
	}
	
	
	public static void showPath(HashMap<String,String> map, String target){
		
		ArrayList<String> seq = new ArrayList<String>();
		//StringConversionNode s = sequence.get(sequence.size()-1);
		String s = target;
		
		System.out.print(s + "-->");
		
		while(map.get(s) !=null){
			
			System.out.print(map.get(s) + "-->");
			s = map.get(s);
			
		}
		
		
		
	}
	
	public static ArrayList<String> generateChildren(String str, HashSet<String> set){
		
		ArrayList<String> children = new ArrayList<String>();
		char[] chArr; 
		char temp;
		String child;
		
		for(int i=0;i<=str.length()-2;i++){
			
			chArr = str.toCharArray();
			temp = chArr[i];
			chArr[i] = chArr[i+1];
			chArr[i+1] = temp;
			
//			System.out.println("set--->");
//			for(String s:set)
//				System.out.println(s);
//			System.out.println("set--->");
//			
			
			child = new String(chArr);
			//System.out.println("Child generated: " + child);
			
			
			if(!set.contains(child)){
				//child = chArr.toString();
				children.add(child);
				set.add(child);
			}
		}
		
//		System.out.println("children--->");
//		for(String s:children)
//			System.out.println(s);
//		System.out.println("children--->");
		
		//while(true);
		
		return children;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		convertString("GUM", "MUG");
	}

}
