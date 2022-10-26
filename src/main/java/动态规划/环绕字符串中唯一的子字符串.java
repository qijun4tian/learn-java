package 动态规划;

import java.util.Arrays;

/**
 * @author qijun
 * @Description
 * @Date 22:21 2022/5/26
 */
public class 环绕字符串中唯一的子字符串 {

    public int findSubstringInWraproundString(String p) {
        int[] a = new int[26];
        int i = 0;
        Character last = null;
        int length = 0;
        while (i < p.length()) {
            char now = p.charAt(i);
            int pos = now - 'a';
            if (last != null) {
                if ((last == 'z' && now == 'a') || (now - last == 1)) {
                    length++;
                    if (a[pos] < length) {
                        a[pos] = length;
                    }

                } else {
                    if (a[pos] == 0) {
                        a[pos] = 1;
                    }
                    length = 1;
                }

            } else {
                a[pos] = 1;
                length++;

            }
            last = now;
            i++;

        }
        return Arrays.stream(a).reduce(0, Integer::sum);

    }
}
