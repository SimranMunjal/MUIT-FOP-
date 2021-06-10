package priority_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Person{
	
	String name;
	int age;
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
}

class NewComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.age<o2.age) {
			return 1;
		}
		else if(o1.age>o2.age) {
			return -1;
		}
		else
			return 0;
	}
}

public class Priority_Queue {
	
	public static void main(String[] args) {
		
//		ArrayList<Person> arr = new ArrayList();
//		Person p1 = new Person("abc",24);
//		arr.add(p1);
//		Person p2 = new Person("bcd",19);
//		arr.add(p2);
//		Person p3 = new Person("cde",46);
//		arr.add(p3);
//		Person p4 = new Person("def",58);
//		arr.add(p4);
//		Person p5 = new Person("efg",34);
//		arr.add(p5);
//		Collections.sort(arr, new NewComparator());
//		Person p6 = new Person("xyz", 67);
//		System.out.println(arr.get(0).name);
//		
//		
//		PriorityQueue<Person> pq = new PriorityQueue(new NewComparator());
//		pq.add(p1);
//		pq.add(p2);
//		pq.add(p3);
//		pq.add(p4);
//		pq.add(p5);
//		pq.add(p6);
//		System.out.println(pq.peek().name);
//		pq.remove();
//		System.out.println(pq.peek().name);
//		
//		
//		PriorityQueue x = new PriorityQueue();
//		x.add("abc");
//		x.add("bcsswswswsws");
//		x.add("cdedwa");
//		System.out.println(x.peek());
//		
//		CustomPQ cpq = new CustomPQ();
//		cpq.add(5);
//		cpq.add(3);
//		cpq.add(8);
//		cpq.add(1);
//		System.out.println(cpq.remove());
//		System.out.println(cpq.remove());
		
		MinHeap z = new MinHeap();
		z.insert(5);
		z.insert(3);
		z.insert(2);
		z.insert(0);
		z.insert(7);
		System.out.println(z.min());
		z.removeMin();
		System.out.println(z.min());
	}

}
