package 二叉树;

import java.awt.List;

import javax.swing.RootPaneContainer;

public class Tree {
	private static class Node{
		private char val;
		private Node left;
		private Node right;
		private  Node(char val) {
			this.val=val;
		}
	}
	private static Node buildTree() {
		Node a=new Node('A');
		Node b=new Node('B');
		Node c=new Node('C');
		Node d=new Node('D');
		Node e=new Node('E');
		Node f=new Node('F');
		Node g=new Node('G');
		Node h=new Node('H');
		a.left=b;a.right=c;
		b.left=d;b.right=e;
		c.left=f;c.right=g;
		g.left=h;
		return a;
	}
	public static void preOrderTraversal(Node root) {
		if(root==null) {
			return ;
		}
		System.out.println(root);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	public static int getSize(Node root) {
		if(root==null) {
			return 0;
		}
		int left=getSize(root.left);
		int right=getSize(root.right);
		return left+right+1;
	}
	public static int getLeafSize(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null&&root.right==null) {
			return 1;
		}
		int left=getLeafSize(root.left);
		int right=getLeafSize(root.right);
		return left+right;
	}
	public static boolean isSameTree(Node p,Node q) {
		if(p==null&&q==null) {
			return true;
		}
		if(p==null&&q!=null) {
			return false;
		}
		return isSameTree(p.left, q.left)&&isSameTree(p.right,q.right);	
	}
	public static int getHeight(Node root) {
		if(root==null) {
			return 0;
		}
		int left=getHeight(root.left);
		int right=getHeight(root.right);
		return left+right;
	}
	public  static Node findKlevel(Node root,char val) {
		if(root==null) {
			return null;
		}
		if(root.val==val) {
			return root;
		}
		Node n=findKlevel(root.left,val);
		if(n!=null) {
			return n;
		}
		n=findKlevel(root.right,val);
		if(n!=null) {
			return n;
		}
		return null;
	}

	public boolean isSubTree2(Node s,Node t) {
		if(s==null) {
			return false;
		}
		if(isSameTree(s, t)) {
			return true;
		}
		if(isSubTree2(s.left,t)) {
			return true;
		}
		if(isSubTree2(s.right, t)) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		System.out.println("=====================");
		Node root=buildTree();
		System.out.println(root);
		System.out.println("======================");
		getSize(root);
		System.out.println("节点个数:"+getSize(root));
		getLeafSize(root);
		System.out.println("叶子节点个数："+getLeafSize(root));
		findKlevel(root,'B');
		System.out.println(findKlevel(root,'B'));
	}	
}
