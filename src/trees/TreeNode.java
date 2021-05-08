package trees;

import java.util.ArrayList;

public class TreeNode {
	
	int data;
	ArrayList<TreeNode> children;
	
	TreeNode(int data){
		this.data = data;
		children = new ArrayList();
	}

}
