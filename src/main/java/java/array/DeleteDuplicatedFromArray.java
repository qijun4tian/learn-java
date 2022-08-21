package java.array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class DeleteDuplicatedFromArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int a = 0;
        int length = nums.length;
        int i = 0;
        while (i < length - 1) {
            a = nums[i];
            int j = i;
            while (j + 1 < length && a == nums[j + 1]) {
                j++;
            }
            if (j > i) {
                int duplicateSize = j - i;
                for (int k = j + 1; k < length; k++) {
                    nums[k - duplicateSize] = nums[k];
                }
                length = length - duplicateSize;
            }
            i++;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicatesByTwoPoint(a));
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 判断第几个不同，把第几个往前面移动，再已经存放了最大值时跳出循环
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int length = nums.length;
        int count = 1;
        int start = 1;

        for (int j = 0; j < length && nums[j] < nums[length - 1]; j++) {

            for (int k = start; k < length; k++) {
                if (nums[k] != nums[j]) {
                    nums[j + 1] = nums[k];
                    start = k;
                    count++;
                    break;

                }
            }
        }
        return count;
    }

    /**
     * 双指针删除
     *
     * @param nums
     * @return
     */
    public static int removeDuplicatesByTwoPoint(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }


}
