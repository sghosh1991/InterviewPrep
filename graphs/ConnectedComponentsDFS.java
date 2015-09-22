package graphs;

public class ConnectedComponentsDFS{
	
	private boolean[] marked;
	
	//id of the connected component. 
	//vertices which have the same conceted component id are in same component
	private int[] id;
	
	private int count; //count of connected components of the graph
	
	
	
	
	public ConnectedComponentsDFS(UGGraphMatrix G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for (int s = 0; s < G.V(); s++)
		if (!marked[s])
		{
			dfs(G, s);
			count++;
		}
	}
	
	private void dfs(UGGraphMatrix G, int v){
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)){
			if (!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	public boolean connected(int v, int w){ return id[v] == id[w]; }
	
	public int id(int v){ return id[v]; }
	public int count(){ return count; }
}