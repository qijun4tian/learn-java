package search.二分;

/**
 * @author qijun
 * @Description
 * @Date 23:47 2022/5/13
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] == target) {
                int k = middle;
                int j = middle;
                while (k - 1 >= 0 && nums[k - 1] == target) {
                    k--;
                }
                while (j + 1 <= nums.length - 1 && nums[j + 1] == target) {
                    j++;
                }
                result[0] = k;
                result[1] = j;
                break;

            } else {
                right = middle - 1;
            }

        }

        return result;

    }
}
