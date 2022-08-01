package 数学;

/**
 * 使用二分法
 *
 * @author:qijun
 * @Description
 * @Date 18:08 2022/1/9
 */
public class 完全平方数 {

    public boolean isPerfectSquare(int num) {
        int begin = 1;
        int end = num;
        while (begin <= end) {
            int middle = begin + (end - begin) / 2;
            double pow = Math.pow(middle, 2);
            //long temp = (long) middle * middle;
            if (pow == num) {
                return true;
            }
            if (pow > num) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(9));


    }
}
