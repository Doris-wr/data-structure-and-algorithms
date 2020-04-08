package ������;

public class BineryTree {
	private static class Node{
		private char val;
		private Node left;
		private Node right;
		private Node(char val) {
			this.val=val;
		}
	}
	public static Node buildTree(){
		Node a=new Node('A');
		Node b=new Node('B');
		Node c=new Node('C');
		Node d=new Node('D');
		Node e=new Node('E');
		Node f=new Node('F');
		Node g=new Node('G');
		Node h=new Node('H');
		a.left=b; a.right=c;
		b.left=d;b.right=e;
		c.left=f;c.right=g;
		e.right=h;
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
	public static void inOrderTraversal(Node root) {
		//�������
		//���������������+��+���������������
		if(root==null) {
			return ;
		}
		inOrderTraversal(root.left);
		System.out.println(root);
		inOrderTraversal(root.right);
	}
	public static void postOrderTraversal(Node root) {
		//��������������
		if(root==null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root);
	}
	//��������ڵ����
	private static int count=0;
	public static void getSize(Node root) {
		if(root==null) {
			return;
		}
		count++;
		getSize(root.left);
		getSize(root.right);
	}
	public static int getSize2(Node root) {
		if(root==null) {
			return 0;
		}
		int left=getSize2(root.left);
		int right=getSize2(root.right);
		return left+right+1;
	}
	//��Ҷ�ӽڵ����
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
	//����������
	public static int getHeight(Node root) {
		if(root==null) {
			return 0;
		}
		int left =getHeight(root.left);
		int right=getHeight(root.right);
		return  Math.max(left,right)+1;
	}
	//���������k��Ľڵ����
	public static int getKlevel(Node root,int k) {
		if(root==null) {
			return 0;
		}
		if(k==1) {
			return 1;
		}
		int left=getKlevel(root.left, k-1);
		int right=getKlevel(root.right, k-1);
		return left+right;
	}
	//����VAL���ڵĽڵ㣬û���ҵ�����null���ҵ��򷵻ظýڵ������
	public static Node find(Node root,int val) {
		if(root==null) {
			return null;
		}
		if(root.val==val) {
			return root;
		}
		Node n=find(root.left, val);
		if(n!=null) {
			return n;
		}
		n=find(root.right, val);
		if(n!=null) {
			return n;
		}
		return null;
	}		
	public static boolean find2(Node root,int val) {
		if(root==null) {
			return false;
		}
		if(root.val==val) {
			return true;
		}
		if(find2(root.left, val)) {
			return true;
		}
		return(find2(root.right, val));
	}
	//�ж��Ƿ�����ͬ�Ķ�����
	public static boolean isSameTree(Node p,Node q) {
		//�ж������������Ƿ�����ͬ��
		if(p==null&&q==null) {
			return true;
		}
		if(p==null||q==null) {
			return false;
		}
		return p.val==q.val&&isSameTree(p.left, q.left)&&isSameTree(p.right,q.right);
	}
	//�ж������������Ƿ��Ǿ����
	public boolean isMirrorTree(Node p,Node q) {
		if(p==null&&q==null) {
			return true;
		}
		if(p==null||q==null) {
			return false;
		}
		return p.val==q.val&&isMirrorTree(p.left, q.left)&&isMirrorTree(p.right, q.right);
	}
	//�����������������������һ���������Ƿ��������һ�Ŷ�������
	public static boolean isSubTree(Node p,Node q) {
		isSameTree(p,q);
	
	}
	//�ж��Ƿ���ƽ�������
	public static boolean isBalanced(Node root) {
		if(root==null) {
			return true;
		}
	    int left=getHeight(root.left);
		int right=getHeight(root.right);
		if(right-left>=-1&&right-left<=1) {
			return true;
		}
		return false;
    }
	public static void main(String[] args) {
		Node root=buildTree();	
		System.out.println("Succcess");
		preOrderTraversal(root);
		System.out.println("====================");
		inOrderTraversal(root);
		System.out.println("=====================");
		postOrderTraversal(root);
		System.out.println("=====================");
		count=0;
		getSize(root);
		System.out.println("�ڵ������"+count);
		System.out.println("======================");
		int leafSize=0;
		getLeafSize(root);
		System.out.println("Ҷ�ӽڵ������"+leafSize);
		System.out.println(getHeight(root));
	}
}
