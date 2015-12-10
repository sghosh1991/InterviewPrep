package HackerRank;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxTeamVal {
    
    
    public static void getMaxVal(int[] scores){
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(11,Collections.reverseOrder());
        
        for(int score : scores){
            pq.add(score);
        }
        
        int maxVal = 0;
        int teamSize = 0;
        int turn = 1;
        
        while(teamSize <3){
            
        	System.out.println("Turn: " + turn);
        	
            if(turn == 1){
            	int x = pq.poll();
            	System.out.println("first coach polled: " + x);
                maxVal += x;
                teamSize +=1;
                turn = turn ^ 1;

            }
            else{
            	int y = pq.poll();
            	System.out.println("second coach polled: " + y);
            	turn = turn ^ 1;
            }
            
            
        }
        
        System.out.println(maxVal);
        
        
    }
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        //Scanner sc = new Scanner(System.in);
        
        int []scores = {200,100,50,300,400,500,600,700,800,900};
        
//        int i=0;
//        while(i<10){
//            
//            scores[i++] = sc.nextInt();
//        }
        
        getMaxVal(scores);
        
    }
}