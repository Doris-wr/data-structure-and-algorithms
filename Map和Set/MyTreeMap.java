package Map和Set;
//实现一个二叉搜作树，要求key-value模型，要求方法和Map类似

import java.util.Set;

import javax.print.attribute.standard.RequestingUserName;

public class MyTreeMap {
	public class MyEntry{
		private int key;
		private int value;
		private MyEntry left;
		private MyEntry right;
		private MyEntry(int key,int value) {
			this.key=key;
			this.value=value;
		}
		public int getKey() {
			return key;
		}
		public int getValue() {
			return value;
		} 
	}
	private MyEntry root=null;
	public int get(int key) {
		MyEntry cur=root;
		while(cur!=null) {
			if(key==cur.key) {
				return cur.value;
			}else if(key<cur.key) {
				cur=cur.left;
			}else {
				cur=cur.right;
			}
		}
		return -1;
	}
	public int getOrDefault(int key,int defaultValue) {
		MyEntry cur=root;
		while(cur!=null) {
			if(key==cur.key) {
				return cur.value;
			}else if(key<cur.key) {
				cur=cur.left;
			}else {
				cur=cur.right;
			}
		}
		return defaultValue;
	}
	public int set(int key,int value) {
		if(root==null) {
			root= new MyEntry(key, value);
			return -1;
		}
		MyEntry parent=null;
		MyEntry cur=root;
		while(cur!=null) {
			if(key==cur.key) {
				int oldValue=cur.value;
				cur.value=value;
				return oldValue;
			}else if(key<cur.key) {
				parent=cur;
				cur=cur.left;
			}else {
				parent=cur;
				cur=cur.right;
			}
		}
		if(cur==parent.left) {
			parent.left=new MyEntry(key, value);
		}else {
			parent.right=new MyEntry(key, value);
		}
		return -1;
	}
	private static Set<Integer> inorderKeySet(MyEntry node){
		Set<Integer>set=inorderKeySet(node.left);
		if(node!=null) {
			Set<Integer>left=inorderKeySet(node.left);
			Set<Integer>right=inorderKeySet(node.right);
			set.addAll(left);
			set.add(node.key);
			set.addAll(right);
		}	
		return set;
	}
	public boolean containsKey(int key) {
		return get(key)!=-1;
	}
}
