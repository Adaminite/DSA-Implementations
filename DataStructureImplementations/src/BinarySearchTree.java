import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private int size;
	private BSTNode root;
	private Comparator<T> comparator;
	private boolean found;
	private boolean added;
	
	public BinarySearchTree(){
		this.size = 0;
		this.root = null;
	}
	
	private class BSTNode<T> implements Comparable<BSTNode>{
		private BSTNode left;
		private BSTNode right;
		private T data;
		
		public BSTNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}


		@Override
		public int compareTo(BSTNode other) {
			return this.data.compareTo(other.data);
		} 
	}
	
	/** No balancing implementation of add. Simple recursive method. 
	 *  It simply keeps going until we find a spot for it and adds it there, 
	 *  or if we find a duplicate and end the process there.
	 * 
	 */
	/*public boolean add(T data) {
		if(data == null) {
			throw new NullPointerException("Cannot add null value to tree");
		}
		
		if(this.root == null) {
			this.root = new BSTNode(data);
			return true;
		}
		
		return addRec(data, this.root);
	}
	
	private boolean addRec(T data, BSTNode curr) {
		if(curr.data == data) {
			return false;
		}
		
		if(curr.data.compareTo(data) > 0) {
			if(curr.left == null) {
				curr.left = new BSTNode(data);
				return true;
			}
			addRec(data, curr.left);
		}
		
		if(curr.data.compareTo(data) < 0) {
			if(curr.right == null) {
				curr.right = new BSTNode(data);
				return true;
			}
			
			addRec(data, curr.right);
		}
		
	}
	
	*/
	/**
	 * Add implementation with references to subtrees. It updates the tree
	 * as we add in the new node. Useful if we want to balance later on.
	 */
	
	public boolean add(T data) {
		if(data == null) {
			throw new NullPointerException();
		}
		
		added = false;
		root = addRec(data, root);
		return added;
	}
	
	private BSTNode addRec(T data, BSTNode curr) {
		if(curr == null) {
			added = true;
			return new BSTNode(data);
		}
		
		if(data.compareTo(curr.data)> 0) {
			curr.right = addRec(data, curr.right);
		}
		else if(data.compareTo(curr.data) < 0) {
			curr.left = addRec(data, curr.left);
		}
		else {
			added = false;
		}
		
		return curr;
		
	}
	
	
	/** No balancing implementation of remove. Simple recursive method.
	 *  In each iteration, returns the reference to the subtree that was
	 *  just processed. To remove a node, it replaces the node's data with
	 *  its predecessor's, then removes the predecessor from the tree since
	 *  it is much easier to remove a leaf. This effectively "moves"
	 *  the predecessor up the tree.
	 */
	
	public boolean remove(T data) {
		if(data == null) {
			throw new NullPointerException();
		}
		
		if(this.root == null) {
			return false;
		}
		
		found = true;
		root = removeRec(data, this.root);

		return found;
	}
	
	private BSTNode removeRec(T data, BSTNode curr) {
		if(curr == null) {
			found = false;
			return curr;
		}
		
		if(data.compareTo(curr.data) > 0) {
			curr.right = removeRec(data, curr.right);
		}
		
		else if(data.compareTo(curr.data) < 0 ) {
			curr.left = removeRec(data, curr.left);
		}
		else {
			curr = removeNode(curr);
			found = true;
		}
		
		
		return curr;
	}
	
	private BSTNode removeNode(BSTNode node) {
		
		if(node.left == null) {
			return node.right;
		}
		if(node.right == null) {
			return node.left;
		}
		else {
			T data = this.getPredecessor(node.left);
			node.data = data;
			node.left = removeRec(data, node.left);
			return node;
		}
		
		
	}
	
	private T getPredecessor(BSTNode subtree) {
		if(subtree == null) {
			throw new NullPointerException("Cannot find predecessor in empty subtree");
		}
		BSTNode temp = subtree;
		while(temp.right != null) {
			temp = temp.right;
		}
		
		return (T) temp.data;
	}
	
	
	/**
	 * Basic implementation for finding something. It follows a path down the tree
	 * until it either arrives at null (not found) or at the node (found). Returns true if
	 * found, false if not.
	 */
	
	public boolean find(T data) {
		if(data == null) {
			throw new NullPointerException();
		}
		
		if(root == null) {
			return false;
		}
		else {
			return findRec(data, root);
		}
	}
	
	private findRec(T data, BSTNode curr) {
		if(curr == null) {
			return false;
		}
		
		if(data.compareTo(curr.data) > 0) {
			return findRec(data, curr.right);
		}
		else if(data.compareTo(curr.data) < 0) {
			return findRec(data.curr.left);
		}
		else {
			return true;
		}
	}
}
