
public class MaxHeap {
	
	public int[] heap;
	public int size;
	
	public MaxHeap(int [] x) {
		size = x.length;
		buildMaxHeap(x, size);
		this.heap = x;

	}
	
	private void buildMaxHeap(int [] x, int size) {
		for(int i = size / 2; i >= 0; i--) {
			maxHeapify(x, i, size);
		}
	}
	

	private void maxHeapify(int[] x, int i, int size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		
		if(left < size  && x[left] > x[largest]) {
			largest = left;
		}
		
		if(right < size && x[right] > x[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			int temp = x[largest];
			x[largest] = x[i];
			x[i] = temp;
			maxHeapify(x, largest, size);
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
			// swap largest and final element in array
			int temp = x[0];
			x[0] = x[heapSize - 1];
			x[heapSize - 1] = temp;
			
			// call max heapify on x
			heapSize--;
			maxHeapify(x, 0, heapSize);
			
		}
	}
	
	
	
}
