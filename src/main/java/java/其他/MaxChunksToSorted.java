package 其他;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        TreeMap<Integer, List<Integer>> set = new TreeMap();
        int[] arr1 = new int[arr.length];
        for(int i =0; i < arr.length; i++){
            arr1[i] = arr[i];

        }
        Arrays.sort(arr1);
        for(int i =0; i < arr1.length; i++){
            set.putIfAbsent(arr1[i],new ArrayList());
            set.get(arr1[i]).add(i);
        }
        int count = 0;
        for(int i =0; i < arr.length; i++){
            if(arr1[i] != arr[i]){
                int temp = arr[i];
                int index = set.get(temp).get(0) + 1  - i;
                int subCount = 1;

                for(int j = i + 1; j<arr.length; j++){
                    if(arr[j] < temp){
                        subCount++;
                    }
                    else if(arr[j] == temp){
                        temp = arr[j];
                        index++;
                        subCount++;
                    }else{
                        temp = arr[j];
                        index = set.get(arr[j]).get(0) + 1- i ;
                        subCount++;
                    }

                    if(subCount == index){
                        i = j;
                        break;
                    }

                }

                count++;
            }else{
                count++;
            }


        }
        return count;

    }


    public static void main(String[] args) {
        MaxChunksToSorted maxChunksToSorted = new MaxChunksToSorted();
        System.out.println(maxChunksToSorted.maxChunksToSorted(new int[]{0,4,5,2,1,3}));;
    }
}
