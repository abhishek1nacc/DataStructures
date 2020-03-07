
public class BinaryHeap {
	
	int heapArr[];
	int heapSize;
	int capacity;
	
	public BinaryHeap(int size) {
		this.capacity = size;
		heapArr = new int[size];
	}
	
	int getMin() {
		return heapArr[0];
	}
	
	int left(int i) {
		return (2*i + 1);
	}
	
	int right(int i) {
		return (2*i + 2);
	}
	
	int parent(int i) {
		return (i-1)/2;
	}
	
	void swap(int x, int y) {
		int temp = heapArr[x];
		heapArr[x] = heapArr[y];
		heapArr[y] = temp;
	}
	
	void insert(int key) {
		if(heapSize == capacity-1) {
			System.out.println("Heap Overflow");
			return;
		}
		heapSize++;
		int i = heapSize-1;
		heapArr[i] = key;
		while(i!=0 && heapArr[i] > heapArr[parent(i)]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	void maxHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		
		if(l < heapSize && heapArr[l] > heapArr[i]) {
			largest = l;
		}
		if(r < heapSize && heapArr[r] > heapArr[largest]) {
			largest = r;
		}
		
		if(largest != i) {
			swap(i, largest);
			maxHeapify(largest);
		}
	}
	
	int extractMax() {
		if(heapSize == 0) {
			return -1;
		}
		int max = heapArr[0];
		heapArr[0] = heapArr[heapSize-1];
		heapSize--;
		maxHeapify(0);
		return max;
	}
	
	void increaseKey(int i, int newVal) {
		if(heapArr[i] > newVal) {
			return;
		}
		
		heapArr[i] = newVal;
		while(i!=0 && heapArr[parent(i)] < heapArr[i]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	void delete(int i) {
		increaseKey(i, Integer.MAX_VALUE);
		extractMax();
	}
	
	public static void main(String[] args) {
		BinaryHeap bHeap = new BinaryHeap(12);
		bHeap.insert(19);
		bHeap.insert(2);
		bHeap.insert(78);
		bHeap.insert(56);
		bHeap.insert(26);
		bHeap.insert(63);
		bHeap.insert(100);
		bHeap.insert(200);
		bHeap.insert(10);
		bHeap.insert(120);
		
		System.out.println(bHeap.extractMax());
		System.out.println(bHeap.extractMax());
		System.out.println(bHeap.extractMax());
		System.out.println(bHeap.extractMax());
		System.out.println(bHeap.extractMax());
		System.out.println(bHeap.extractMax());
		System.out.println(bHeap.extractMax());
		System.out.println(bHeap.extractMax());
	}
}
