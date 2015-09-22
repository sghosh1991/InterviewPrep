package graphs;
import java.io.*;
import java.util.*;

public class UGGraphClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc  = null;
		
		try{
		
			sc = new Scanner(new BufferedReader(new FileReader("/home/santosh/workspace/Interview/src/graphs/testGraphSmall")));
			
//			UndirectedGraph G = new UndirectedGraph(sc);
			UGGraphMatrix G = new UGGraphMatrix(sc);
//			
//			System.out.println("UG Graph created");
//			
//			BreadthFirstPaths p = new BreadthFirstPaths(G,0);
//			
//			System.out.println("Paths created");
//			
//			int destVertex = 3;
//			Iterable<Integer> paths = p.pathTo(destVertex);
//			
//			for(int v: paths){
//				
//				if(v == destVertex){
//					
//					System.out.print(v);
//				}
//				else{
//					System.out.print("->" + v);
//				}
//				
//			}
//			
//			//Cycle c = new Cycle(G);
//			
//			//System.out.println("Number of cycles :" + c.numberOfCycles());
//			
			
			ConnectedComponentsDFS cc = new ConnectedComponentsDFS(G);
			
			System.out.println(cc.count());
			
		}
		
		catch(IOException e){
			
			System.out.println("BAD FILE");
			
		}
		
		finally{
			
			sc.close();
		}

		

	}

}
