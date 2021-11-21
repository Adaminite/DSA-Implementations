
public class LLStack<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public LLStack() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void push(E data) {
		
		Node<E> n = new Node<E>(data);
		
		if(head == null) {
			head = n;
			tail = n;
		}
		else {
			n.next = head;
			head = n;
		}
		size++;


	}
	
	public E pop() {
		if(head == null) {
			return null;
		}
		
		E data = head.data;
		
		if(head == tail) {
			head = null;
			tail = null;
		}
		
		else {
			head = head.next;
		}
		
		size--;
		return data;
	}
	
	public E top() {
		if(head == null) {
			return null;
		}
		
		return head.data;
	}
	
	private class Node<E>{
		public E data;
		public Node<E> next;
		
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
	
	public int size() {
		return size;
	}
}
