import java.util.*;

public class TestPassword {

	/**
	 * @param args
	 */
	
	
	
	public static boolean checkPassword(String password){
		
		//check length
		if(password.length() <= 5 || password.length() >=12)
			return false;
		
		
		boolean hasLowercase = false;
		boolean hasNumber = false;
		
		char[] pswdArr = password.toCharArray();
		
		for(char ch : pswdArr){
			if( (int)ch >=48 && (int)ch<=57)
				hasNumber = true;
			if((int)ch >= (int)'a' || (int)ch <= (int)'z' )
				hasLowercase = true;
		}
		
		if(!(hasLowercase && hasNumber)){
			
			System.out.println("Failed number alpha test");
			return false;
		}
		
		System.out.println("Passed number alpha test");
		
		
		ArrayList<Integer> indices;
		
		HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
		
		for(int i=0;i<password.length();i++){
			
			for(int j=password.length();j>=i;j--){
				
				if(!map.containsKey(password.substring(i,j))){
					
					indices = new ArrayList<Integer>();
					indices.add(i);
					indices.add(j-1);
					
					map.put(password.substring(i,j), indices);
				}
				else{
					
					if(map.get(password.substring(i,j)).get(1) == i-1){
						
						System.out.println("Failed consequtive substring test");
						return false;
					}
						
					
				}
				
			}
		}
		
		System.out.println("Passed consequtive substring test");
		return true;
		
	}
	
	
	
	
	public static void verifyPassword(String passwdExpected, String passwdEntered){
		
		
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		
		ArrayList<Integer> allowed = new ArrayList<Integer>();
		allowed.add(2);
		allowed.add(4);
		map.put(1, allowed);
		
		allowed = new ArrayList<Integer>();
		allowed.add(1);
		allowed.add(3);
		allowed.add(5);
		map.put(2, allowed);
		
		
		allowed = new ArrayList<Integer>();
		allowed.add(2);
		allowed.add(6);
		map.put(3,allowed);
		
		
		allowed = new ArrayList<Integer>();
		allowed.add(1);
		allowed.add(5);
		allowed.add(7);
		map.put(4, allowed);
			
		allowed = new ArrayList<Integer>();
		allowed.add(2);
		allowed.add(8);
		allowed.add(6);
		allowed.add(4);
		map.put(5, allowed);
		
		allowed = new ArrayList<Integer>();
		allowed.add(3);
		allowed.add(9);
		allowed.add(5);
		map.put(6, allowed);
		
		allowed = new ArrayList<Integer>();
		allowed.add(4);
		allowed.add(8);
		map.put(7, allowed);
		
		allowed = new ArrayList<Integer>();
		allowed.add(5);
		allowed.add(7);
		allowed.add(9);
		map.put(8, allowed);
		
		
		allowed = new ArrayList<Integer>();
		allowed.add(6);
		allowed.add(8);
		map.put(9,allowed);
		
		
		
		//System.out.println(map);
		
		
		
		char[] pswdExp = new char[passwdExpected.length()];
		char[] pswdEnt = new char[passwdEntered.length()];
		boolean fault = false;
		pswdEnt = passwdEntered.toCharArray();
		pswdExp = passwdExpected.toCharArray();
				
		ArrayList<Integer> list;
		
		
		
		for(int i=0;i<pswdExp.length;i++){
			
			//System.out.print("SSSSS");
			
			if(pswdExp[i] != pswdEnt[i]){
				
				if(!fault){
					list = map.get((int)(pswdExp[i] - '0'));
					if(list.contains((int)(pswdEnt[i] - '0'))){
						System.out.println("Fault: " + pswdExp[i] + "-" + pswdEnt[i]);
						fault = true;
						continue;
					}
					else{
						System.out.println("Couldnt match the on one error");
						return;
					}
							
					
				}
				else{
					
					System.out.println("More than one error");
					return;
				}
			} // end of if statement=> if the chars dont match
			
			System.out.println(pswdEnt[i] + " --> " + pswdExp[i]);
	
		} //end of  for loop
		
		System.out.println("Success");
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//checkPassword("ac1234123a");
		verifyPassword("1478","1179");

	}

}
