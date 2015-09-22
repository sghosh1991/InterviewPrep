package graphs;
import java.util.*;

public class Cycle{
	
	private boolean[] marked;
	private int[] edgeTo; // last vertex on known path to this vertex
	private boolean hasCycle;
	private ArrayList<ArrayList<Integer>> cycles = new ArrayList<ArrayList<Integer>>();
	
	public Cycle(UndirectedGraph G){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for (int s = 0; s < G.V(); s++)
		if (!marked[s])
		dfs(G, s, s);
	}
	
	private void dfs(UndirectedGraph G, int v, int u){
		
		//we need the parent also to check for the condition
		//that the child is again visiting its parent, in which case a cycle is not present
		//only if the child visits a non-parent node that is marked then it is a cycle
		
		//v -> node whose child i am exploring
		//u -> parent of v
		System.out.println("Visting vertex: " + v);
		marked[v] = true;
		for (int w : G.adj(v)){
			
			if (!marked[w]){
				edgeTo[w]=v;
				dfs(G, w, v);
			}
			else if (w != u) {
				
				hasCycle = true; //marked and child is not same as parent
				System.out.println("Cycle detected");
				//saveCycle(w,v); //w -> the vertex that caused the cycle to close. 
								// loop from v to u using the edgeTo array
			}
			
		}
		
		System.out.println("Completed vertex: " + v);
	
	}
	
	
	public void saveCycle(int endVertex, int startVertex){
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(endVertex);
		for (int x = startVertex; x != endVertex; x = edgeTo[x]){
			//System.out.println("Adding " + x + " to cycle ");
			path.add(x);
		}
		path.add(endVertex);
		
		System.out.println(path);
		
		cycles.add(path);
	}
	
	
	
	public boolean hasCycle(){ return hasCycle; }
	
	public int numberOfCycles(){ return cycles.size(); }
	
	public void printCycle(){
		
		for(ArrayList<Integer> cycle: cycles){
			
			for(int v: cycle){
				
				System.out.println(v + "-");
			}
			
		}
		
		
	}
}