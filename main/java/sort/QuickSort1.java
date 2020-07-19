package sort;

import java.util.Arrays;

/**
 * Created by qijun123 on 2017/8/30.
 */
public class QuickSort1 {




    public static int parttion(int a[],int begin,int end){
        int i = begin -1;
        int flag = a[end];
        for(int j= begin; j <=end; j++ ){
            if(a[j]<flag){
                i = i +1;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        i++;
        a[end] = a[i];
        a[i] = flag;
        return i;

    }

    public static void quickSort(int a[],int begin,int end){
       if (begin <end){
           int middle = parttion(a,begin,end);
           quickSort(a,begin,middle-1);
           quickSort(a,middle + 1, end);
       }
    }

    public static void main(String[] args) {

        int [] array = {36,90,9,17,-4};
        quickSort(array,0,4);

        Arrays.stream(array).forEach(System.out::println);

    }
}
