package 其他;

/**
 * @author qijun
 * @Description
 * @Date 13:07 2022/6/11
 */
public class Boomerang {
    public boolean isBoomerang(int[][] points) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (points[i][0] == points[j][0]
                        && points[i][1] == points[j][1]) {
                    System.out.print("1111111111");
                    return false;
                }

            }
        }
        int xa = Math.abs(points[1][0] - points[0][0]);
        int ya = Math.abs(points[1][1] - points[0][1]);
        int xb = Math.abs(points[2][0] - points[1][0]);
        int yb = Math.abs(points[2][1] - points[1][1]);
        int xc = Math.abs(points[2][0] - points[0][0]);
        int yc = Math.abs(points[2][1] - points[0][1]);

        int[] result1 = Fraction(ya, xa);
        System.out.println(result1[0]);
        System.out.println(result1[1]);
        int[] result2 = Fraction(yb, xb);
        System.out.println(result2[0]);
        System.out.println(result2[1]);
        int[] result3 = Fraction(yc, xc);
        System.out.println(result3[0]);
        System.out.println(result3[1]);
        if (result1[0] == result2[0] && result1[1] == result2[1]
                && result3[0] == result2[0] && result3[1] == result2[1]) {
            System.out.print("11111111112");
            return false;
        }
        return true;


    }


    public int[] Fraction(int m, int n) {
        System.out.println("m=" + m);
        System.out.println("n=" + n);
        int[] result = new int[2];
        if (n == 0 || m == 0) {
            return result;
        }

        int temp = Math.min(m, n);
        result[0] = m;
        result[1] = n;
        while (temp >= 2 && result[0] > 1 && result[1] > 1) {
            if (result[0] % temp == 0 && result[1] % temp == 0) {
                result[0] = result[0] / temp;
                result[1] = result[1] / temp;
            }
            temp--;
        }
        return result;
    }

    public static void main(String[] args) {
        Boomerang boomerang = new Boomerang();
        int[][] points = {{0, 1}, {1, 1}, {2, 1}};
        String s = new String();
        //Arrays.sort();
    }
}
