package java.数学;

/**
 * @author qijun
 * @Description
 * @Date 23:16 2022/4/23
 */
public class 旋转函数 {
    public int maxRotateFunction(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 0;
        int f0 = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            f0 = f0 + i * nums[i];
            sum += nums[i];
        }
        System.out.println("sum=" + sum);
        result = f0;

        for (int i = 1; i < nums.length; i++) {
            System.out.println("f0=" + f0);
            f0 = f0 + sum - nums.length * nums[nums.length - i];

            result = Math.max(result, f0);

        }
        return result;

    }
}
