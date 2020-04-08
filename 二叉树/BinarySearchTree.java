package ������;

public class BinarySearchTree {
	public class Node{
		int key;
		int value;
		Node left;
		Node right;
		public Node(int key) {
			this.key=key;
		}
	}
	private Node root=null;
	//���������в���key������ҵ�������key���ڵĽڵ㡣���򷵻� null
	public Node search(int key) {
		Node cur=root;;
		while(cur!=null) {
			if(key==cur.key) {
				return cur; 
			}else if(key<cur.key) {
				cur=cur.left;
			}else {
				cur=cur.right;
			}
		}
		return null;
	}
	//���루return true��ʾ����ɹ���false��ʾ����ʧ�ܣ�
	public boolean insert(int key) {
		if(root==null) {
			root=new Node(key);
			return true;
		}
		Node cur=root;
		Node parent=null;
		while(cur!=null) {
			if(key==cur.key) {
				return false;
			}else if(key<cur.key) {
				parent=cur;
				cur=cur.left;
			}else {
				parent=cur;
				cur=cur.right;
			}
		}
		Node node =new Node(key);
		if(key<parent.key) {
			parent.left=node;
		}else {
			parent.right=node;
		}
		return true;
	}
	//����ɾ��(ɾ���ɹ�����true��ʧ�ܷ���false)
	public boolean remove(int key) {
		Node cur=root;
		Node parent=null;
		while(cur!=null) {
			if(key==cur.key) {
				//�ҵ���׼��ɾ��
				removeNode(parent,cur);
				return true;
			}else if(key<cur.key) {
				parent=cur;
				cur=cur.left;
			}else {
				parent=cur;
				cur=cur.right;
			}
		}
		return false;
	}
	//ɾ��
	private void removeNode(Node parent, Node cur) {
		 if(cur.left==null) {
			 if(cur==root) {
				 root=cur.right;
			 }else if(cur==parent.left) {
				 parent.left=cur.right;
			 }else {
				 parent.right=cur.right;
			 }
		 }else if(cur.right==null) {
			 if(cur==root) {
				  root=cur.left;
			 }else if(cur==parent.left) {
				 parent.left=cur.left;
			 }else {
				 parent.right=cur.left;
			 }
		 }else {
			  	Node goadparent=cur;
			  	Node goad=cur.right;
			  	while(goad.left!=null) {
			  		goadparent=goad;
			  		goad=goad.left;
			  	}
			  	cur.key=goad.key;
			  	if(goad==goadparent.left) {
			  		goadparent.left=goad.right;
			  	}else {
			  		 goadparent.right=goad.right;
			  	}
		 }
	}
	private static void inOrder(Node node) {
		if(node!=null) {
			System.out.println(node.key);
			inOrder(node.left);
			inOrder(node.right);
		}
	}
	private static void preOrder(Node node) {
		if(node!=null) {
			System.out.println(node.key);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	public static void main(String[] args) {
		BinarySearchTree tree=new BinarySearchTree();
		int[] keys= {3,9,7,4,1,6,2,8,5};
		for(int key:keys) {
			System.out.println(tree.insert(key));
		}
		System.out.println("�����ظ�����");
		System.out.println(tree.insert(7));
		System.out.println("ǰ�����");
		preOrder(tree.root);
		System.out.println("�������");
		inOrder(tree.root);
		System.out.println(tree.search(7).key);
		System.out.println(tree.search(8).key);
		System.out.println(tree.search(5).key);
	}
}
 