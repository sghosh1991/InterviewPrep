package VMWare;
import java.util.*;

import IntervalProblems.UniounOfIntervals;

public class weddingPlanner {

	/**
	 * @param args
	 */
	
	
	public static void sanitize(int[] amount,String[] ucost){
		
		
		
		
	}
	
	public static float Interpolate(int n, int[] amount, String[] ucost) {
		
		int i = 0;
		float unitPrice = 0;
		
		ArrayList<Integer> amnt = new ArrayList<Integer>();
		ArrayList<String> cost = new ArrayList<String>();
		
		
		
		for(int k =0;k<ucost.length;k++){
			
			if(Float.parseFloat(ucost[k])>0){
				
				amnt.add(amount[k]);
				cost.add(ucost[k]);
			}
			
		}
		
		System.out.println(amnt);
		System.out.println(cost);
		
		int[] x  = new int[amnt.size()];
		String[] y = new String[amnt.size()];
		
		for(int j=0;j<x.length;j++){
			
			x[j] = amnt.get(j);
			y[j] = cost.get(j);
			
		}
		
		amount = x;
		ucost = y;
		
		
		
		for(i=0;i < amount.length ;i++ ){
			
						
			if(amount[i] > n || amount[i] == n){
				break;
			}

		}
		
		System.out.println("i = " + i);
		
		if( i < amount.length && amount[i] == n){
			return Float.parseFloat(ucost[i]);
		}
		
		if(i==amount.length){
			
			//extrapolate
			int closestIdx1 = amount.length-1;
			int closestIdx2 = amount.length-2;
			
			float increment = Float.parseFloat(ucost[closestIdx2]) - Float.parseFloat(ucost[closestIdx1]);
			int jumpStep = Math.abs(amount[closestIdx1] - amount[closestIdx2]);
			
			System.out.println(amount[closestIdx1] + " " + amount[closestIdx2]);
			
			float r = Math.abs(n-(float)amount[closestIdx1])/jumpStep;
			
			if(increment > 0){
				
				
				unitPrice = Float.parseFloat(ucost[closestIdx1]) - (r)*Math.abs(increment);
				
			}
			else{
				
				unitPrice = Float.parseFloat(ucost[closestIdx1]) + (r)*Math.abs(increment);
			}
			
			Double d =  Math.round(unitPrice * 100.0)/ 100.0;
			
			unitPrice = d.floatValue();
			
			System.out.println(unitPrice);
			
			return unitPrice;
	
		}
		
		if(i==0){
			
			//extrapolate
			int closestIdx1 = 0;
			int closestIdx2 = 1;
			
			float increment = Float.parseFloat(ucost[closestIdx2]) - Float.parseFloat(ucost[closestIdx1]);
			int jumpStep = Math.abs(amount[closestIdx1] - amount[closestIdx2]);
			
			System.out.println(amount[closestIdx1] + " " + amount[closestIdx2]);
			
			System.out.println(jumpStep);
			
			float r = Math.abs(n-(float)amount[closestIdx1])/jumpStep;
			
			System.out.println("ccccc " + r);
			
			if(increment > 0){
				
				
				unitPrice = Float.parseFloat(ucost[closestIdx1]) + (r)*Math.abs(increment);
				//System.out.print(Math.round(unitPrice * 100.0) / 100.0);
			}
			else{
				
				unitPrice = Float.parseFloat(ucost[closestIdx1]) + (r)*Math.abs(increment);
			}
			
			Double xd =  Math.round(unitPrice * 100.0)/ 100.0;
			
			unitPrice = xd.floatValue();
			
			System.out.println(unitPrice);
			
			return unitPrice;
	
		}
		
		//else interpolate
		
		int closestIdx1 = i-1;
		int closestIdx2 = i;
		float increment = Float.parseFloat(ucost[closestIdx2]) - Float.parseFloat(ucost[closestIdx1]);
		int jumpStep = Math.abs(amount[closestIdx1] - amount[closestIdx2]);
		
		System.out.println(amount[closestIdx1] + " " + amount[closestIdx2]);
		float r = Math.abs(n-(float)amount[closestIdx1])/jumpStep;
		
		if(increment > 0){
			
			
			unitPrice = Float.parseFloat(ucost[closestIdx1]) + (r)*Math.abs(increment);
			System.out.print(Math.round(unitPrice * 100.0) / 100.0);
		}
		else{
			
			unitPrice = Float.parseFloat(ucost[closestIdx1]) - (r)*Math.abs(increment);
		}
		
		
		
		Double d =  Math.round(unitPrice * 100.0)/ 100.0;
		
		unitPrice = d.floatValue();
		
		System.out.println(unitPrice);
		
		return unitPrice;
    }

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int amount[] = {10,25,50,100,500};
		
		String []ucost = {"27.32","0","-9","18.00","15.50"};
		
		
		Interpolate(300,amount,ucost);
		
	}

}
