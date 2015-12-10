package standardSorts;

import java.util.Stack;

import standardSorts.BinarySearchTree;

public class BSTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {20,15,6,18,16,19,25,26,24};
		
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer,Integer>();
		
		for(Integer i: arr){
			
			//System.out.println("Inserting " + i);
			bst.put(i, i);
		}
		
		//bst.showTable();
		//System.out.println("Get Value with key 9 :" + bst.get(new Integer(9)));
		//System.out.println("\nMinimum value of a key in the symbol table: " + bst.min());
		//System.out.println("Maximum value of a key in the symbol table: " + bst.max());
		//System.out.println("Rank of a key in the symbol table: " + bst.rank(45));
		//System.out.println("Node with rank x is select(x) :" + bst.select(5));
		//bst.delete(15);
		//bst.showTable();
		//Stack<Integer> stack=bst.range(14,26);
		/*Stack<Integer> stack = bst.notInRange(1, 20);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}*/
		System.out.println("\n");
		//bst.BFS();
		
		//bst.topView();
		//bst.BFS();
		//int sum =41;
		//System.out.println("Path with sum " + sum + " exists ? " + bst.pathSum(sum));	
		
		//bst.printLevelOrder();
		
		Stack<Integer> s = bst.notInRange(17, 23);
		
		while(!s.isEmpty()){
			
			System.out.print(s.pop() + " ");
		}
		
		
		

	}

}
