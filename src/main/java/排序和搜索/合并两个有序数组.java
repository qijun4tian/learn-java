package 排序和搜索;

import java.util.Arrays;

/**
 * @Author:qijun
 * @Description
 * @Date 16:14 2021/11/27
 */
public class 合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        int[] temp = Arrays.copyOf(nums1,m);
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if(temp[i] < nums2[j]){
                nums1[k] = temp[i];
                i++;
            }else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        if(i == temp.length){
            for(int begin = j; begin < nums2.length; begin ++){
                nums1[k++] = nums2[begin];
            }
        }else {
            for(int begin = i; begin < temp.length; begin ++){
                nums1[k++] = temp[begin];
            }

        }
    }


}
