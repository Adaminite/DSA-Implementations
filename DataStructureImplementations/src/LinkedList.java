public class LinkedList<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void add(E data, int pos) {
		if(pos < 0 || pos > size) {
			return;
			//throw new IndexOutOfBoundsException("Cannot add to that index");
		}
		
		Node<E> n = new Node<E>(data);
		

		if(pos == 0) {
			n.next = head;
			head = n;
			
			if(size == 0) {
				tail = n;
			}
		}
		else if(pos == size) {
			
			tail.next = n;
			tail = n;
		}
		else {
			
			int idx = 1;
			Node<E> curr = head;
			while(idx < pos) {
				curr = curr.next;
				idx++;
			}
			
			n.next = curr.next;
			curr.next = n;
		}
		
		size++;
		
	}
	
	public void remove(int pos) {
		if(pos < 0 || pos > size - 1) {
			throw new IndexOutOfBoundsException("Cannot remove at specified index");
		}
		
		if(pos == 0) {
			head = head.next;
		}
		
		else {
			int idx = 1;
			Node<E> curr = head;
			while(idx < pos) {
				curr = curr.next;
				idx++;
			}
			
			curr.next = curr.next.next;
		}
		
		size--;
	}
	
	public int size() {
		return size;
	}
	
	public int find(E data) {
		Node<E> curr = head;
		int idx = 0;
		
		while(curr != null) {
			if(curr.data == data) {
				return idx;
			}
			
			curr = curr.next;
			idx++;
		}
		
		return -1;
	}
	
	public E get(int pos) {
		
		if(pos < 0 || pos > size - 1) {
			throw new IndexOutOfBoundsException("Cannot access that index");
		}
		
		int idx = 0;
		Node<E> curr = head;
		while(idx < pos) {
			curr = curr.next;
			idx++;
		}
		
		return curr.data;
	}
	
	private class Node<E>{
		private E data;
		private Node<E> next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	
	public String toString() {
		String contents = "head";
		Node<E> curr = head;
		while(curr != null) {
			contents += " ---> " + curr.data;
			curr = curr.next;
		}
		contents += " ---> null";
		
		return contents;
	}
	
}
