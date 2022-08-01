package java.doublepointer;

/**
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @author qijun
 * @date 2021/7/22 18:52
 *
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class leecode680 {


    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j= chars.length -1;
        while (i < j){
            if(chars[i] != chars[j]){
                return validPalindrome(chars, i+1,j) || validPalindrome(chars,i,j-1);
            }
            i++;
            j--;
        }


        return true;
    }

    public static boolean validPalindrome(char[] s, int i, int j){
        while (i < j){
            if(s[i] != s[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcc12ba";
         validPalindrome(s);
    }
}
