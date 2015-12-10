import java.util.*;
public class telephoneMnemonic {

	/**
	 * @param args
	 */
	
	
	
	public static void printAlphabets(String str){
		
		HashMap<Character,ArrayList<Character>> map = new HashMap<Character,ArrayList<Character>>();
		
		ArrayList<Character> two = new ArrayList<Character>();
		two.add('a');
		two.add('b');
		two.add('c');
		ArrayList<Character> three = new ArrayList<Character>();
		three.add('d');
		three.add('e');
		three.add('f');
		ArrayList<Character> four = new ArrayList<Character>();
		four.add('g');
		four.add('h');
		four.add('i');
		ArrayList<Character> five = new ArrayList<Character>();
		five.add('j');
		five.add('k');
		five.add('l');
		ArrayList<Character> six = new ArrayList<Character>();
		six.add('m');
		six.add('n');
		six.add('o');
		ArrayList<Character> seven = new ArrayList<Character>();
		seven.add('p');
		seven.add('q');
		seven.add('r');
		ArrayList<Character> eight = new ArrayList<Character>();
		eight.add('s');
		eight.add('t');
		eight.add('u');
		ArrayList<Character> nine = new ArrayList<Character>();
		nine.add('v');
		nine.add('w');
		nine.add('x');
		nine.add('y');
		nine.add('z');
		ArrayList<Character> zero = new ArrayList<Character>();
		ArrayList<Character> one = new ArrayList<Character>();
		
		zero.add('1');
		one.add('1');
		
		map.put('0', zero);
		map.put('1',one);
		map.put('2',two);
		map.put('3',three);
		map.put('4',four);
		map.put('5',five);
		map.put('6',six);
		map.put('7',seven);
		map.put('8',eight);
		map.put('9',nine);
		
		
		char [] partial = new char[str.length()];
		printCombinations(map, str, partial, 0, str.length());
		
	}
	
	
	public static void printCombinations(HashMap<Character,ArrayList<Character>> map, String num, char[] partialResult,int nextIdx, int lengthNum){
		
		ArrayList<Character> list;
		if(nextIdx == lengthNum){
			
			for(int i=0;i<nextIdx;i++){
				if(partialResult[i]!='1'){
					System.out.print(partialResult[i]);
				}
				
			}
			System.out.println();
			return;
		}
		
		else{
			
			list = map.get(num.charAt(nextIdx));
			
			
			for(char ch:list){
				partialResult[nextIdx] = ch;
				printCombinations(map, num, partialResult, nextIdx+1, lengthNum);
			}
			
			
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAlphabets("3402");

	}

}
