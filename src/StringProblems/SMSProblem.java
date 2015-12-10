package StringProblems;
import java.util.*;

public class SMSProblem {

	
	public static void sms(String str){
		
		HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		ArrayList<String> two=new ArrayList<String>();
		two.add("A");
		two.add("B");
		two.add("C");
		ArrayList<String> three=new ArrayList<String>();
		three.add("D");
		three.add("E");
		three.add("F");
		ArrayList<String> space=new ArrayList<String>();
		space.add(" ");
		ArrayList<String> hash=new ArrayList<String>();
		hash.add("");
		ArrayList<String> nine=new ArrayList<String>();
		nine.add("W");
		nine.add("X");
		nine.add("Y");
		nine.add("Z");
		map.put("2", two);
		map.put("3", three);
		map.put("*", space);
		map.put("#", hash);
		map.put("9", nine);
		
		
		
		
		int left=0,right=0;
		int count=0;
		
		String s="";
		
		char [] strArr = str.toCharArray();
		
		while(right < strArr.length){
			
			while((right < strArr.length) && strArr[left]==strArr[right]){
				
				right++;
				count++;
				
							
			}
			
			s += lookUp(map, new Character(strArr[left]).toString(), count);
			count=0;
			left=right;
			
			//right++;
			
			
		}
		
		
		System.out.println(s);
		
	}
	
	public static String lookUp(HashMap<String,ArrayList<String>>map,String s,int count){
		
		System.out.println(count);
		
		ArrayList<String> mappedChars = map.get(s);
		if(s.equals("9")){
			return mappedChars.get((count-1)%4);
		}
		else if(s.equals("*")){
			String ret="";
			while(count--!=0)
				ret+=" ";
			return ret;		
		}
		
		else if(s.equals("#")){
			
			return "";
		}
				
		else
			return mappedChars.get((count-1)%3);
		
		
		//return "";
		
	}
	
	public static void main(String args[]){
		
		sms("222**3#3");
		
	}
	
}
