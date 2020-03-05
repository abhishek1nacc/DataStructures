
public class BinarySearchTree {
	
	static class Node {
		Node left;
		Node right;
	    int data;
	    public Node(int x) {
	    	this.data = x;
		}
	}
	Node root;
	
	void insert(int key) {
		Node node = new Node(key);
		root = insertRec(node, root);
	}
	
	Node insertRec(Node node, Node root) {
		if(root == null) {
			return node;
		}
		if(node.data < root.data) {
			root.left = insertRec(node, root.left);
		}else {
			root.right = insertRec(node, root.right);
		}
		return root;
	}
	
	void delete(int key) {
		root = deleteRec(key, root);
	}
	
	private Node deleteRec(int key, Node root) {
		if(root == null) {
			return null;
		}
		
		if(key < root.data) {
			root.left = deleteRec(key, root.left);
		} else if(key > root.data) {
			root.right = deleteRec(key, root.right);
		} else {
			//If no child and 1 child case...
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			// 2 child scenario. find minValue in right subtree and replace root with it.
			int minVal = minValue(root.right);
			root.data = minVal;
			root.right = deleteRec(minVal, root.right);
		}
		return root;
	}

	private int minValue(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node.data;
	}

	void inorderTraversal(Node node) {
		if(node != null) {
			inorderTraversal(node.left);
			System.out.print(node.data+" ");
			inorderTraversal(node.right); 
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(50);
		bst.insert(43);
		bst.insert(90);
		bst.insert(67);
		bst.insert(97);
		bst.insert(0);
		bst.insert(4);
		bst.insert(7);
		bst.insert(35);
		bst.inorderTraversal(bst.root);
		bst.delete(4);
		System.out.println();
		bst.inorderTraversal(bst.root);
		bst.delete(50);
		System.out.println();
		bst.inorderTraversal(bst.root);
		bst.delete(90);
		System.out.println();
		bst.inorderTraversal(bst.root);
		bst.delete(0);
		System.out.println();
		bst.inorderTraversal(bst.root);
	}
}
