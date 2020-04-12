package 堆;

import java.util.Arrays;
import java.util.Random;

public class Heap {
	//向下调整为小堆
	public static void shiftDownSmall(int[] arr,int index,int size) {
		int left=2*index+1;
		while(left<size) {
			int min=left;
			int right=left+1;
			if(right<size) {
				if(arr[right]<arr[left]) {
					min=right;
				}
			}
			if(arr[index]>arr[min]) {
				swap(arr,index,min);
				index=min;
				left=2*index+1;
			}else {
				break;
			}
		}
	}
	
	//向下调整为大堆
	public static void shiftDownBig(int[] arr,int index,int size) {
		while(2*index+1<size) {
			int m=2*index+1;
			if(m+1<size&&arr[m+1]>arr[m]) {
				m++;
			}
			if(arr[index]>=arr[m]) {
				break;
			}else {
				swap(arr,index,m);
				index=m;
			}
		}
	}
	
	//交换
	public   static void swap(int[] arr,int i,int j) {
		int t=arr[i];		
		arr[i]=arr[j];
		arr[j]=t;
	}
	//建小堆
	public static void creatHeapSmall(int[] a,int s) {
		for(int i=(s-2)/2;i>=0;i--) {
			shiftDownSmall(a,i,s);
		}
	}
	//建大堆
	public static void creatHeapBig(int[] a,int s) {
		for(int i=(s-2)/2;i>=0;i--) {
			shiftDownBig(a,i,s);
		}
	}
	public static void shiftUpSmall(int[]arr,int i) {
		while(i!=0) {
			int p=(i-1)/2;
			if(arr[p]<=arr[i]) {
				break;
			}
			swap(arr, p,i);
			i=p;
		}
	}
	//堆排序（选择排序）
	public static void heapSort(int[] arr) {
		creatHeapBig(arr,arr.length);
		for(int i=0;i<arr.length-1;i++) {
			swap(arr,0,arr.length-i-1);
			shiftDownBig(arr,0,arr.length-i-1);
		}
	}
	public static void main(String[] args) {
		int[] small= {39,15,3,18,40,5,6,51,52,70};
		shiftDownSmall(small,0,small.length);
		System.out.println(Arrays.toString(small));
		int[] big= {100,50,30,25,40,80,70,10,5,20,30,60,70,60,70,5};
		shiftDownBig(big,2,big.length);
		System.out.println(Arrays.toString(big));
		//创建小堆
		int[] t= new int[10];
		Random random =new Random(20190922);
		for(int i=0;i<10;i++) {
			t[i]=random.nextInt(20);
		}
		System.out.println(Arrays.toString(t));
		creatHeapSmall(t,t.length);	
		System.out.println(Arrays.toString(t));
		int[] a= {9,4,1,3,7,1,2,2,9,8};
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}
}

