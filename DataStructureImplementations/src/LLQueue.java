
public class LLQueue<E> {
	
	private Node<E> front;
	private Node<E> back;
	private int size;
	
	public LLQueue() {
		front = null;
		back = null;
		size = 0;
	}
	
	public void enqueue(E data) {
		
		Node<E> item = new Node<E>(data);
		if(this.isEmpty()) {
			front = item;
			back = item;
		}
		else {
			back.next = item;
			back = item;
		}
		size++;
	}
	
	public E dequeue() {
		if(this.isEmpty()) {
			return null;
		}
		
		E data = front.data;
		
		if(front == back) {
			front = null;
			back = null;
		}
		else {
			front = front.next;
		}
		
		size--;
		return data;
	}
	
	
	public E peek() {
		if(front == null) {
			return null;
		}
		
		return front.data;
		
	}
	
	private class Node<E>{
		private E data;
		private Node<E> next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String queue = "Front";
		Node<E> curr = front;
		while(curr != null) {
			queue += " " + curr.data;
			curr = curr.next;
		}
		queue += " Back";
		
		return queue;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
