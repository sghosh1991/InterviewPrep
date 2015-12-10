import java.io.*;
import java.util.*;
public class zenefits {
    
    public static void maximizeSales(int [] ticketPrice, long m){
        
        
        //int sales = 0;
        
        int availableTickets = 0;
        
        //Create Max heap from the array
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(ticketPrice.length,Collections.reverseOrder());
        
        for(int element: ticketPrice){
            pq.add(element);
        }
        
        long sales = 0;
        
        for(long i=0;i<m;){
            
            int max = pq.peek();
            pq.poll();
            int secondMax = pq.peek();

            int satisiableFromtop = max - secondMax + 1;
            
            System.out.println("satisiableFromtop: " + satisiableFromtop);
            
            
//            for(int x=0;x<satisiableFromtop;x++){
//                sales = sales + (max-x);
//                System.out.println("Sales: " + sales);
//            }
            
            sales += max*(max+1)/2 - (max - satisiableFromtop)*(max - satisiableFromtop +1)/2 ;
            
            System.out.println("i: " + i);

            i += satisiableFromtop;

            pq.add(max - satisiableFromtop);

            
        }
        
        
            
     
        
        //draw first m tickets
        /*for(long i=0;i<m;i++){
            
            sales += pq.peek();
            availableTickets = pq.poll();
            pq.add(availableTickets - 1);
            
            
            
        }*/
        
        System.out.println(sales);
        
    }
    
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
//        Scanner sc =  new Scanner(System.in);
//        
//        int n = sc.nextInt();
//        long m = sc.nextLong();
//        int i = 0;
//        int [] arr = new int [n];
//        while(sc.hasNextInt()){
//            arr[i++] = sc.nextInt();
//            
//        }
    	
    	int [] arr = {5,2};
        
        maximizeSales(arr,4);
        
    }
}