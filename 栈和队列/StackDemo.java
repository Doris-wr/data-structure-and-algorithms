package ջ�Ͷ���;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack<String>stack=new Stack<>();
		stack.push("ѧϰ");
		stack.push("˯��");
		stack.push("�Է�");
		stack.push("�򶹶�");
		System.out.println(stack.empty());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
