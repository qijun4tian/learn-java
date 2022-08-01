package 其他;

/**
 * @Author:qijun
 * @Description
 * @Date 22:20 2021/12/9
 */
public class 缺失数字 {
    public int missingNumber(int[] nums) {
        int all = nums.length * (nums.length -1) /2;
        int result2 = 0;
        for (int num : nums) {
            result2 += num;
        }
        return all - result2;

    }
}
