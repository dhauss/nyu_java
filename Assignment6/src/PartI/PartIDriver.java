package PartI;

public class PartIDriver {

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		

		System.out.println(stack.empty());
		//System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.search(1));
		System.out.println(stack.search("cat"));

		

	}

}
