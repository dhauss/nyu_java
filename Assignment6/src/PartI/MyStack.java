package PartI;
import java.util.ArrayList;


public class MyStack<E> {

	private ArrayList<E> ar;
	
	public MyStack() {
		this.ar = new ArrayList<E>();
	}

	public MyStack(ArrayList<E> ar) {
		this.ar = ar;
	}
	
	public boolean empty() {
		return ar.size() == 0;
	}
	
	public void push(E element) {
		//pushing top of stack to the end of the array for better performance
		ar.add(element);
	}
	
	public E peek() {
		//peek/pop from end of array
		if(ar.size() > 0)
			return ar.get(ar.size() - 1);
		else
			return null;
	}
	
	public E pop() {
		if(ar.size() > 0)
			return ar.remove(ar.size() - 1);
		else
			return null;
	}
	
	public int search(Object o) {
		//return 1-indexed position where top of stack is position 1
		int i = ar.indexOf(o);
		
		if(i < 0)
			return i;
		else
			return ar.size() - ar.indexOf(o);
	}	
}
