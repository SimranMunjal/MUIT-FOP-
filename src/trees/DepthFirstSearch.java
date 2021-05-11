package trees;

import java.util.Scanner;

public class DepthFirstSearch {
	
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
	
	public static void print(BinaryTreeNode root) {
		
		if(root==null)
			return;
		
		System.out.print(root.data+": ");
		if(root.left!=null) {
			System.out.print("L: "+root.left.data+" ");
		}
		else {
			System.out.print("L: null ");
		}
		if(root.right!=null) {
			System.out.println("R: "+root.right.data);
		}
		else {
			System.out.println("R: null");
		}
		print(root.left);
		print(root.right);
		
	}
	public static void preorder(BinaryTreeNode root) {
		
		if(root==null)
			return;
		
		System.out.print(root.data +"  ");
		preorder(root.left);
		preorder(root.right);
		
	}
	
	public static void inorder(BinaryTreeNode root) {
		
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(root.data +"  ");
		inorder(root.right);
		
	}
	
	public static void postorder(BinaryTreeNode root) {
		
		if(root==null)
			return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data +"  ");
		
	}
	public static void main(String[] args) {
		
//		BinaryTreeNode root = new BinaryTreeNode(1);
//		root.left = new BinaryTreeNode(2);
//		root.right = new BinaryTreeNode(3);
//		root.left.left = new BinaryTreeNode(4);
//		root.left.right = new BinaryTreeNode(5);
//		root.right.left = new BinaryTreeNode(6);
//		root.right.right = new BinaryTreeNode(7);
		BinaryTreeNode root = takeInput();
		print(root);
		//preorder(root);
		//inorder(root);
		//postorder(root);
	}

}
