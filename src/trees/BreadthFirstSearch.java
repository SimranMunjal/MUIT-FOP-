package trees;

import java.util.Scanner;

public class BreadthFirstSearch {
	
	public static BinaryTreeNode takeInput() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter node's data: ");
		int data = s.nextInt();
		if(data==-1)
			return null;
		
		BinaryTreeNode root = new BinaryTreeNode(data);
		root.left = takeInput();
		root.right = takeInput();
		return root;
		
	}

	public static int height(BinaryTreeNode root) {
		
		if(root==null)
			return 0;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int ans = 1 + Math.max(leftHeight, rightHeight);
		return ans;
		
	}
	
	public static void levelOrder(BinaryTreeNode root) {
		
		int levels = height(root);
		
		for(int i=1;i<=levels;i++) {
			printLevelWise(root,1,i);
		}
	}
	
	public static void printLevelWise(BinaryTreeNode root, int curr, int exp) {
		
		if(root==null)
			return;
		
		if(curr==exp) {
			System.out.print(root.data +"  ");
		}
		else {
			printLevelWise(root.left, curr+1, exp);
			printLevelWise(root.right, curr+1, exp);
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode root = takeInput();
		levelOrder(root);
	}

}
