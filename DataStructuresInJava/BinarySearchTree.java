
public class BinarySearchTree {
	Node root;
	public BinarySearchTree() {
		this.root = null;
	}
	
	private class Node{
		Node left;
		Node right;
		int data;
		public Node(int data){
			this.data = data;
			this.right = null;
			this.left = null;
			
		}
	}
	
	public Node addRecursive(Node root, int data) {
		
		Node newNode = new Node(data);
		
		if(root == null ) root = newNode;
		if(data < root.data)  root.left = addRecursive(root.left, data);
		else  root.right = addRecursive(root.right, data);
		this.root = root;
		return this.root;
		
		
	}
	public Node addIterative(Node root, int data) {

		 Node newNode = new Node(data);
		    Node temp = root;
			Node node = null;
			while(temp != null) {
				node = temp;
				if(data < temp.data) temp = temp.left;
				else  temp = temp.right;
			}
			
			if(node == null) 
			temp = newNode;
			else if (data < node.data) node.left = newNode;
			else if (data > node.data) node.right = newNode;
		
		return temp ;
		
	}
	public int getMin(Node node) {
		int value = Integer.MIN_VALUE;
		Node temp = node;
		if(node == null) return value;
		else if(node.left == null) {
			return node.data;
		}
		else {
		while(temp != null) {
			value = temp.data;
			temp = temp.left;
			
		}
		}
		return value;
	}
	public int getMax(Node node) {
		int value = Integer.MAX_VALUE;
		Node temp = node;
		if(node == null) return value;
		else if(node.right == null) {
			return node.data;
		}
		else {
		while(temp != null) {
			value = temp.data;
			temp = temp.right;
			
		}
		}
		return value;
	}
	public int removeRoot(Node root) {
	    Node temp = root;
		if(root == null) return -1;
	    
		int value = root.data;
		
		if(root.left == null) 
			this.root = (root.right != null) ? root.right : null;
			
		if(root.right == null) 
			this.root = (root.left != null) ? root.left : null;
	
		if(root.left == null && root.right == null)  root = null;
			
		else if(root.left != null) {
			if(root.left.right != null) {
				temp = temp.left;
				temp.right.right = root.right;
				
			}
			else {
				temp = temp.left;
				temp.right = root.right;
			}
			this.root = temp;
		}
	
		return value;
	}
	
	public void print(Node node) {
		if(node == null) return;
		
		else {
		
		System.out.println("("+ node.data +")");
		
	    print(node.left);
	   
		print(node.right);
		
		}
	}



	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.addIterative(tree.root, 8);
		tree.addIterative(tree.root, 6);
		tree.addIterative(tree.root, 5);
		tree.addIterative(tree.root, 7);
		tree.addIterative(tree.root, 10);
		tree.addIterative(tree.root, 9);
		tree.addIterative(tree.root, 11);
		System.out.println("Min "+tree.getMin(tree.root));
		System.out.println("Max  "+tree.getMax(tree.root));
	
		tree.print(tree.root);
	//	tree.print(tree.root);
	//	tree.removeRoot(tree.root);
	//	tree.print(tree.root);
	//	
	    
	   
	  
	  

	}

}
