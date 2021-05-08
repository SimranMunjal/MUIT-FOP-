package trees;

public class BinaryTreeUse {
	
	public static int height(BinaryTreeNode root) {
		
		if(root==null)
			return 0;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int ans = 1 + Math.max(leftHeight, rightHeight);
		return ans;
		
	}
	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(0);
		root.left = new BinaryTreeNode(1);
//		BinaryTreeNode child = new BinaryTreeNode(1);
//		root.left = child;
		root.right = new BinaryTreeNode(2);
		root.left.left = new BinaryTreeNode(3);
		root.left.right = new BinaryTreeNode(4);
		root.right.left = new BinaryTreeNode(5);
		root.left.left.right = new BinaryTreeNode(6);
		System.out.println(height(root));
		
	}

}
