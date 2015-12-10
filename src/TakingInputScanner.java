import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TakingInputScanner {
    
    
    public static void countPairs(Integer []arr){
        
        
        HashMap<Integer,Integer> seenElements = new HashMap<Integer,Integer>();
        
        //ArrayList<Integer> countList = new ArrayList<Integer
        
        for(int i=0;i<arr.length;i++){
            
            if(!seenElements.containsKey(arr[i])){
                seenElements.put(arr[i],1);
            }
            else{
                
                seenElements.put(arr[i],seenElements.get(arr[i])+1);
            }
            
        }
        
        BigInteger count=null;
        for(int element:seenElements.keySet()){
            if(seenElements.get(element) > 1){
            	System.out.println("count is :" + seenElements.get(element));
                count.add(factorial(seenElements.get(element)).divide(factorial(seenElements.get(element)-2)));
                System.out.println(count);
            }
            
        }
        
        if(count == null){
            System.out.println("0");
        }
        
        
    }
    
    
    public static BigInteger factorial(int i){
        
        BigInteger fact = new BigInteger("1");
        while(i>1){
            fact = fact.multiply(new BigInteger(new Integer(i).toString()));
            i--;
        }
        
        return fact;
    }
    
    
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
    	try{
    		
    	
        Scanner sc = new Scanner(new File("/home/santosh/Desktop/testData"));
        
        int testCases = sc.nextInt();
        int i=0;
        ArrayList<ArrayList<Integer>> inputArraysList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list;
        while(i++<testCases){
            
            int n = sc.nextInt();
            int k=0;
            list = new ArrayList<Integer>();
            while(k<n){
                list.add(sc.nextInt());
                k++;
            }
            inputArraysList.add(list);
            
            
        }
        
        //System.out.println(inputArraysList.size());
        for(ArrayList<Integer> arr: inputArraysList){
            countPairs(arr.toArray(new Integer[arr.size()]));
        }
        
        
    	}
    	catch(Exception e){
    		
    	}
        
    }
}