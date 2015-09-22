package standardSorts;

import java.util.Collections;
import java.util.Stack;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;




public class BinarySearchTree<Key extends Comparable<Key>, Value>{

	
	private Node root;
	
	private class Node{
		
		private Key key;
		private Value value;
		private Node left,right;
		private int N; //the number of nodes rooted at the subtree with this node as root
		
		Node(Key k,Value val, int N){
			
			this.key=k;
			this.value=val;
			this.N=N;
			
		}
		
	}
	
	public int size(){
		
		//exposed to the api
		
		
		return size(root);
		
	}
	private int size(Node n){
		// Returns the size of the subtree rooted at node n
		
		if(n == null) return 0;
		return n.N; 
	}
	
	
	public Value get(Key k){
		
		return get(root,k);
		
	}
	
	private Value get(Node x, Key k){
		
		int cmp;
		if (x == null) return null; // if the key is not present we get a null root.
		cmp = k.compareTo(x.key);
		if(cmp < 0) return get(x.left,k);
		else if(cmp > 0) return get(x.right,k);
		else
			return x.value;
		
	}
	
	public void put(Key k,Value v){
		root = put(root,k,v);
	}
	private Node put(Node x, Key k, Value v){
		
		int cmp;
		if(x ==  null) return new Node(k,v,1); //if null then the node is absent. Then create new node with size 1.
		cmp = k.compareTo(x.key);
		if(cmp < 0) x.left=put(x.left,k,v);
		else if(cmp > 0) x.right=put(x.right,k,v);
		else
			x.value = v;
		x.N=size(x.left) + 1 + size(x.right);
		return x;
		
	}
	
	
	public void showTable(){
		
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node n){
		
		if(n == null) return;
		inorderTraversal(n.left);
		System.out.print(n.value + " ");
		inorderTraversal(n.right);
		return;
		
	}
	
	
	
	public Key min(){
		
		return min(root).key;
	}
	
	private Node min(Node x){
		
		if (x.left == null) return x;
		else return min(x.left);
		
	}
	
	public Key max(){
		
		return max(root).key;
	}
	
	private Node max(Node x){
		
		if(x.right == null) return x;
		else return max(x.right);
	}
	
	
	
	public int rank(Key k){
		//returns the number of elements less than the given key k
		return rank(root,k);
		
	}
	
	private int rank(Node x, Key k){
		
		int cmp;
		if(x == null) return 0;
		cmp = k.compareTo(x.key);
		if(cmp < 0) return rank(x.left,k);
		else if(cmp > 0) return rank(x.right,k)+size(x.left)+1;
		else return size(x.left);
		
	}
	
	
	public Key select(int rank){
		//returns the key with rank k, null if no such key is present
		//can throw null pointer exception if there is no such key
		return select(root,rank).key;
		
	}
	
	private Node select(Node x, int rank){
		
		int t=size(x.left);
		if(x == null) return null;
		if(t > rank) return select(x.left,rank);
		else if(t < rank) return select(x.right,rank-t-1); // on going right i have already seen t+1 nodes that are less than Key k
		else return x;
		
	}
	
	
	public void delete(Key key){
		
		root=delete(root,key);
		
	}
	
	private Node delete(Node x,Key key){
		
		//initially find the node with key x starting from root
		int cmp;
		cmp=key.compareTo(x.key);
		if(cmp < 0) x.left = delete(x.left,key);
		else if (cmp > 0) x.right = delete(x.right,key);
		else{
			
			if(x.left == null) return x.right; // left chile absent. return right chile to parent. right child msy be null also
			if(x.right == null) return x.left;
			
			//if both right and left chiled of the node to be deleted are present;
			
			//1. Save the node to be deleted in t.
			Node t = x;
			
			//2. Find the inorder successor of x;
			
			x = min(x.right);
			
			//3.//This operation fixes up the right subtree of x by deleting the min node(in order successor) and returning thr root of the fixed up tree
			//Replace t's right and left link by x
			x.right=deleteMin(t.right);
			x.left = t.left;
			
			
		}
		
		x.N = size(x.left) + size(x.right) + 1;
		return x;
		
		
	}
	
	private Node deleteMin(Node x){
		
		if(x == null) return x;
		if(x.left == null) return x.right;
		else x.left=deleteMin(x.left);
		x.N = size(x.left)+size(x.right)+1;
		return x;
		
		
	}
	
	
	public Stack range(Key lo, Key hi){
		
		Stack<Key> stack = new Stack<Key>();
		range(root,lo,hi,stack);
		return stack;
		
		
	}
	
	
	private void range(Node x,Key lo,Key hi,Stack stack){
		
		if(x == null) return;
		int cmplo,cmphi;
		
		cmplo=lo.compareTo(x.key);
		cmphi=hi.compareTo(x.key);
		
		System.out.println("In " + x.key + " cmpLo =" + cmplo + " cmpHi = " + cmphi);
		if(cmplo < 0) range(x.left,lo,hi,stack);
		if(cmplo <=0 && cmphi >=0){
			stack.push(x.key);
		}
		
		if(cmplo >0 || cmphi <0){
			System.out.println("In stack");
			stack.push(x.key);
		}
		if(cmphi > 0) range(x.right,lo,hi,stack);
	}

	
	public Stack notInRange(Key lo, Key hi){
		
		Stack<Key> stack = new Stack<Key>();
		notInRange(root,lo,hi,stack);
		return stack;
		
	}
	
	private void notInRange(Node x,Key lo,Key hi,Stack stack){
		
		if(x == null) return;
		int cmplo,cmphi;
		
		cmplo=lo.compareTo(x.key);
		cmphi=hi.compareTo(x.key);
		
		System.out.println("In " + x.key + " cmpLo =" + cmplo + " cmpHi = " + cmphi);
		//if(cmplo < 0) range(x.left,lo,hi,stack);
		/*if(cmplo <=0 && cmphi >=0){
			stack.push(x.key);
		}*/
		
		notInRange(x.left, lo, hi, stack);
		if(cmplo >0 || cmphi <0){
			System.out.println("In stack");
			stack.push(x.key);
		}
		//if(cmphi > 0) range(x.right,lo,hi,stack);
		
		notInRange(x.right, lo, hi, stack);
	} 
	
	public void topView(){
		
		HashMap<Integer,Node> map = new HashMap<Integer,Node>();
		topView(root,map,0);
		
	}
	
	private void topView(Node x,HashMap map,int horizontalDistFromRoot){
		
		if(x ==  null) return;
		
		if(!map.containsKey(horizontalDistFromRoot))
			map.put(horizontalDistFromRoot, x);
		
		if(x.left!=null){
			if(!map.containsKey(horizontalDistFromRoot-1))
				map.put(horizontalDistFromRoot, x.left);
		}
		
		if(x.right!=null){
			if(!map.containsKey(horizontalDistFromRoot))
				map.put(horizontalDistFromRoot+1, x.right);
		}
		
		
		topView(x.left,map,horizontalDistFromRoot-1);
		topView(x.right,map,horizontalDistFromRoot+1);
		
		if((x.equals(map.get(horizontalDistFromRoot)))){
			System.out.print(x.key + " ");
		}
		
	}
	
	public void BFS(){
		
		BFS(root);
	}
	
	private void BFS(Node x){
		
		Queue<Node> bfsQueue = new LinkedList<Node>();
		
		bfsQueue.add(x);
		
		while(!bfsQueue.isEmpty()){
			
			Node n = bfsQueue.remove();
			System.out.print(n.key +" ");
			if(n.left!=null)
				bfsQueue.add(n.left);
			if(n.right!=null)
				bfsQueue.add(n.right);
			
		}
		
	}
	
	
	public void printLevelOrder(){
		
		HashMap<Integer,ArrayList<Node>> map = new HashMap<Integer,ArrayList<Node>>();
		printLevelOrder(root,0,map);
		
		System.out.println("Max Level is : " + Collections.max(map.keySet()));
		
		for(Integer Level: map.keySet()){
			
			ArrayList<Node> arr;
			arr = map.get(Level);
			for(Node y : arr){
				System.out.print(y.key + " ");
			}
			System.out.println();
			
		}
		
	}
	
	private void printLevelOrder(Node x,int level,HashMap<Integer,ArrayList<Node>> map){
		
		if(x==null) return;
		
		if(map.containsKey(level)){
			
			ArrayList<Node> val = new ArrayList<Node>();
			val = map.get(level);
			val.add(x);
			map.put(level, val);
			
		}
		else{
			
			ArrayList<Node> val = new ArrayList<Node>();
			val.add(x);
			map.put(level, val );
		}
		
		printLevelOrder(x.left, level+1, map);
		printLevelOrder(x.right, level+1, map);
		
	}
	
	
	public boolean pathSum(int sum){
		
		return pathSum(root,sum);
	}
	
	private boolean pathSum(Node x, int sum){
		
		if(x == null) return false;
		System.out.println("At node " + x.key + ". sum =  " + sum);
		sum = sum - (Integer)x.key;
		if((x.left==null && x.right==null)&& sum==0)
			return true;
		else{
			
			if(pathSum(x.left,sum))return true;
			else if(pathSum(x.right,sum)) return true;
			else
				return false;
			
		}
		
	}
	
	/*public static void main(String[] args) {
		
		String s = "S";
		String s1 = s.substring(1, 0);
		System.out.println("sub string is : " + s1);

	}*/

}
