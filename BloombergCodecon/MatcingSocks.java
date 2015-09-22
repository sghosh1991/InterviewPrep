package BloombergCodecon;
import java.util.Scanner;
import java.util.*;
//Your submission should *ONLY* use the following class name
public class MatcingSocks
{   
    
    static HashMap<String,Integer> sockPairs = new HashMap<String,Integer>();
    static int count = 0;
    
    public static void countPair(String str){
        
        StringBuffer rev = new StringBuffer(str).reverse();
        String sRev = new String(rev);
        
        if(!sRev.equals(str)){
        	
        	if(sockPairs.containsKey(str)){
            	
            	sockPairs.put(str, sockPairs.get(str)-1);
            	count ++;
            	
            	if(sockPairs.get(str) == 0){
            		sockPairs.remove(str);
            	}
            	
            }
            
            else{
            	
            	if(sockPairs.containsKey(sRev)){
            		
            		sockPairs.put(sRev, sockPairs.get(sRev)+1);
            		
            	}
            	else{
            		sockPairs.put(sRev, 1);
            	}
            	
            }
            
            
        }
        
        	
        }
        
    
    public static void main(String[] args)
    {

       String []stdin = {"bcd","erty","ytre","opipo","dcb"};
       for(String s:stdin) 
       {
    	   countPair(s);
    	   //System.out.println(sockPairs);
       }
       if(sockPairs.size() == 0){
           System.out.println(count);
       }
       else{
           System.out.println("-1");
       }
    }

}
