package Æß´óÅÅÐò;
public class MergeSort {
	public static void mergeSort(int[]arr,int low,int high) {
		
	}
	public static void mergeSortInter(int[] arr,int low,int high) {
		 if(low>=high) {
			 return;
		 } 
		 int mid=(low+high)/2;
		 mergeSortInter(arr, low, high);
		 mergeSortInter(arr,mid,high);
		 merge(arr,low,mid,high);
	}	 
	
	private static void merge(int[] a,int low,int mid,ppint high) {
		int length=high-low;
		int extra[]=new int[length] ;
		int i=low;
		 int j=high;
		 int k=0;
		 while(i<mid&&j<high) {
			 if(a[i]<=a[j]) { 
				 extra[k++]=a[j++];
			 }else {
				 extra[k++]=a[j++];
			 }
		 }
	}
}
