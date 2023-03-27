package PartI;

import java.util.Stack;

public class BalancedParentheses {

	public static boolean isBalanced(String inString) {
		Stack<Character> parStack = new Stack<>();
		
		for(int i = 0; i < inString.length(); i++) {
			switch(inString.charAt(i)) {
				case '(':
					parStack.push('(');
					break;
				case ')':
					if(parStack.isEmpty()) {
						return false;
					}
					parStack.pop();
					break;
				default:
					continue;
			}	
		}
		return parStack.isEmpty();
	}

	public static void main(String[] args) {
		boolean result = isBalanced("(()()()())");
		System.out.println(result);
		result = isBalanced("(((())))");
		System.out.println(result);
		result = isBalanced("((((((())");
		System.out.println(result);
		
		result = isBalanced("");
		System.out.println(result);
		result = isBalanced("(((");
		System.out.println(result);
		result = isBalanced("))))");
		System.out.println(result);

	}
}
