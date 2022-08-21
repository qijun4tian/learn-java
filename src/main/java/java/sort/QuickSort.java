package java.sort;

import java.util.Arrays;

/**
 * Created by qijun123 on 2017/8/30.
 */
public class QuickSort {




    public static int parttion(int a[],int begin,int end){
        // 记录的上一个比中间值小的位置
       int i = begin - 1;
       int flag = a[end];
       for(int j = begin;j<end;j++){
           if(a[j]<flag){
               i = i +1;
               int temp =a[i];
               a[i] = a[j];
               a[j] = temp;
           }
       }
       i = i+1;
       a[end] = a[i];
       a[i] = flag;
       return i;

    }

    public static void quickSort(int a[],int begin,int end){
        // 递归
        if(begin<end){
            int middle = parttion(a,begin,end);
            quickSort(a,begin,middle-1);
            quickSort(a,middle+1,end);
        }
    }

    public static void main(String[] args) {

        int [] array = {98,36,9,17,-4};
        quickSort(array,0,4);

        Arrays.stream(array).forEach(System.out::println);

    }
}
