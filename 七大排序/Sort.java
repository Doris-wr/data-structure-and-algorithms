package �ߴ�����;

import java.util.Arrays;
import java.util.Random;
import ��.Heap;

public class Sort {
	//��������
	public static void insertSort0(int[] a) {
		for(int i=1;i<a.length;i++) {//��������
			int key=a[i];
			int j;
			for(j=i-1;j>=0;j--) {//��������
				if(a[j]<=key) {
					break;
				}else {
					a[j+1]=a[j];
				}
			}
			a[j+1]=key;
		}
	}
	public static void insertSort1(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			//����[0��i)
			// ����[i��array��length)
			int key=arr[i];
			int j;
			for(j=i-1;j>=0&&arr[j]>key;j--) {
				arr[j+1]=arr[j];
			}
		arr[j+1]=key;
	    }
	}
	//�۰��������
	public static void bsInsertSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int v=arr[i];
			int left=0;
			int right=arr.length;
			while(left<right) {
				int m=(left+right)/2;
				if(v>=arr[m]) {
					left=m+1;
				}else {
					right=m;
				}
			}
			for(int j=i;j>left;j--) {
				arr[j]=arr[j-1];
			}
			arr[left]=v;
		}
	}
	
	//�����ٶ�
	public static void testSpeed() {
		Random random=new Random(20190924);
		int[] a=new int[5*1000];
		for(int i=0;i<5*1000;i++) {
			a[i]=random.nextInt(10*1000);
		}
		long begin=System.nanoTime();
		insertSort1(a);
		long end=System.nanoTime();
		double ms=(end-begin)*1.0/1000/1000;
		System.out.printf("һ����ʱ��%5f����%n",ms);
	}
	//ϣ������
	public static void shellSort(int[] arr) {
		int gap=arr.length;
		while(true) {
			gap=(gap/3)+1;
			insertSortWithGap(arr,gap);
			if(gap==1) {
				break;
			}
		}
	}
	public static void insertSortWithGap(int[] arr,int gap) {
		for(int i=gap;i<arr.length;i++) {
			int key =arr[i];
			int j;
			for(j=i-gap;j>=0&&arr[j]>key;j-=gap) {
				arr[j+gap]=arr[j];
			}
			arr[j+gap]=key;
		}
	}
	//ѡ�����򷨣�ÿ�������ķ���������������
	public static void selectSort1(int[] arr) {
		//����[0,array��length-i-1)
		//����[arr.length-i,arr.length)
		for(int i=0;i<arr.length-1;i++) {//���ѭ����ʾn����Ҫѡ��n-1������,�����������
			int maxIndex=0;
			for(int j=1;j<arr.length-i;j++) {//�ڲ�ѭ����ʾ����������������
				if(arr[j]<arr[maxIndex]) {
					maxIndex=j;
				}
			}
			swap(arr,maxIndex,arr.length-1-i);
		} 
	}
	//ѡ�����򷨣�ÿ������С����ǰ��
	public static void selectSort2(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			//��������[i,array.lenght)
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			swap(arr,minIndex,i);
		}	
	}
	//����
	public static void swap(int[] arr,int i,int j) {
		int t=arr[i];
		arr[i]=arr[j];
		arr[j]=t;
	}
	//˫��ѡ������
	public static void selectSort3(int[]arr) {
		int begin=0;
		int end=arr.length;
		while(begin<end) {
			int minIndex=begin;
			int maxIndex=end;
			for(int j=begin+1;j<end;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
				if(arr[j]>arr[maxIndex]) {
					maxIndex=j;
				}
			}
			swap(arr,minIndex,begin);
			if(maxIndex==begin) {
				maxIndex=minIndex;
			}
			swap(arr,maxIndex,end);
		}
	}
	//ð������
	public static void BubbleSort(int[] arr) {
		
	}
	//������
	public static void heapSort(int[] arr) {
		Heap.creatHeapBig(arr, 0);
		for(int i=0;i<arr.length-1;i++) {
			//����[0,array,length-i]
			//����array[0],array[length-i-1]
			//����[0,array.length-i-1]
			//���򳤶ȣ�array.length-i-1
			//�±�0�������µ���
			Heap.swap(arr,0,arr.length-1);
			Heap.shiftDownBig(arr,arr.length-i-1,0);
		}
		
	}
	public static void main(String[] args) {
		int[] a= {2,3,7,9,4,5,6,9,1,4,7,8};
		insertSort0(a);
		System.out.println(Arrays.toString(a));
		testSpeed();
		int[] b=a.clone();
		shellSort(a);
		System.out.println(Arrays.toString(a));
		testSpeed();
	}
}
