package 滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class 无重复字符的最长子串 {

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        int max = 0;
        while (right < chars.length){
            if (map.containsKey(chars[right])) {
                int oldLeft = left;
                left = map.get(chars[right]) + 1;
                for (int i = oldLeft; i < left; i++) {
                    map.remove(chars[i]);
                }
            }
            map.put(chars[right], right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;

    }

    //public static void main(String[] args) {
    //    String s = "abcabcbb";
    //    System.out.println(lengthOfLongestSubstring(s));
    //}

    /**
     * 更优解法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int r = 0, l = 0, res = 0;
        Set<Character> set = new HashSet<>();
        while (r < s.length()) {
            char c = s.charAt(r++);
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res, set.size());
        }
        return res;

    }

    public static boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[1].length;
        int length = word.length();
        for (int i = 0; i < m; i++) {
            int begin = -1;
            int end = -1;
            int k = 0;
            for (int j = 0; j < n && k < length; j++) {
                k = 0;
                begin = -1;
                end = -1;
                while (j< n  && k < length && (board[i][j] == ' ' || board[i][j] == word.charAt(k))){
                    if (begin == -1) {
                        begin = j;
                    }
                    end = j;
                    if(k == length -1){
                        if (begin == 0) {
                            if (end == n - 1) {
                                return true;
                            } else if (board[i][end + 1] == '#') {
                                return true;
                            }

                        } else if (board[i][begin - 1] == '#') {
                            if (end == n - 1) {
                                return true;
                            } else if (board[i][end + 1] == '#') {
                                return true;
                            }

                        }

                    }
                    j++;
                    k++;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int k = 0;
            int begin = -1;
            int end = -1;

            for (int i = 0; i < m; i++) {
                k = 0;
                begin = -1;
                end = -1;
                while (i < m && k < length &&  (board[i][j] == ' ' || board[i][j] == word.charAt(k))) {
                    if (begin == -1) {
                        begin = i;
                    }
                    end = i;
                    if (k == length -1) {
                        if (begin == 0) {
                            if (end == m - 1) {
                                return true;
                            } else if (board[end + 1][j] == '#') {
                                return true;
                            }

                        } else if (board[begin - 1][j] == '#') {
                            if (end == m - 1) {
                                return true;
                            } else if (board[end + 1][j] == '#') {
                                return true;
                            }

                        }
                    }
                    i++;
                    k++;
                }
            }

        }


        return false;
    }

    public static void main(String[] args) {
        char[][] chars = {{' '}, {'#'}, {'o'}, {' '}, {'t'}, {'m'}, {'o'}, {' '}, {'#'}, {' '}};
        String word =
                "octmor";

        System.out.println(placeWordInCrossword(chars, word));

    }

}
