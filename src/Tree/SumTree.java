package Tree;
import MyUtils.*;

public class SumTree {

	/**
	 * @param args
	 */

	
	public boolean isSumTree(TreeNode x){
		
		return sumTreeChecker(x).getX();
			
		
	}
	
	
	private Pair<Boolean,Integer> sumTreeChecker(TreeNode x){
		
		
		if(x==null) return new Pair<Boolean,Integer>(true,0);
		
		if(isLeaf(x)) return new Pair<Boolean,Integer>(true,x.val);
		
			
		Pair<Boolean,Integer> sumTreeLeft = sumTreeChecker(x.left);
		
		System.out.println("Returned from left child. Sum:  " + sumTreeLeft.getY());
		
		Pair<Boolean,Integer> sumTreeRight = sumTreeChecker(x.right);
		
		System.out.println("Returned from left child. Sum:  " + sumTreeRight.getY());
		
		int lVal=0,rVal=0;
				
		if(sumTreeLeft.getX() && sumTreeRight.getX()){
			
			lVal = sumTreeLeft.getY();
			rVal = sumTreeRight.getY();
			
			System.out.println("At level: " + x.val + " \n Result " + (x.val == lVal + rVal) + "\n Returning sum: " + (lVal + rVal + x.val));
			
			return (new Pair<Boolean,Integer>( x.val == lVal + rVal , lVal + rVal + x.val));
			
		}
		
		else{
			
			return (new Pair<Boolean,Integer>(false,-1));
			
		}
		
		
		
	}
	
	
	
	private boolean isLeaf(TreeNode x){
		
		//System.out.println(x.val);
		
		return (x.right == null && x.left==null);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TreeNode g = new TreeNode(7,null,null);
		TreeNode h = new TreeNode(-1,null,null);
		
		TreeNode d = new TreeNode(4,null,null);
		TreeNode e = new TreeNode(6,g,h);
		TreeNode f = new TreeNode(3,null,null);
		
		
		
		TreeNode b = new TreeNode(16,d,e);
		TreeNode c = new TreeNode(3,null,f);
		TreeNode a = new TreeNode(38,b,c);
		
		//a.inorder(a);
		
		
		
		SumTree s = new SumTree();
		System.out.println(s.isSumTree(a));
		
//		TreeNode g = new TreeNode(18,null,null);
//		TreeNode h = new TreeNode(14,null,null);
		
		
		

	}

}
