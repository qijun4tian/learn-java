package java.数组;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 * @Author:qijun
 * @Description
 * @Date 16:14 2021/11/21
 */
public class 移动零 {

    public void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] == 0){
                for(int j = i + 1;  j < nums.length;j++){
                    if(nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }

            }

        }

    }
}
