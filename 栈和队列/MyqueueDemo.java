package 栈和队列;
//用栈实现队列
import java.util.Stack;

class Myqueue{
	private Stack<Integer> in;
	private Stack<Integer> out;
	public Myqueue() {
		in=new Stack<>();
		out=new Stack<>();
	}
	public int push(int x) {
		return in.push(x);
	}
	public int pop() {
		if(out.isEmpty()) {
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		return out.pop();
	}
	public int peek() {
		if(out.isEmpty()) {
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		return out.peek();
	}
	public boolean empty() {
		return in.empty()&&out.empty();
	}
}

public class MyqueueDemo {
	public static void main(String[] args) {
		MyQueue myqueue=new MyQueue();
		myqueue.push(1);
		myqueue.push(2);
		System.out.println(myqueue);
	}
}
