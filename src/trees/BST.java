package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST {
	
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

	public static boolean search(BinaryTreeNode root, int key) {
		
		if(root==null)
			return false;
		
		if(root.data==key)
			return true;
		
		else if(key<root.data) {
			return search(root.left, key);
		}
		else {
			return search(root.right, key);
		}
	}
	
	public static void searchInRange(BinaryTreeNode root, int lb, int ub) {
		
		if(root==null)
			return;
		
		if(lb<=root.data && ub>=root.data) {
			searchInRange(root.left, lb, ub);
			System.out.println(root.data);
			searchInRange(root.right, lb, ub);
		}
		else if(root.data>ub) {
			searchInRange(root.left, lb, ub);
		}
		else if(root.data<lb) {
			searchInRange(root.right, lb, ub);
		}
	}
	
	public static BinaryTreeNode insert(BinaryTreeNode root, int data) {
		
		if(root==null) {
			BinaryTreeNode node = new BinaryTreeNode(data);
			return node;
		}
		
		if(data<root.data) {
			root.left = insert(root.left,data);
		}
		else {
			root.right = insert(root.right,data);
		}
		return root;
	}
	
	public static BinaryTreeNode delete(BinaryTreeNode root, int data) {
		
		if(root==null)
			return null;
		
		if(data<root.data) {
			root.left = delete(root.left,data);
			return root;
		}
		
		else if(data>root.data) {
			root.right = delete(root.right,data);
			return root;
		}
		
		else {
			if(root.left==null && root.right==null) {
				return null;
			}
			else if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			else {
				BinaryTreeNode minNode = root.right;
				while(minNode.left!=null) {
					minNode = minNode.left;
				}
				root.data = minNode.data;
				root.right = delete(root.right,minNode.data);
				return root;
			}
		}
	}
	
	public static int lca(BinaryTreeNode root, int a, int b) {
		
		if(root==null)
			return -1;
		
		if(root.data==a || root.data==b)
			return root.data;
		
		int l = lca(root.left,a,b);
		int r = lca(root.right,a,b);
		
		if(l==-1 && r==-1)
			return -1;
		
		else if(l==-1)
			return r;
		
		else if(r==-1)
			return l;
		
		else
			return root.data;
	}
	
	public static int lcaInBST(BinaryTreeNode root, int a, int b) {
		
		if(root==null)
			return -1;
		
		if(root.data==a || root.data==b)
			return root.data;
		
		if(a<root.data && b<root.data)
			return lcaInBST(root.left, a, b);
		
		else if(a>root.data && b>root.data) {
			return lcaInBST(root.right, a, b);
		}
		else {
			return root.data;
		}
	}
	
	public static BinaryTreeNode constructBST(int arr[], int s, int e) {
		
		if(s>e)
			return null;
		
		int mid = (s+e)/2;
		
		BinaryTreeNode root = new BinaryTreeNode(arr[mid]);
		root.left = constructBST(arr, s, mid-1);
		root.right = constructBST(arr, mid+1, e);
		return root;
		
	}
	
	public static void main(String[] args) {
		
//		BinaryTreeNode root = takeInputLevelWise();
//		System.out.println(search(root, 9));
//		searchInRange(root, 8, 14);
//		insert(root,5);
//		bfsIterative(root);
//		delete(root,469);
//		System.out.println();
//		bfsIterative(root);
//		System.out.println(lca(root,5,7));
//		System.out.println(lcaInBST(root, 2, 7));
		int arr[] = {1,2,3,4,5,6,7,8};
		BinaryTreeNode root = constructBST(arr, 0, arr.length-1);
		bfsIterative(root);
	}
}
