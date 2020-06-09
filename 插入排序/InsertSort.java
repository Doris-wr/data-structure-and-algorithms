package 插入排序;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:wangrui
 * @Date:2020/6/9 22:27
 */
public class InsertSort {
    public static void sort (int[] a){
        //将数组a按升序排列
        for(int i=1;i<a.length;i++){
            //将a[i]插入到a[i-1],a[i-2],a[i-3]……之中
            for(int j=i;j>0&&a[j]<a[j-1];j--){
                int tmp=a[j];
                a[j]=a[j-1];
                a[j-1]=tmp;
            }
        }
     }
    public static void main(String[] args) {
        int []arr=new int[]{4,9,2,0,6,5,8,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
