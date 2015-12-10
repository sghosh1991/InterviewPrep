package StringProblems;

import java.util.*;

/*
 * This program prints all possible mnemonics associated with a string of digits.
 * On a telephone pad 1 corresponds to abc 2-> def and so on. So a number like 123 will
 * correspond to lot of permutations. Print those permutations.
 * 
 */

public class telephoneMnemonics {

	/**
	 * @param args
	 */
	
	public static void printMnemonics(char [] number, Character [] partialResult, int length, int index, HashMap<Character,ArrayList<Character>>map){
		
		//String result = "";
		if(index == length){
			for(int i = 0;i<length;i++){
				System.out.print(partialResult[i]);
				
			}
			System.out.println();
			return;
		}
		
		else{
			
			for (Character s: map.get(new Character(number[index]))){
				
				partialResult[index] = s;
				
				printMnemonics(number,partialResult,length,index+1,map);
			}
			
			return;
			
			
		}
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Character,ArrayList<Character>> map = new HashMap<Character,ArrayList<Character>>();
		
		
		ArrayList<Character> list1 = new ArrayList<Character>();
		list1.add(new Character('a'));
		list1.add(new Character('b'));
		list1.add(new Character('c'));
		ArrayList<Character> list2 = new ArrayList<Character>();
		list2.add(new Character('d'));
		list2.add(new Character('e'));
		list2.add(new Character('f'));
		ArrayList<Character> list3 = new ArrayList<Character>();
		list3.add(new Character('g'));
		list3.add(new Character('h'));
		list3.add(new Character('i'));
		ArrayList<Character> list4 = new ArrayList<Character>();
		list4.add(new Character('j'));
		list4.add(new Character('k'));
		list4.add(new Character('l'));
		ArrayList<Character> list5 = new ArrayList<Character>();
		list5.add(new Character('m'));
		list5.add(new Character('n'));
		list5.add(new Character('o'));
		ArrayList<Character> list6 = new ArrayList<Character>();
		list6.add(new Character('p'));
		list6.add(new Character('q'));
		list6.add(new Character('r'));
		ArrayList<Character> list7 = new ArrayList<Character>();
		list7.add(new Character('s'));
		list7.add(new Character('t'));
		list7.add(new Character('u'));
		ArrayList<Character> list8 = new ArrayList<Character>();
		list8.add(new Character('v'));
		list8.add(new Character('w'));
		list8.add(new Character('x'));
		ArrayList<Character> list9 = new ArrayList<Character>();
		list9.add(new Character('y'));
		list9.add(new Character('z'));
		//list1.add(new Character('c'));
		
		map.put(new Character('1'), list1);
		map.put(new Character('2'), list2);
		map.put(new Character('3'), list3);
		map.put(new Character('4'), list4);
		map.put(new Character('5'), list5);
		map.put(new Character('6'), list6);
		map.put(new Character('7'), list7);
		map.put(new Character('8'), list8);
		map.put(new Character('9'), list9);
		
		//System.out.println(map);
		
		String number = "12";
		Character [] partialResult = new Character[number.length()];
		
		
		printMnemonics(number.toCharArray(),partialResult,number.length(),0,map);

	}

}
