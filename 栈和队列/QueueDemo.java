package ջ�Ͷ���;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		Queue<String>queue=new LinkedList<>();
		queue.add("ѧϰ");
		queue.add("˯��");
		queue.add("�Է�");
		queue.add("�򶹶�");
		System.out.println(queue.isEmpty());
		System.out.println(queue.element());
		System.out.println(queue.peek());
		System.out.println("===============");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println("========================");
		System.out.println(queue.poll());
	}
}
