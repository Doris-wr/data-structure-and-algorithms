package 栈和队列;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack<String>stack=new Stack<>();
		stack.push("学习");
		stack.push("睡觉");
		stack.push("吃饭");
		stack.push("打豆豆");
		System.out.println(stack.empty());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
