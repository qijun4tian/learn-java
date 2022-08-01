package java;

/**
 * @author qijun
 * @Description
 * @Date 22:24 2022/4/20
 */
public class 字符的最短距离 {
    public int[] shortestToChar(String s, char c) {
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                a[i] = 0;

            } else {
                a[i] = -1;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                int length = 10000;
                int left = i - 1;
                int right = i + 1;
                while (left >= 0) {
                    if (a[left] == 0) {
                        length = Math.min(i - left, length);
                        break;
                    }
                    left--;
                }
                while (right < a.length) {
                    if (a[right] == 0) {
                        length = Math.min(right - i, length);
                        break;
                    }
                    right++;
                }
                a[i] = length;

            }
        }
        return a;
    }

}
