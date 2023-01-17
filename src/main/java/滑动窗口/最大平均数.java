package 滑动窗口;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 *
 //* 643. 子数组最大平均数 I
 //* 给定 n个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 //* 示例：
 //* 输入：[1,12,-5,-6,50,3], k = 4
 //* 输出：12.75
 //* 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * @author qijun
 * @date 2023/1/17 15:51
 */
public class 最大平均数 {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,12,-5,-6,50,3);
        int[] a = {1,12,-5,-6,50,3};
        int k = 4;

        System.out.println(biggestAverage(4, a));



    }

    public static BigDecimal biggestAverage(int k, int[] a){
        int left = 0;
        int right = 0;
        int total = a[0];
        BigDecimal ave = new BigDecimal(Integer.MIN_VALUE);
        while (right - left + 1 < k && right < a.length -1){
            total += a[++right];

            if(right - left == k -1){
                BigDecimal temp = new BigDecimal(total).divide(new BigDecimal(k), 2, BigDecimal.ROUND_HALF_UP);
                ave = temp.compareTo(ave)  > 0 ? temp : ave;
                total -= a[left];
                left++;

            }
        }
        return ave;


    }




}
