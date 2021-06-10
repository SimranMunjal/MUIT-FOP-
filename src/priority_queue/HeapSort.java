package priority_queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
	}
}

public class HeapSort {
	
	public static void inPlaceHeapSort(int arr[]) {
		
		for(int i=1;i<arr.length;i++) {
			int childIndex = i;
			int parentIndex = (childIndex-1)/2;
			while(childIndex>0) {
				if(arr[childIndex]<arr[parentIndex])
					break;
				int temp = arr[childIndex];
				arr[childIndex] = arr[parentIndex];
				arr[parentIndex] = temp;
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			int max = arr[0];
			arr[0] = arr[i];
			arr[i] = max;
			int parentIndex = 0;
			int leftChildIndex = 2*parentIndex+1;
			int rightChildIndex = 2*parentIndex+2;
			while(parentIndex<i) {
				int maxIndex = parentIndex;
				int maxVal = arr[parentIndex];
				if(leftChildIndex<i && arr[leftChildIndex]>arr[maxIndex]) {
					maxIndex = leftChildIndex;
					maxVal = arr[leftChildIndex];
				}
				if(rightChildIndex<i && arr[rightChildIndex]>arr[maxIndex]) {
					maxIndex = rightChildIndex;
					maxVal = arr[rightChildIndex];
				}
				if(parentIndex==maxIndex)
					break;
				else {
					arr[maxIndex] = arr[parentIndex];
					arr[parentIndex] = maxVal;
					parentIndex = maxIndex;
					leftChildIndex = 2*parentIndex+1;
					rightChildIndex = 2*parentIndex+2;
				}
			}
		}
	}
	public static Node merge(LinkedList<Node> list) {
		
		Node head = null;
		Node tail = null;
		
		PriorityQueue<Node> pq = new PriorityQueue( new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.data<o2.data)
					return -1;
				else {
					return 1;
				}
			}
			
		});
		
		for(int i=0;i<list.size();i++) {
			Node x = list.get(i);
			pq.add(x);
		}
		
		while(!pq.isEmpty()) {
			Node curr = pq.remove();
			if(curr.next!=null) {
				pq.add(curr.next);
			}
			
			if(head==null) {
				head = curr;
				tail = curr;
			}
			else {
				tail.next = curr;
				tail = tail.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		
//		int arr[] = {2,3,5,7,6,8,4,1};
//		inPlaceHeapSort(arr);
//		for(int i:arr) {
//			System.out.print(i+" ");
//		}
		
		Node n1 = new Node(1);
		n1.next = new Node(4);
		n1.next.next = new Node(7);
		
		Node n2 = new Node(2);
		n2.next = new Node(5);
		n2.next.next = new Node(6);
		
		Node n3 = new Node(3);
		n3.next = new Node(8);
		n3.next.next = new Node(9);
		
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(n1);
		list.add(n2);
		list.add(n3);
		
		Node ans = merge(list);
		while(ans!=null) {
			System.out.print(ans.data+"  ");
			ans = ans.next;
		}
	}
}
