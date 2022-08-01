package 字符串;

/**
 * @Author:qijun
 * @Description
 * @Date 21:36 2021/12/6
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 */
public class 有效的字母异位词 {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            boolean hasFinished = false;
            for (int i1 = 0; i1 < chars1.length; i1++) {
                if(chars1[i1] == temp){

                    chars1[i1] = 'A';
                    hasFinished = true;
                    break;
                }
            }
            if(!hasFinished){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isAnagram("anagram"
                ,"nagaram");
    }



}
