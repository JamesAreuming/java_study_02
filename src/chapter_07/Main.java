package chapter_07;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		//exam01();
		
		Stack<String> s = new Stack<String>();
		s.puch("a");
		s.puch("b");
		s.puch("c");
		
		System.out.println(s.push());
		System.out.println(s.push());
		System.out.println(s.push());
		
		
		
	}

	public static void exam01() {
		MyStack st01 = new MyStack();
		st01.prnStack();
		st01.push("a");
		st01.prnStack();
		st01.push("b");
		st01.prnStack();
		st01.push("c");
		st01.prnStack();
		
		System.out.println(st01.pop());
	}

}
