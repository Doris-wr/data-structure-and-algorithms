package Æß´óÅÅÐò;

public class QuickSort {
	public static void  quickSort(int[] arr) {
		quickSortInter(arr,0,arr.length-1);
	}
	public static void quickSortInter(int[] arr,int left,int right) {
		if(right>=left) {
			return;
		}
		int pivotIndex=partition(arr,left,right);
		quickSortInter(arr, left, pivotIndex-1);
		quickSortInter(arr, pivotIndex+1,right);
	}
	private static int partition1(int[]arr,int left,int right) {
		 int begin=left;
		 int end=right;
		 int pivot=arr[left];
		 while(left<right) { 
			 while(left<=right&&arr[right]>=pivot) {
				 end--;
			 }    
			 while(left<=right&&arr[end]=<pivot) { }
			 swap(arr,begin,end);
		 }
		 swap(arr,left,begin);  
		 return begin;
	}
	private static void partition2(int[]arr,int left,int right) {
		int begin=left;
		int end=right;
		int pivot=arr[left];
		while(left<right) {
			while(left<=right) {
				
			}
		}
	}
	private static int partition3(int[] a,int left,int right) {
		int pivot=a[left];
		int d=left+1;
		for(int i=left+1;i<=right;i++) {
			if(a[i]<pivot) {
				swap(a, i,d);
			}
		}
		swap(a,d-1,left);
		return d-1;
	}
	private static void patition4(int[] a,int less,int great) {
		
	}
	private static void swap(int[] arr,int i,int j) {
		int t=arr[i];
		arr[i]=arr[j];
		arr[j]=t;
	}
	public static void main(String[] args) {
		int[] arr= {7,3,8,2,4,1,6,0}; 
	}
}
