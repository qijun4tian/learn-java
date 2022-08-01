package 其他;

/**
 * @Author:qijun
 * @Description
 * @Date 9:59 2021/12/12
 */
public class 颠倒二进制位 {
    /**
     * 解法1 我自己的
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        boolean isNum = false;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if(i == 0) {
                if((n & 1) == 1){
                    isNum = true;
                }
                n = n >>> 1;
                continue;
            }
            if(!isNum){
                if((n & 1) == 1) {
                    result += Math.pow(2,31-i);
                }
            }else {
                if((n & 1) == 0){
                    result += Math.pow(2,31-i);
                }
            }
            n = n >>> 1;
        }
        if(isNum){
            result = -(result + 1);
        }
        return (int)result;
    }

    //public static void main(String[] args) {
    //    System.out.println((Integer.MAX_VALUE + 1));
    //    System.out.println(-(Integer.MAX_VALUE + 1));
    //    System.out.println(Integer.MIN_VALUE);
    //    System.out.println(reverseBits(1));
    //}

    /**
     * 解法2
     * @param n
     * @return
     */
    public static int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result | ((n & 1) << (31 -i));
            n = n >>> 1;
        }
        return result;

    }

    public static void main(String[] args) {
        int a = 0b00000010100101000001111010011100;
        reverseBits1(a);
    }


}
