package 二叉树;
//通讯录

public class Contact {
	public static class Node{
		String name;
		String phone;
		Node left;
		Node right;	
	}
	public static Node root=null;
	public boolean insert(String name,String phone) {
		return false;
	}
	//根据姓名查找电话
	public static String Search(String name) {
		Node cur=root;
		while(cur!=null){
			int r=name.compareTo(cur.name);
			if(r==0) {
				return cur.phone;
			}else if(r<0){
				cur=cur.left;
			}else {
				cur=cur.right;
			}
		}
		return null;
	}
	//更新通讯录
	public static String update(String name,String phone) {
		Node cur=root;
		while(cur!=null) {
			int r=name.compareTo(cur.name);
			if(r==0) {
				String oldPhone=cur.phone;
				cur.phone=phone;
				return oldPhone;
			}else if(r<0) {
				cur=cur.left;
			}else {
				cur=cur.right;
			}
		}
		return null;
	}	
}
