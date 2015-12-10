package MyUtils;

public class TreeNode{
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val,TreeNode left,TreeNode right){
		
		this.val = val;
		this.left = left;
		this.right = right;
		
	}
	
	public void inorder(TreeNode x){
		
		if(x==null) return;
		
		inorder(x.left);
		System.out.println(" " + x.val);
		inorder(x.right);

	}
	
}