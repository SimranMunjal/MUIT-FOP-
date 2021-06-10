package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SpiralTraversal {
	
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
		boolean ltr = false;
		for(int i=1;i<=levels;i++) {
			printSpiral(root,1,i,ltr);
			ltr = !ltr;
		}
	}
	
	public static void printSpiral(BinaryTreeNode root, int curr, int exp, boolean ltr) {
		
		if(root==null)
			return;
		
		if(curr==exp) {
			System.out.print(root.data +"  ");
		}
		else {
			if(ltr) {
				printSpiral(root.left, curr+1, exp, ltr);
				printSpiral(root.right, curr+1, exp, ltr);
			}
			else {
				printSpiral(root.right, curr+1, exp, ltr);
				printSpiral(root.left, curr+1, exp, ltr);
			}
			
		}
	}
	
	public static void spiralIterative(BinaryTreeNode root) {
		
		if(root==null)
			return;
		
		Stack<BinaryTreeNode> curr = new Stack();
		Stack<BinaryTreeNode> next = new Stack();
		curr.push(root);
		boolean ltr = false;
		
		while(!curr.isEmpty()) {
			BinaryTreeNode node = curr.pop();
			System.out.print(node.data+"  ");
			
			if(ltr) {
				if(node.left!=null)
					next.push(node.left);
				if(node.right!=null)
					next.push(node.right);
			}
			else {
				if(node.right!=null)
					next.push(node.right);
				if(node.left!=null)
					next.push(node.left);
			}
			
			if(curr.isEmpty()) {
				ltr = !ltr;
				Stack<BinaryTreeNode> temp = curr;
				curr = next;
				next = temp;
			}
		}
	}
	
	public static BinaryTreeNode takeInputLevelWise() {
		
		Queue<BinaryTreeNode> q = new LinkedList();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root's data: ");
		int data = s.nextInt();
		if(data==-1) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode(data);
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTreeNode curr = q.remove();
			
			System.out.println("Enter left child of "+ curr.data+": ");
			int left = s.nextInt();
			if(left!=-1) {
				curr.left = new BinaryTreeNode(left);
				q.add(curr.left);
			}
			System.out.println("Enter right child of "+ curr.data+": ");
			int right = s.nextInt();
			if(right!=-1) {
				curr.right = new BinaryTreeNode(right);
				q.add(curr.right);
			}
		}
		return root;
	}
	
	public static int diameter(BinaryTreeNode root) {
		
		if(root==null)
			return 0;
		
		int option1 = height(root.left) + height(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		
		int ans = Math.max(option1, Math.max(option2, option3));
		return ans;
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode root = takeInputLevelWise();
		//levelOrder(root);
		//System.out.println();
		//spiralIterative(root);
		int ans = diameter(root);
		System.out.println(ans);
	}

}
