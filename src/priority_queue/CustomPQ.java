package priority_queue;

import java.util.ArrayList;

public class CustomPQ {
	
	ArrayList<Integer> arr;
	
	public  CustomPQ() {
		arr = new ArrayList();
	}
	
	public void add(int data) {
		arr.add(data);
	}
	
	public int remove(){
		
		int min = arr.get(0);
		int minIndex = 0;
		
		for(int i=1;i<arr.size();i++) {
			if(min>arr.get(i)) {
				min = arr.get(i);
				minIndex = i;
			}
		}
		arr.remove(minIndex);
		return min;
	}
}
