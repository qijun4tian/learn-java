package 动态规划;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author:qijun
 * @Description
 * @Date 14:37 2022/1/22
 */
public class 目标和 {

    public static int findTargetSumWays1(int[] nums, int target) {
        int count = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(0);
        for (int i = 0; i <= nums.length - 1; i++) {
            int size = deque.size();
            for (int i1 = 0; i1 < size; i1++) {
                Integer pop = deque.pop();
                if (i == nums.length - 1) {
                    if (target == (pop - nums[i])) {
                        count++;
                    }
                    if (target == (pop + nums[i])) {
                        count++;
                    }
                } else {
                    deque.add(pop - nums[i]);
                    deque.add(pop + nums[i]);
                }
            }

        }

        return count;

    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};

        System.out.println(findTargetSumWays(nums, 1));


    }

    public static int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[nums.length - 1] == target || nums[nums.length - 1] == -target) {
                if (target == 0) {
                    return 2;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        }
        int length = nums.length;

        return findTargetSumWays(Arrays.copyOfRange(nums, 0, length - 1), target - nums[length - 1])
                + findTargetSumWays(Arrays.copyOfRange(nums, 0, length - 1), target + nums[length - 1]);


    }


}
