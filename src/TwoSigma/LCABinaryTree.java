package TwoSigma;

import MyUtils.*;

public class LCABinaryTree {

	/**
	 * @param args
	 */
	
	
	private Pair<Integer,Boolean> getLCA(TreeNode x, TreeNode n1, TreeNode n2){
		
		int numOfNodesFound = 0;
		
		if(x == null) return new Pair<Integer,Boolean>(new Integer(numOfNodesFound), new Boolean(false));
		
		if(x.val == n1.val || x.val == n2.val){
			numOfNodesFound = 1;
		}
		
		Pair<Integer,Boolean> leftResult = getLCA(x.left, n1, n2);
		
		if(leftResult.getY() == true){
			
		}
		
		
		return null;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
