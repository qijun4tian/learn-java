package java.递归;

/**
 * @Author:qijun
 * @Description
 * @Date 16:10 2021/12/19
 */
public class myPow {

    public static double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        double result = 1;
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            for (int i = 0; i < n; i++) {
                result = result * x;

            }
        } else {
            long n1 = -n;
            if (n == Integer.MIN_VALUE) {
                n1 = 1L << 31;
            }
            for (long i = 0; i < n1; i++) {
                if (result == new Double("0.0")) {

                    return result;
                }
                result = result * (1 / x);

            }
            return result;
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(myPow(2.0, -2147483648));

        double a = 1.0d;
        double b = 1.00d;
        System.out.println(a == b);
    }


}
