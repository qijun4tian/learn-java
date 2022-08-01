package java.其他;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 *
 * @author qijun
 * @Description
 * @Date 22:56 2022/4/26
 */
public class 三次操作后最大值与最小值的最小差 {
    public static int minDifference(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 4) {
            return 0;
        }
        int ret = Integer.MAX_VALUE;
        int length = nums.length;

        // 2 1 0
        for (int i = 0; i <= 3; i++) {
            ret = Math.min(ret, nums[length - 4 + i] - nums[i]);
        }

        return ret;

    }

    public static void main(String[] args) {
        int a[] = {1, 5, 0, 10, 14};
        int i = minDifference(a);

    }

}
