package sort;


/**
 * Created by qijun123 on 2017/8/30.
 * <p>
 * 2021-06-27 再次修改训练此排序
 */
public class QuickSort1 {


    public static int parttion(int a[], int begin, int end) {
        int i = begin - 1;
        int flag = a[end];
        for (int j = begin; j < end; j++) {
            if (a[j] < flag) {
                i++;
                swap(a, i, j);
            }
        }
        i++;
        swap(a, i, end);
        return i;
    }

    public static void quickSort(int a[], int begin, int end) {
        if (begin < end) {
            int middle = parttion(a, begin, end);
            quickSort(a, begin, middle - 1);
            quickSort(a, middle + 1, end);

        }
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static void main(String[] args) {

        int[] array = {36, 90, 9, 17, -4};
        quickSort(array, 0, 4);

        for (int i : array) {
            System.out.println(i);
        }


    }
}
