package sort;

/**
 *
 */
public class BubbleSort {
    public static void BubbleSort(int a[]){
        int length = a.length;
        for(int i=0; i< length -1; i++){
            for (int j = 0; j < length -i -1;  j++){
                if(a[j] > a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1,2,5,10,19,-1,11,-10};
        BubbleSort(a);
        for (int i : a) {
            System.out.println(i);
        }

    }
}
