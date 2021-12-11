package 设计问题;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author:qijun
 * @Description
 * @Date 19:07 2021/12/11
 */
public class Solution {

    private int[] reset;

    private boolean[] booleans;
    public Solution(int[] nums) {
        reset = nums;

    }

    public int[] reset() {
        return reset;
    }

    public int[] shuffle() {
        booleans = new boolean[reset.length];
        int[] newArray = Arrays.copyOf(reset,reset.length);
        Random random = new Random();
        for (int i = 0; i < reset.length; i++) {
            int randomI = -1;
            do{
                randomI = random.nextInt(reset.length);

            }while (booleans[randomI]);
            booleans[randomI] = true;
            newArray[i] = reset[randomI];
        }
        return newArray;


    }


}
