package multithreading;

/**
 * @author qijun
 * @Description
 * @Date 21:50 2022/4/21
 */
public class AAA {


    public static void main(String[] args) {
        Integer a = 8;
        int height = 0;
        int sub = 2;
        while (a > 0) {
            a = a - (int) Math.pow(2, height);
            height++;
        }
        System.out.println(height);

    }
}
