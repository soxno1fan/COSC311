public class BST {

	private class Node {
		
		Node left, right;
		int data;
		
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	
	public BST() {
		root = null;
	}
	
	public void insert(int data) {
		Node newNode = new Node(data);
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		boolean wentLeft = false;
		Node rover = root, parent = root;
		
		while (rover != null) {
			parent = rover;
			if (rover.data >= newNode.data) {
				rover = rover.right;
				wentLeft = false;
			}
			else {
				rover = rover.left;
				wentLeft = true;
			}
		}
		if (wentLeft)
			parent.left = newNode;
		else
			parent.right = newNode;
	}
	
	public Node find(int data) {
		Node temp = root;
		
		return temp;
	}
}
