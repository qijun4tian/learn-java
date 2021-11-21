package 数组;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @Author:qijun
 * @Description
 * @Date 21:29 2021/11/20
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();

    }

}
