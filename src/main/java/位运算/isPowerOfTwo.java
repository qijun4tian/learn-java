package 位运算;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class isPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {

        int num = 0;
        while(n > 0){
            if((n & 1) == 1){
                num ++;
            }
            if(num > 1){
                return false;
            }
            n = n>>1;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(9));
    }
}
