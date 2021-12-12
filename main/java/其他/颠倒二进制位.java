package 其他;

/**
 * @Author:qijun
 * @Description
 * @Date 9:59 2021/12/12
 */
public class 颠倒二进制位 {

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

    public static void main(String[] args) {
        System.out.println((Integer.MAX_VALUE + 1));
        System.out.println(-(Integer.MAX_VALUE + 1));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverseBits(1));
    }


}
