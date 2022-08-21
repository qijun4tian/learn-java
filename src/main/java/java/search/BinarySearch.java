package java.search;

/**
 * 二分查找
 */
public class BinarySearch {

    public int search(int a[], int value) {
        int start = 0;
        // 必须减1
        int end = a.length - 1;
        int middle = 0;
        while (start <= end){
            middle = start + (end -start)/2;
            if(a[middle] == value){
                return middle;
            } else if(a[middle] < value){
                start = middle +1;
            }else {
                end = middle -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(a,8));


    }
}
