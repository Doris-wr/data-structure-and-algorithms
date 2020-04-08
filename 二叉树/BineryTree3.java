package 二叉树;

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
	//二叉树的前序非递归遍历
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
	
	//二叉树的非递归前序遍历（集合）
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
	//二叉树的非递归中序遍历
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
	//二叉树的非递归中序遍历（集合）
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
	//二叉树的后序非递归遍历
	public static void postorder(Node root) {
		Stack<Node>stack=new Stack<>();
		Node cur=root;
		Node last=null;//上次被遍历完的节点
		while(cur!=null&&!stack.isEmpty()) {
			while(cur!=null) {
				stack.push(cur);
				cur=cur.left;
			}
			Node top=stack.peek();//查看栈顶元素
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
