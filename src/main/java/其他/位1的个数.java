package 其他;

/**
 * @Author:qijun
 * @Description
 * @Date 21:29 2021/12/3
 */
public class 位1的个数 {

    public int hammingWeight1(int n) {
        Integer i = new Integer(n);
        return Integer.bitCount(n);
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {

            if((n & 1) == 1){
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
