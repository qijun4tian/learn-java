package 字符串;

/**
 *
 * https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 * @author qijun
 * @date 2021/11/23 19:09
 */
public class 定长子串中元音的最大数目 {

    //（a, e, i, o, u）。

    public static int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        int left = 0;
        int max = 0;
        while (left <= length - k) {
            int temp = 0;
            for (int i = 0; i < k; i++) {

                if (chars[left + i] == 'a' ||
                        chars[left + i] == 'e' ||
                        chars[left + i] == 'i' ||
                        chars[left + i] == 'o' ||
                        chars[left + i] == 'u') {
                    temp++;

                }
            }
            max = Math.max(temp, max);
            left++;
        }
        return max;
    }
}
