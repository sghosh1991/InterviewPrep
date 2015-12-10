import java.util.*;

public class fibonacciEncoding {

	/**
	 * @param args
	 */
	
	
	
	
	
	static String encodeFibonacci(int n){
		
		ArrayList<Integer> fib = new ArrayList<Integer>();
		fib.add(1);
		fib.add(2);
		return encode(n, fib);
	}
	
	public static String encode(int n, ArrayList<Integer> fib){
		
		//System.out.println("Calling mapcode with " + n + " " + fib);
		
		if(n==0) return "";
		
		ArrayList<Integer> newList = new ArrayList<Integer>();
		
		while(n> fib.get(fib.size() - 1)){
			fib.add(fib.get(fib.size() - 1) + fib.get(fib.size() - 2));
		}
		
		System.out.println(fib);
		
		int i = 0;
		while(i<fib.size() && n>=fib.get(i)){
			newList.add(fib.get(i));
			i++;
		}
		
		int newListLen = newList.size();
		
		//System.out.println(newList);
		
		int remaining = n - newList.get(newListLen - 1);
		
		
		StringBuffer temp = new StringBuffer();
		
		String res = encode(remaining, newList);
		
		//System.out.println("Returned : " + res);
		
		int repeatZero = newListLen - 1 - res.length();
		
		String repeatZeros = "";
		
		for(int j=0;j<repeatZero;j++){
			repeatZeros += "0";
		}
		
		temp.append("1").append(repeatZeros).append(res);
		
		//System.out.println("Returning : " + temp);
		
		return new String(temp);
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(encodeFibonacci(3));

	}

}
