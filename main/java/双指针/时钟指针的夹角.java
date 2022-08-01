package 双指针;

/**
 * @author qijun
 * @Description
 * @Date 21:28 2022/4/20
 */
public class 时钟指针的夹角 {
    public static double angleClock(int hour, int minutes) {
        double min = minutes * 6;

        double hourm = (hour % 12) * 30 + (minutes / 60.0) * 30;
        double a = Math.abs(hourm - min);
        return Math.min(a, 360 - a);

    }

    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
    }


}
