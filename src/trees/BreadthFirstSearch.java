package trees;

import java.util.LinkedList;
import java.util.Queue;
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
	
	public static void bfsIterative(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> q = new LinkedList();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			BinaryTreeNode curr = q.remove();
			
			if(curr==null) {
				System.out.println();
				if(!q.isEmpty()) {
					q.add(null);
				}
			}
			else {
				System.out.print(curr.data+"  ");
				
				if(curr.left!=null) {
					q.add(curr.left);
				}
				
				if(curr.right!=null) {
					q.add(curr.right);
				}
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
	
	public static void mirror(BinaryTreeNode root) {
		
		if(root==null)
			return;
		
		mirror(root.left);
		mirror(root.right);
		BinaryTreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return;
	}
	
	public static void main(String[] args) {
		
		//BinaryTreeNode root = takeInput();
		//levelOrder(root);
		BinaryTreeNode root = takeInputLevelWise();
		bfsIterative(root);
		mirror(root);
		bfsIterative(root);
	}

}
