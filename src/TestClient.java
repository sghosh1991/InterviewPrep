import HeapProblems.*;
import java.awt.*;

public class TestClient {

	
	public static void test(int [][]T){
		T[0][0] = 5;
	}
	
public static void main(String args[]){
		
		int [][]arr =  new int [4][4];
		arr[0][0] = 9;
		System.out.println(arr[0][0]);
		test(arr);
		System.out.println(arr[0][0]);
		
		Point p = new Point(1,2);
		System.out.println(p);
		
	}
	
	
}
