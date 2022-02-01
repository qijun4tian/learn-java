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
            if(map.containsKey(chars[right])){
                int oldLeft = left;
                left  = map.get(chars[right]) + 1;
                for (int i = oldLeft; i < left; i++) {
                    map.remove(chars[i]);
                }
            }
            map.put(chars[right],right);
            max = Math.max(max,right- left + 1);
            right++;
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 更优解法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int r = 0, l = 0, res = 0;
        Set<Character> set = new HashSet<>();
        while(r<s.length()){
            char c = s.charAt(r++);
            while(set.contains(c)){
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res,set.size());
        }
        return res;
    }

}
