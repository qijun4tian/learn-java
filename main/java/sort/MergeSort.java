package sort;

/**
 * Created by qijun123 on 2017/8/30.
 */
public class MergeSort {

    public static void mergeArray(int a[],int begin,int middle,int end,int temp[]){

        int i =begin;
        int j = middle+1;
        int k = 0;
        while(i<=middle && j<=end){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }
            else
            {
                temp[k++] = a[j++];
            }
        }
        while(i<=middle){
            temp[k++] = a[i++];
        }

        while (j<=end){
            temp[k++]= a[j++];
        }
        // FIXME: 2017/8/30 i<k not i<=k ,k is already +1,out of range
        for(i=0;i<k;i++){
            a[begin+i] = temp[i];
        }

    }

    public static void mergeSort(int a[],int begin,int end,int temp[]){

        if(begin< end){
            int middle = (begin + end)/2;
            mergeSort(a,begin,middle,temp);
            mergeSort(a,middle+1,end,temp);
            mergeArray(a,begin,middle,end,temp);


        }

    }
    public static void main(String[] args) {


//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        completableFuture.com
    }

}
