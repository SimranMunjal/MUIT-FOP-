package trees;

public class TreeUse {
	
public static void main(String[] args) {
		
		TreeNode root = new TreeNode(0);
		
		TreeNode child1 = new TreeNode(1);
		root.children.add(child1);
		
		TreeNode child2 = new TreeNode(2);
		root.children.add(child2);
		
		TreeNode child3 = new TreeNode(3);
		root.children.add(child3);
		
		TreeNode child4 = new TreeNode(4);
		child1.children.add(child4);
		
		TreeNode child5 = new TreeNode(5);
		child1.children.add(child5);
		
		System.out.println("    " + root.data);
		
		for(int i=0;i<root.children.size();i++) {
			System.out.print(" " + root.children.get(i).data+" ");
		}
		System.out.println();
		for(int i=0;i<child1.children.size();i++) {
			System.out.print(child1.children.get(i).data+" ");
		}	
	}
}
