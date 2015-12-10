package graphs;
import java.util.*;

public class BreadthFirstPaths{
	
	private boolean[] marked; // Is a shortest path to this vertex known?
	private int[] edgeTo; // last vertex on known path to this vertex
	private final int s; // source
	
	public BreadthFirstPaths(UGGraphMatrix G, int s){
		
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}
	
	private void bfs(UGGraphMatrix G, int s){
		
		Queue<Integer> queue = new LinkedList<Integer>();
		marked[s] = true;
		// Mark the source and put it on the queue.
		queue.offer(s);
		while (!queue.isEmpty()){
			
			int v = queue.remove(); // Remove next vertex from the queue.
			for (int w : G.adj(v)){
				
				// For every unmarked adjacent vertex,
				if (!marked[w]){
					
					edgeTo[w] = v; //save last edge on a shortest path,	
					marked[w] = true; //mark it because path is known,
					queue.offer(w); //and add it to the queue.
				}
				
			}
		}
	
	}

	
	
	public boolean hasPathTo(int v) { return marked[v]; }

	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		
		System.out.println(path);
		return path;
	}
}
