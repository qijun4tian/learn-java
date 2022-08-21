package java.递归;

/**
 * https://leetcode-cn.com/leetbook/read/recursion/46lfr/
 *
 * @Author:qijun
 * @Description
 * @Date 22:15 2021/12/13
 */
public class 第K个语法符号 {
    public static int kthGrammar1(int n, int k) {

        StringBuilder old = new StringBuilder();
        old.append("0");
        StringBuilder s1 = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            s1 = new StringBuilder();
            char[] chars = old.toString().toCharArray();
            for (char aChar : chars) {
                if (aChar == '0') {
                    s1.append("01");
                } else {
                    s1.append("10");
                }

            }
            old = s1;
        }

        return (old.charAt(k - 1) - '0');
    }

    public static int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        } else {
            if (k % 2 == 0) {
                if (kthGrammar((n - 1), (k + 1) / 2) == 1) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (kthGrammar((n - 1), (k + 1) / 2) == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

    }
}



