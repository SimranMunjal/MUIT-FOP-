package priority_queue;

import java.util.ArrayList;

public class MinHeap {
	
	ArrayList<Integer> heap;
	
	public MinHeap(){
		heap = new ArrayList();
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public int min() {
		if(heap.isEmpty())
			return Integer.MAX_VALUE;
		
		return heap.get(0);
	}
	
	public void insert(int data) {
		
		heap.add(data);
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;
		while(childIndex>0) {
			if(heap.get(parentIndex)>heap.get(childIndex)) {
				int temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(childIndex));
				heap.set(childIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
			else {
				break;
			}
		}
	}
	
	public int removeMin() {
		
		if(heap.isEmpty())
			return Integer.MAX_VALUE;
		
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int parentIndex = 0;
		int leftChildIndex = 2*parentIndex+1;
		int rightChildIndex = 2*parentIndex+2;
		
		while(leftChildIndex<heap.size()) {
			int minIndex = parentIndex;
			if(heap.get(leftChildIndex)<heap.get(minIndex)) {
				minIndex = leftChildIndex;
			}
			if(rightChildIndex<heap.size() && heap.get(rightChildIndex)<heap.get(minIndex)) {
				minIndex = rightChildIndex;
			}
			if(parentIndex==minIndex) {
				break;
			}
			else {
				int temp1 = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(minIndex));
				heap.set(minIndex, temp1);
				parentIndex = minIndex;
				leftChildIndex = 2*parentIndex+1;
				rightChildIndex = 2*parentIndex+2;
			}
		}
		return temp;
	}
}
