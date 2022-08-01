package java.字符串;

/**
 *
 * https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 * @author qijun
 * @date 2021/11/23 19:09
 */
public class 定长子串中元音的最大数目 {

    //（a, e, i, o, u）。

    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        int max = 0;
        for(int i = 0; i< k;i++){
            max += isYuanm(chars[i]);
        }
        int temp = max;
        for(int j = k; j< length; j++){

            temp -= isYuanm(chars[j-k]);
            temp += isYuanm(chars[j]);
            max = Math.max(temp,max);

        }
        return max;
    }

    public int isYuanm(char c){
        if ( c == 'a' ||
                c== 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u') {
            return 1;

        }
        return 0;
    }
    public static void main(String[] args) {
        //maxVowels("leetcode",3);
    }
}
