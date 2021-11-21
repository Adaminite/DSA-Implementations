
public class ArrayStack {
	
	private int[] storage;
	private int size;
	private int capacity;
	
	public ArrayStack() {
		storage = new int[10];
		capacity = 10;
		size = 0;
	}
	
	public void push(int x) {
		if(size == capacity) {
			this.incCapacity();
		}
		storage[size] = x;
		size++;
	}
	
	public int pop() {
		if(size == 0) {
			return -1;
		}
		
		int data = storage[size - 1];
		size--;
		return data;
	}
	
	public int top() {
		if(size == 0) {
			return -1;
		}
		
		return storage[size - 1];
	}
	
	private void incCapacity() {
		int[] temp = new int[capacity * 2];
		for(int i = 0; i < capacity; i++) {
			temp[i] = storage[i];
		}
		
		capacity = capacity * 2;
		storage = temp;
	}
	
	public String toString() {
		String stack = "Front ";
		for(int i = size - 1; i > -1; i--) {
			stack += storage[i] + " ";
		}
		stack += "Back";
		return stack;
	}
}
