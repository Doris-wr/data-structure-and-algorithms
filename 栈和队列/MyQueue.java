package 栈和队列;
//利用链表的头删+尾插实现队列
class Node{
	int val;
	Node next;
}
public class MyQueue {
	private Node head;
	private Node tail;
	private int size;
	public void offer(int i) {
		Node node=new Node();
		node.val=i;
		if(tail==null) {
			head=tail=node;
		}else {
			tail.next=node;
			tail=node;
		}
		size++;
	}
	public int poll() {
		Node first=head;
		head=head.next;
		if(head==null) {
			tail=null;
		}
		size--;
		return first.val;
	}
	public int peek() {
		return head.val;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	public static void main(String[] args) {
		MyQueue queue=new MyQueue();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
	public void push(int i) {
		// TODO 自动生成的方法存根
		
	}	
}
