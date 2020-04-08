package 二叉树;

import java.util.*;
public class BineryTree2 {
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val=x;
		}
		public String toString() {
			return String.format("{%s}",val);
		}
	}
	//根据前序，中序序列创建二叉树
	public TreeNode buildTree(int[] preorder,int[] inorder) {
		if(preorder.length==0) {
			return null;
		}
		int rootValue=preorder[0];
		int leftCount;
		for(leftCount=0;leftCount<inorder.length;leftCount++) {
			if(inorder[leftCount]==rootValue) {
				break;
			}
		}
		TreeNode root=new TreeNode(rootValue);
		int[] leftpreorder=Arrays.copyOfRange(preorder,1, 1+leftCount);
		int[] leftInorder=Arrays.copyOfRange(inorder,0,leftCount);
		root.left=buildTree(leftpreorder, leftInorder);
		int[] rightPreorder=Arrays.copyOfRange(preorder,1+leftCount,preorder.length);
		int[] rightInorder=Arrays.copyOfRange(inorder,leftCount+1,inorder.length);
		root.right=buildTree(rightPreorder, rightInorder);
		return root;
	}
	//根据中序，后序序列创建二叉树
	public TreeNode buildTree2(int[] i,int[] p) {
		if(i.length==0) {
			return null;
		}
		int r=p[p.length-1];
		int lc=index(i,r);
		TreeNode root=new TreeNode(r);
		int[] li=Arrays.copyOfRange(i,0,lc);
		int[] lp=Arrays.copyOfRange(p,0,lc);
		root.left=buildTree2(li, lp);
		int[] ri=Arrays.copyOfRange(i,lc+1,i.length);
		int[] rp=Arrays.copyOfRange(p,lc,p.length);
		root.right=buildTree2(ri, rp);
		return root;
	}
	private int index(int[] a,int r) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==r) {
				return i;
			}
		}
		return -1;
	}
	//利用前序集合，中序集合创建二叉树
	public TreeNode buildTree3(List<Integer>preorder,List<Integer>inorder) {
		if(preorder.isEmpty()) {
			return null;
		}
		int rootValue=preorder.get(0);
		int leftCount=inorder.indexOf(rootValue);
		TreeNode root=new TreeNode(rootValue);
		List<Integer>leftPre=preorder.subList(1,1+leftCount);
		List<Integer>leftIn=inorder.subList(0,leftCount);
		root.left=buildTree3(leftPre,leftIn);
		List<Integer>rightPre=preorder.subList(1+leftCount,preorder.size());
		List<Integer>rightIn=inorder.subList(leftCount+1,inorder.size());
		root.right=buildTree3(rightPre,rightIn);
		return root;
	}
	//根据前序序列创建二叉树
	private static class BTRV{
		private TreeNode root;
		private int used;
	}
	BTRV buildTree4(List<Integer>preorder) {
		BTRV returnValue=new BTRV();
		if(preorder.size()==0) {
			returnValue.root=null;
			returnValue.used=0;
			return returnValue;
		}
		int rootValue=preorder.get(0);
		if(rootValue=='#') {
			returnValue.root=null;
			returnValue.used=1;
			return returnValue;
		}
		BTRV leftReturn=buildTree4(preorder.subList(1,preorder.size()));
		BTRV rightReturn=buildTree4(preorder.subList(1+leftReturn.used,preorder.size()));
		TreeNode root =new TreeNode(rootValue);
		root.left=leftReturn.root;
		root.right=rightReturn.root;
		returnValue.root=root;
		returnValue.used=1+leftReturn.used+rightReturn.used;
		return returnValue;
	}
}
