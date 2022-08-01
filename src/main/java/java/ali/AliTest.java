package java.ali;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 求数组连续子数组之和等于某个数的最短数组
 */
public class AliTest {


    public static List<Integer> getLeastList(List<Integer> nums, Integer s) {
        Integer temp = 0;
        Map<Integer, Integer> result = new HashMap<>();
        Integer minLength = nums.size();
        for (int i = 0; i < nums.size(); i++) {
            temp = nums.get(i);
            if (temp >= s) {
                result.put(i, i);
                minLength = 0;
                continue;
            }
            for (int j = i + 1; j < nums.size(); j++) {
                temp = temp + nums.get(j);
                if (temp >= s) {
                    result.put(i, j);
                    if (j - i < minLength) {
                        minLength = j - i;
                    }
                    break;
                }
            }

        }
        if (result.isEmpty()) {
            return null;
        }
        int start = 0;
        int end = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            Integer size = entry.getValue() - entry.getKey();
            if (size.equals(minLength)) {
                start = entry.getKey();
                end = entry.getValue();
                break;
            }
        }

        return nums.subList(start, end + 1);

    }

    //public static void main(String[] args) {
    //    List<Integer> list = Arrays.asList(2, 3, 1, 2, 4, 3);
    //
    //    List<Integer> list1 = getLeastList(list, 9);
    //
    //    if (!list.isEmpty()) {
    //        for (Integer integer : list1) {
    //            System.out.println(integer);
    //        }
    //    }
    //    Semaphore s = new Semaphore(3);
    //}

    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int a = -1;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int left = i;
            int right = i;
            int result = 0;
            int tempSize = -1;
            while (right < length) {
                result += nums[right];
                if (result > target) {
                    tempSize = right - left + 1;
                    break;
                }
                right++;

            }
            while (left <= right) {
                result -= nums[left];
                if (result < target) {
                    break;
                }
                tempSize--;
                left++;
            }
            if (tempSize >= 1) {
                minSize = Math.min(minSize, tempSize);
            }


        }
        return Math.min(0, minSize);


    }


    public static int maxRotateFunction(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length - 1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int i = 0; i <= length; i++) {

            max = max + i * nums[i];
        }


        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        System.out.println(maxRotateFunction(nums));
    }

}
