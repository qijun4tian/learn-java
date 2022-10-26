package 双指针;

/**
 * https://leetcode.cn/problems/one-away-lcci/
 *
 * @author qijun
 * @Description
 * @Date 23:01 2022/5/13
 */
public class 一次编辑 {
    public boolean oneEditAway(String first, String second) {
        int k = 0;
        int j = 0;
        int diff = 0;
        while (k < first.length() || j < second.length()) {
            if (k < first.length() && j < second.length()) {
                if (first.charAt(k) != second.charAt(j)) {
                    if (first.length() > second.length()) {
                        k++;
                    } else if (first.length() < second.length()) {
                        j++;
                    } else {
                        k++;
                        j++;
                    }
                    diff++;
                } else {
                    k++;
                    j++;
                }
            } else if (k < first.length() && j >= second.length()) {
                k++;
                diff++;
            } else if (k >= first.length() && j < second.length()) {
                j++;
                diff++;
            }
            if (diff >= 2) {
                return false;
            }


        }
        return diff < 2;

    }
}
