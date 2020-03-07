
public class AVLTree {

	class Node {
		Node left;
		Node right;
		int key;
		int height;

		Node(int x) {
			this.key = x;
			this.height = 1;
		}
	}

	Node root;

	int height(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	Node rightRotate(Node y) {
		Node x = y.left;
		Node T3 = x.right;
		x.right = y;
		y.left = T3;

		// Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// return new root
		return x;
	}

	Node leftRotate(Node y) {
		Node x = y.right;
		Node T2 = x.left;
		x.left = y;
		y.right = T2;

		// Update heights
		x.height = max(height(x.left), height(x.right));
		y.height = max(height(y.left), height(y.right));

		// return new root
		return x;
	}

	// Get balance factor of node
	int getBalance(Node node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	void insert(int key) {
		Node node = new Node(key);
		root = insertRec(root, node);
	}

	Node insertRec(Node root, Node node) {
		if (root == null) {
			root = node;
			return node;
		}
		// 1. Normal BST insertion.
		if (node.key < root.key) {
			root.left = insertRec(root.left, node);
		} else if (node.key > root.key) {
			root.right = insertRec(root.right, node);
		} else {
			return node;
		}

		// 2. Update height of root.
		root.height = 1 + max(height(root.left), height(root.right));

		// 3. Get the balance factor of the root to check if this node has became
		// unbalanced
		int balance = getBalance(root);

		// If this node become unbalanced there are 4 cases.

		// Left-Left case
		if (balance > 1 && node.key < root.left.key) {
			return rightRotate(root);
		}
		// Left-Right case
		if (balance > 1 && node.key > root.left.key) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		// Right-Right case
		if (balance < -1 && node.key > root.right.key) {
			return leftRotate(root);
		}
		// Right-Left case
		if (balance < -1 && node.key < root.right.key) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}
	
	void delete(int key) {
		root = deleteRecur(key, root);
	}

	private Node deleteRecur(int key, Node root) {
		if(root == null) {
			return null;
		}
		
		if(key < root.key) {
			root.left = deleteRecur(key, root.left);
		}else if(key > root.key) {
			root.right = deleteRecur(key, root.right);
		}else {
			//Node to be deleted is root...
			// If node to be deleted has 1 child or no child case...
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			//If node to be deleted has 2 child case..
			//find the inorderSuccessor in right subtree..
			int minValue = minVal(root.right);
			root.key = minValue;
			//Delete the minValue key in right subtree.
			root.right = deleteRecur(key, root.right);
		}
		
		//Update height of the current node
		root.height = 1 + max(height(root.left), height(root.right));
		
		//Get balance factor of this node.
		int balance = getBalance(root);
		
		//If this node get unbalanced, then there are 4 cases.
		//Left Left case
		if(balance > 1 && getBalance(root.left) >= 0) {
			return rightRotate(root);
		}
		//Left Right case
		if(balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		//Right Right case
		if(balance < -1 && getBalance(root.right) <= 0) {
			return leftRotate(root);
		}
		//Right Left case
		if(balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}

	private int minVal(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node.key;
	}

	void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
	}
	
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insert(9);
		tree.insert(89);
		tree.insert(4);
		tree.insert(30);
		tree.insert(78);
		tree.insert(65);
		tree.insert(34);
		tree.insert(90);
		tree.insert(-78);
		tree.insert(787);
		tree.inOrder(tree.root);
		tree.delete(34);
		System.out.println();
		tree.inOrder(tree.root);
		tree.delete(-78);
		System.out.println();
		tree.inOrder(tree.root);
		tree.delete(787);
		System.out.println();
		tree.inOrder(tree.root);
		tree.delete(90);
		System.out.println();
		tree.inOrder(tree.root);
		tree.delete(9);
		System.out.println();
		tree.inOrder(tree.root);
	}
}



















