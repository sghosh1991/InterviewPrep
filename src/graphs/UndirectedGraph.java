package graphs;

import java.io.FileInputStream;
import java.util.*;

public class UndirectedGraph {

	private final int V; // number of vertices
	private int E; // number of edges
	private LinkedList<Integer>[] adj; // adjacency lists. array of linkedlist
	
	
	public UndirectedGraph(int V){
		
		this.V = V; this.E = 0;
		adj = (LinkedList<Integer>[])new LinkedList[V];
		for (int v = 0; v < V; v++)
			adj[v] = new LinkedList<Integer>();
	}
	
	
	public UndirectedGraph(Scanner sc){
		
		
		this(sc.nextInt()); // call the constructor for making empty graph with v vertices
		int E = sc.nextInt();
		for (int i = 0; i < E; i++){ // Add an edge.
			int v = sc.nextInt();
			int w = sc.nextInt();
			addEdge(v, w);
		}
	}
	
	
	public void addEdge(int v, int w){
		
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
		
	public Iterable<Integer> adj(int v){
		
		//Return all the adjacent vertices of the vertex v
		
		return adj[v];
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
	
	public static int degree(UndirectedGraph G, int v){
		//Return degree of vertex v
		int degree = 0;
		for (int w : G.adj[v]) degree++;
		return degree;
	}
	
	
}
