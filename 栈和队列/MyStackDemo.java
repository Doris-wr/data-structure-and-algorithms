package ջ�Ͷ���;

//�ö���ʵ��ջ
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
	private Queue<Integer> queue;

	public MyStack() {
		queue = new LinkedList<>();
	}

	public void push(int x) {// Ԫ��X��ջ
		queue.offer(x);
	}

	public int pop() {// �Ƴ�ջ��Ԫ��
		int size = queue.size();
		for (int i = 0; i < size - 1; i++) {
			int v = queue.poll();
			queue.offer(v);
		}
		return queue.poll();
	}

    public int top() {
		int size=queue.size();
		for(int i=0;i<size-1;i++) {
			int v=queue.poll();
			queue.offer(v);
		}
		int v=queue.poll();
		queue.offer(v);
		return v;
	}
    public boolean empty() {
    	return queue.isEmpty();
    }

}

public class MyStackDemo {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(8);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.empty());
		System.out.println(stack.top());
	}
}
