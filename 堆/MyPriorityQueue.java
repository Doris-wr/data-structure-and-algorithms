package 堆;

//优先级队列
public class MyPriorityQueue {
	private int[] array;
	private int size;
	MyPriorityQueue(){
		array=new int[16];
		size=0;
	}
	public int poll() {
		int oldValue=array[0];
		array[0]=array[size-1];
		Heap.shiftDownSmall(array,0,size);
		return oldValue;
	}
	public void offer(int element) {
		array[size++]=element;
		Heap.shiftUpSmall(array,size-1);
	}
	public int peek() {
		return array[0];
	}
	
	
	public static void main(String[] args) {
		MyPriorityQueue queue=new MyPriorityQueue();
		queue.offer(7);
		queue.offer(9);
		queue.offer(5);
		System.out.println(queue.poll());    //5
		queue.offer(3);
		System.out.println(queue.poll());    //3
		queue.offer(10);
		queue.offer(8);
		System.out.println(queue.poll());    //7
		System.out.println(queue.poll());    //8
		System.out.println(queue.poll());   //9
		System.out.println(queue.poll());   //10
	}
}
