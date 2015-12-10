package graphs;

import java.io.FileInputStream;
import java.util.*;

public class UGGraphMatrix {

	private final int V; // number of vertices
	private int E; // number of edges
	//private LinkedList<Integer>[] adj; // adjacency lists. array of linkedlist
	
	private boolean[][] adj; 
	
	
	public UGGraphMatrix(int V){
		
		this.V = V; this.E = 0;
		adj = new boolean[V][V];
//		for (int v = 0; v < V; v++)
//			adj[v] = new LinkedList<Integer>();
	}
	
	
	public UGGraphMatrix(Scanner sc){
		
		
		this(sc.nextInt()); // call the constructor for making empty graph with v vertices
		int E = sc.nextInt();
		for (int i = 0; i < E; i++){ // Add an edge.
			int v = sc.nextInt();
			int w = sc.nextInt();
			addEdge(v, w);
		}
	}
	
	
	public void addEdge(int v, int w){
		
		adj[v][w] = true;
		adj[w][v] = true;
		E++;
	}
		
	public int[] adj(int v){
		
		//Return all the adjacent vertices of the vertex v
		
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		
		for(int i=0;i<V;i++){
			if((adj[v][i]== true) && i!= v){
				neighbours.add(i);
			}
		}
		
		int[] arr = new int[neighbours.size()];
		for(int i = 0;i<arr.length;i++) arr[i] = neighbours.get(i);
		
		return arr;
				
	}
	
	
	//String representation of the graph
	public String toString(){
		String s = V + " vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++){
			s += v + ": ";
			for (int w : this.adj(v))
			s += w + " ";
			s += "\n";
		}
		return s;
	}
	
	//Methods to query graph properties
	

	public int V(){ return V; } // get the number of verices in the graph
	public int E(){ return E; } //get the number of edges in the graph
	
	public static int degree(UGGraphMatrix G, int v){
		//Return degree of vertex v
		int degree = 0;
		for (int w : G.adj(v)) degree++;
		return degree;
	}
	
	
}
