package TwoSigma;

public class Tries {
	
	private final int R = 256;
	Node root = null;
	
	private class Node{
		
		int value = -1;
		Node [] next = new Node[R];
		int [] numberOfLeaves = new int[R];
		int totalLeaves = 0;
		char c;
		
		Node(){
			
			this.value = -1;
			for(Node x: next){
				x=null;
			}
			
		}

	}
	
	
	public void insert(String str, int val){
		
		root = insert(root,str,0,val);
	}
	
	private Node insert(Node x, String str, int indexToProcess, int val){
		
		//System.out.println("Inserting : " + str.charAt(indexToProcess) + " x = " + x);
		
		//char p = str.charAt(indexToProcess);
		
		if(x==null) { x = new Node(); }
		
		if(indexToProcess == str.length()){
			
			//System.out.println("Before inserting " + p + " value at x.next[" + p + "] : " + x.next[p]);
			//x.c = str.charAt(indexToProcess);
			x.value = val;
			//x.numberOfLeaves[str.charAt(indexToProcess-1)] = 1;
			
//			for(int i: x.numberOfLeaves){
//				x.totalLeaves += i;
//			}
			x.c = str.charAt(indexToProcess-1);
			System.out.println("in leaf num of leaf before " + x.c + " " + x.totalLeaves);
			int sum = 0;
			if(x.totalLeaves > 0){
				for(int i: x.numberOfLeaves){
					sum += i;
				}
				
				x.totalLeaves = sum + 1;
			}
			else{
				x.totalLeaves = 1;
			}
			
			System.out.println("LEAF NODE Total leaves for " + x.c + " : " + x.totalLeaves);
			
			
			//System.out.println("Char :" + x.c + " Value: " + x.value + " " + x);
			return x;			
		}
		
		char c = str.charAt(indexToProcess);
		
		//x.c = c;
		//System.out.println("Before inserting " + c + " value at node  x.next[" + c + "] : " + x.next[c]);
		x.next[c] = insert(x.next[c], str, indexToProcess+1, val);
		
		
		if(indexToProcess == 0){
			x.c = '*';
		}
		else{
			x.c = str.charAt(indexToProcess-1);
		}
		
		x.numberOfLeaves[c] = x.next[c].totalLeaves;
		
		int sum = 0;
		for(int i:x.numberOfLeaves){
			sum += i;
		}
		x.totalLeaves = sum;
		System.out.println("INTERNAL NODE Total num of leaves for " + x.c + " " + x.totalLeaves);
		
		//System.out.println("Char :" + c + " Value: " + x.value + " " + x);
		
		return x;

	}
	
	
	public int get(String str){
		
		Node x = get(root,str,0);
		return x == null? -1 : x.value; 
		
	}
	
	private Node get(Node x,String str, int indexToProcess){
		
		//System.out.println("Called get on " + str.charAt(indexToProcess) + " : " + x.c + " val : " + x.value);
		
		if(x == null) return null;
		if(indexToProcess == str.length()) return x;
		
		char c = str.charAt(indexToProcess);
		
		
		
		return get(x.next[c],str,indexToProcess+1);
		
		
	}
	
	public int size(){
		
		return size(root);
	}
	
	
	private int size(Node x){
		
		//System.out.println("Calling with : " + x.value);
		
		int s = 0;
		
		if(x.value != -1) {
			s++;
		}
		
		for(Node y: x.next){
			
			if( y != null){			
				s += size(y);			
			}		
		}
		
		return s;
		
	}
	
	
	public void dfs(){
		
		dfs(root);
	}
	
	private void dfs(Node x){
		
		//System.out.println("starting dfs with " + x.c);
		
		for(int i=0;i<256;i++){
			
			if(x.next[i] != null){
				
				dfs(x.next[i]);
			}
		}
		
		System.out.println("Number of leaves for " + x.c + " : " +  x.totalLeaves);
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tries t = new Tries();
		
		t.insert("ABCDE", 5);
		t.insert("ABC", 12);
		t.insert("XYZ", 4);
		t.insert("MEFG", 9);
		t.insert("MEFP", 7);
		int x = t.get("DEF");
		//System.out.println(x);
		//System.out.print(t.size());
		t.dfs();

	}

}
