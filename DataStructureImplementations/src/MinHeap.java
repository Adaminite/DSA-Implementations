
public class MinHeap {
	
	public int[] heap;
	public int size;
	
	public MinHeap(int[] x) {
		this.size = x.length;
		buildMinHeap(x, size);
		this.heap = x;
		
	}
	
	private void buildMinHeap(int[] x, int size) {
		for(int i = size / 2; i >= 0; i--) {
			minHeapify(x, i, size);
		}
	}
	
	private void minHeapify(int[] x, int i, int size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int smallest = i;
		
		if(left < size && x[left] < x[smallest]) {
			smallest = left;
		}
		
		if(right < size && x[right] < x[smallest]) {
			smallest = right;
		}
		
		if(smallest != i) {
			int temp = x[smallest];
			x[smallest] = x[i];
			x[i] = temp;
			minHeapify(x, smallest, size);
		}
	}
	
	public int[] heapSortWrap() {
		int[] sorted = this.heap.clone();
		int heapSize = this.size;
		heapSort(sorted, heapSize);
		return sorted;
	}
	
	private void heapSort(int[] x, int heapSize) {
		for(int i = 0; i < x.length; i++) {
			
			// swap first and last elements
			int temp = x[0];
			x[0] = x[heapSize - 1];
			x[heapSize - 1] = temp;
			
			// now, call minHeapify on the remaining elements of the heap
			heapSize--;
			minHeapify(x, 0, heapSize);
			
		}
	}
}
