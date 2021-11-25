
public class AVLTree<T> {
	
	private AVLNode<T> root;
	private int size;
	private boolean added;
	private boolean removed;
	private boolean found;
	
	public AVLTree() {
		root = null;
		size = 0;
	}
	
	public boolean add(T data) {
		if(data == null) {
			throw new NullPointerException();
		}

		root = addRec(data, root);
		return added;
	}
	
	private AVLNode addRec(T data, AVLNode curr) {
		if(curr == null) {
			added = true;
			size++;
			return new AVLNode(data);
		}
		
		if(data.compareTo(curr.data) == 0) {
			added = false;
			return curr;
		}
		
		if(data.compareTo(curr.data) > 0) {
			curr.right = addRec(data, curr.right);
		}
		
		else {
			curr.left = addRec(data, curr.left);
		}
		
		
		int balanceFactor = curr.right.height - curr.left.height;
		if(balanceFactor < -1) {
			AVLNode left = curr.left;
			int leftBf = left.right.height - left.left.height;
			if(leftBf <= 0) {
				curr = LLRotation(curr);
			}
			else {
				curr = LRRotation(curr);
			}
			
		}
		
		if(balanceFactor > 1) {
			AVLNode right = curr.right;
			int rightBf = right.right.height = right.left.height;
			if(rightBf >= 0) {
				curr = RRRotation(curr);
			}
			else {
				curr = RLRotation(curr);
			}
		}
		
		return curr;
	}
	
	private AVLNode LLRotation(AVLNode curr) {
		AVLNode newRoot = curr.left;
		curr.left = newRoot.right;
		newRoot.right = curr;
		
		updateHeight(curr);
		updateHeight(newRoot);
		
		
		return newRoot;
	}

	private AVLNode LRRotation(AVLNode curr) {
		AVLNode B = curr.left;
		AVLNode newRoot = B.right;
		
		B.right = newRoot.left;
		curr.left = newRoot.right;
		newRoot.left = B;
		newRoot.right = curr;
		
		updateHeight(curr);
		updateHeight(B);
		updateHeight(newRoot);
		
		return newRoot;
	}
	
	private AVLNode RRRotation(AVLNode curr) {
		AVLNode newRoot = curr.right;
		newRoot.right = curr.left;
		curr.left = newRoot;
		
		updateHeight(curr);
		updateHeight(newRoot);
		
		return newRoot;
	}
	
	private AVLNode RLRotation(AVLNode curr) {
		AVLNode B = curr.right;
		AVLNode newRoot = B.left;
		curr.right = newRoot.left;
		B.left = newRoot.right;
		newRoot.left = curr;
		newRoot.right = B;
		
		updateHeight(curr);
		updateHeight(B);
		updateHeight(newRoot);
		
		return newRoot;
	}
	
	
	private void updateHeight(AVLNode curr) {
		if(curr.left == null && curr.right == null) {
			curr.height = 0;
		}
		
		if(curr.left == null) {
			curr.height = 1 + curr.right.height;
		}
		
		else if(curr.right == null) {
			curr.height = 1 + curr.left.height;
		}
		
		else {
			if(curr.left.height > curr.right.height) {
				curr.height = 1 + curr.left.height;
			}
			else {
				curr.height = 1 + curr.right.height;
			}
		}
		
	}
	
	private class AVLNode<T>{
		private T data;
		private int height;
		private AVLNode<T> left;
		private AVLNode<T> right;
		
		public AVLNode(T data) {
			this.data = data;
			left = null;
			right = null;
			height = 0;
		}
		

	}

}
