package 回文;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * @author:qijun
 * @Description
 * @Date 22:54 2022/4/6
 */
public class 最长回文串 {
    public static int longestPalindrome(String s) {
        int length = s.length();
        int size = 0;
        boolean[] a = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (a[i]) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && !a[j]) {
                    size += 2;
                    a[j] = true;
                    break;
                }
            }
        }
        return size < length ? size + 1 : size;

    }

    public static void main(String[] args) {
        longestPalindrome("abccccdd");
    }


    public int longestPalindrome1(String s) {
        int a[] = new int[128];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)] += 1;

        }
        int length = 0;
        for (int i = 0; i < 128; i++) {
            length = length + (a[i] % 2 == 0 ? a[i] : (a[i] - 1));
        }
        return length == s.length() ? length : length + 1;

    }

}
