import java.util.*;


public class ScannerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int num;
		
				
		Scanner sc  = new Scanner (System.in);
		num  = sc.nextInt();
		
		String[] arr = new String[num];
		int i = 0;
		
		while(i<num){
			
			arr[i] = sc.next();
			System.out.println(i);
			i++;
		}
		
		for(String s: arr){
			
			System.out.println(s);
		}
		
		
		
		
		//System.out.println(vertices);
		
//		int i = 0;
//		
//		String line ;
//		
//		while(!(line = sc.nextLine()).isEmpty()) {
//		  //String[] values = line.split("\\s+");
//		  //System.out.print("entered: " + Arrays.toString(values) + "\n");
//			
//			if(i==0){
//				
//				vertices = Integer.parseInt(line);
//				System.out.println(vertices);
//				i++;
//			}
//			else{
//				
//				String[] values = line.split("\\s+");
//				System.out.println(Integer.parseInt(values[0]) + " " + Integer.parseInt(values[1]));
//			}
//			
//		}
//		System.out.print("Bye!");
		
		
		

	}

}
