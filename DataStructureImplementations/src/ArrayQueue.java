
public class ArrayQueue {
	private int[] storage;
	private int size;
	private int front;
	private int back;
	private int capacity;
	
	public ArrayQueue() {
		storage = new int[10];
		size = 0;
		capacity = 10;
		front = 0;
		back = 0;
	}
	
	public void enqueue(int x) {
		if(size == capacity) {
			this.incCapacity();
		}
		
		if(back == capacity) {
			back = 0;
		}
		
		storage[back] = x;
		back++;
		size++;
	}
	
	public int dequeue() {
		if(front == capacity) {
			front = 0;
		}
		int data = storage[front];
		front++;
		size--;
		return data;
	}
	
	public int peek() {
		return storage[front];
	}
	
	private void incCapacity() {
		int newCapacity = capacity * 2;
		int[] temp = new int[newCapacity];
		for(int i = 0; i < size; i++) {
			int oldIdx = (i - front) % capacity;
			if(oldIdx < 0) {
				oldIdx += capacity;
			}
			temp[i] = storage[oldIdx];
		}
		
		capacity = newCapacity;
		storage = temp;
		front = 0;
		back = size;
	}
	
	public String toString() {
		String queue = "Front ";
		for(int i = front; i < front + size; i++) {
			queue += storage[i % capacity] + " ";
		}
		queue += "Back";
		
		return queue;
		
	}
	
	public int size() {
		return ( (back - front) % capacity > 0 ? (back - front) % capacity : ((back - front) % capacity) + capacity);
	}
}
