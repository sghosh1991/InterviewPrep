package TwoSigma;

import java.util.ArrayList;

public class PowerSet {
	
	
	public ArrayList<ArrayList<String>> append(String n, ArrayList<ArrayList<String>> list){
		
		//System.out.println("appending " + n + " to ");
		//printlist(list);
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
		
		res.addAll(list);
		///System.out.println("Printing res size: " + res.size());
		//(res);
		
		for(ArrayList<String> subset : list){
			
			ArrayList<String> s = new ArrayList<String>();
			s.addAll(subset);
			s.add(n);
			temp.add(s);
		}
		
		//System.out.println("After appending size of temp " + temp.size());
		//printlist(temp);
		
		
		
		//System.out.println("After appending res: ");
		res.addAll(temp);
		//printlist(res);
		
		

		return res;
		
	}
	
	
	
	
	
	
	private ArrayList<ArrayList<String>> subset(String [] arr, int processedIdx){
		
		
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		if(processedIdx == arr.length){			
			//temp.add("");
			ArrayList<String> temp = new ArrayList<String>();
			res.add(temp);	
			return res;
		}
		
		else{			
			ArrayList<ArrayList<String>> partialResult = new ArrayList<ArrayList<String>>();
			partialResult = subset(arr,processedIdx+1);
			res = append(arr[processedIdx], partialResult);
		
		}
		
		return res;
	
	}
	
	
	
public void subset(String [] arr){
		
		ArrayList<ArrayList<String>> subsets = new ArrayList<ArrayList<String>>();
		
		subsets = subset(arr,0);
		
		for(ArrayList<String> subset : subsets){
			
			System.out.println("Subset:");
			
			for(String x: subset){
				System.out.print(x + ",");
			}
			
			System.out.println();
			
		}
		
	}
	
public void printlist(ArrayList<ArrayList<String>> res){
	
	for(ArrayList<String> subset : res){
		
		System.out.println("Sublist:");
		
		for(String x: subset){
			System.out.print(":" +x + ":");
		}
		
		System.out.println();
		
	}
	
}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] arr = {"1","2","3"};
		
		PowerSet p = new PowerSet();
		p.subset(arr);

	}

}
