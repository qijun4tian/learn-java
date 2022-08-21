package java.sort;

import java.util.Arrays;

/**
 * 插入排序
 * qijun 2021-06-27
 */
public class InsertSort {
    public static void insertSort(Comparable[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j >= 1 && a[j].compareTo(a[j - 1]) < 0) {
                swap(a, j, j - 1);
                j--;
            }

        }

    }


    public static void swap(Comparable a[], int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[5];
        a[0] = 1;
        a[1] = -1;
        a[2] = -12;
        a[3] = 12;
        a[4] = -5;
        insertSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

}
