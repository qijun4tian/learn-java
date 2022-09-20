package 其他;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qijun
 * @Description
 * @Date 20:30 2022/6/12
 */
public class EatBanana {

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        long sum = 0;
        for (int p : piles) {
            sum += p;
        }
        int start = (int) (sum % h == 0 ? sum / h : (sum / h + 1));
        int end = piles[piles.length - 1];

        int least = start;
        while (start <= end) {
            int middle = (end - start) / 2 + start;
            System.out.println("middle" + middle);
            int hour = eatHour(piles, middle);
            if (hour <= h) {
                end = middle - 1;
                least = middle;
            } else {
                start = middle + 1;
            }
        }
        return least;


    }

    public int eatHour(int[] piles, int speed) {
        System.out.println(speed);
        int hour = 0;
        for (int p : piles) {
            if (p <= speed) {
                hour += 1;
            } else {
                int yu = p % speed;
                int shan = p / speed;
                int pHour = yu == 0 ? shan : shan + 1;
                hour += pHour;
            }
        }
        return hour;

    }

    public static void main(String[] args) {
        EatBanana eatBanana = new EatBanana();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(eatBanana.minEatingSpeed(new int[]{980628391, 681530205, 734313996, 168632541},
                819870953));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int[] a = new int[2];
        //a.
    }
}
