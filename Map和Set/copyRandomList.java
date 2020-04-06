package Map和Set;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.NotIdentifiableEvent;

//面试题：复制带随机指针的链表
public class copyRandomList {
	private static class Node{
		private int val;
		private Node next;
		private  Node random;
		private Node() {};
		private Node(int val,Node next,Node random) {
			this.val=val;
			this.next=next;
			this.random=random;
		}
	}
	public static Node copyRandomList(Node head) {
		//复制链表
		Node cur=head;
		while(cur!=null) {
			Node node=new Node();
			node.val=cur.val;
			node.next=cur.next;
			cur.next=node;
			cur=node.next;
		}
		//复制random
		cur=head;
		while(cur!=null) {
			Node node=cur.next;
			if(cur.random!=null) {
				node.random=cur.random.next;
			}else {
				node.random=null;
			}
			cur=node.next;
		}
		//将链表分开成两个
		cur=head;
		if(head==null) {
			return null;
		}
		Node newHead=head.next;
		while(cur!=null) {
			Node node=cur.next;
			if(node.next!=null) {
				cur.next=node.next;
				node.next=node.next.next;
			}
			cur=cur.next;
		}
		return newHead;
	}
	private static class NodeComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			// TODO 自动生成的方法存根
			return o1.val-o2.val;
		}
	}
	public static Node  copyRandomList2(Node head) {
		Map<Node, Node>map=new TreeMap<>(new NodeComparator());
		Node newHead=null;
		Node NewLast=null;
		Node cur=head;
		while(cur!=null) {
			Node node=new Node();
			node.val=cur.val;
			if(newHead==null) {
				newHead=node;
			}else {
				NewLast.next=node;
			}
			NewLast=node;
			map.put(cur,node);
			cur=cur.next;
		}
		cur=head;
		Node node=newHead;
		while(node!=null) {
			if(cur.random!=null) {
				node.random=map.get(cur.random);
			}else {
				node.random=null;
			}
			cur=cur.next;
			node=node.next;
		}
		return newHead;
	}
}

