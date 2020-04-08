package ������;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BineryTree3 {
	public class Node{
		int val;
		Node left;
		Node right;
	    public Node(char val){
		    this.val=val;
	     }
	}
	//��������ǰ��ǵݹ����
	public static void preorder(Node root) {
		Stack<Node>stack=new Stack<>();
		Node cur=root;
		while(cur!=null&&!stack.isEmpty()) {
			while(cur!=null) {
				System.out.println(cur);
				stack.push(cur);
				cur=cur.left;
			}
			Node top=stack.pop();
			cur=top.right;
		}
	}
	
	//�������ķǵݹ�ǰ����������ϣ�
	public List<Integer>preorderTranversal(Node root){
		List<Integer>list=new ArrayList<>();
		Stack<Node>stack=new Stack<>();
		Node cur=root;
		while(cur!=null&&!stack.isEmpty()) {
			while(cur!=null) {
				list.add(cur.val);
				stack.push(cur);
				cur=cur.left;
			}
			Node top=stack.pop();
			cur=top.right;
		}
		return list;
	}
	//�������ķǵݹ��������
	public static void inorder(Node root) {
		Stack<Node>stack=new Stack<>();
		Node cur=root;
		while(cur!=null||!stack.isEmpty()) {
			while(cur!=null) {
				stack.push(cur);
				cur=cur.left;
			}
			Node top=stack.pop();
			System.out.println(top.val);
			cur=top.right;
		}
	}
	//�������ķǵݹ�������������ϣ�
	public List<Integer>inorderTraversal(Node root){
		List<Integer>list=new ArrayList<>();
		Stack<Node>stack=new Stack<>();
		Node cur=root;
		while(cur!=null||!stack.isEmpty()) {
			while(cur!=null) {
				stack.push(cur);
				cur=cur.left;
			}
			Node top=stack.pop();
			list.add(top.val);
			cur=top.right;
		}
		return list;
		
	}
	//�������ĺ���ǵݹ����
	public static void postorder(Node root) {
		Stack<Node>stack=new Stack<>();
		Node cur=root;
		Node last=null;//�ϴα�������Ľڵ�
		while(cur!=null&&!stack.isEmpty()) {
			while(cur!=null) {
				stack.push(cur);
				cur=cur.left;
			}
			Node top=stack.peek();//�鿴ջ��Ԫ��
			if(top.right==null||top.right==last) {
				System.out.println(top.val);
				stack.pop();
				last=top;
			}else {
				cur=top.right;
			}
		}
		
	}
}
