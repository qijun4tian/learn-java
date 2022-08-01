package java.深度搜索;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qijun
 * @Description
 * @Date 11:27 2022/5/1
 */
public class 字符串的排列 {
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> initMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
                initMap.put(s1.charAt(i), initMap.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
                initMap.put(s1.charAt(i), 1);
            }
        }
        int i = 0;
        while (i < s2.length()) {
            System.out.println("i=" + i);
            int begin = i + s1.length();
            for (int j = i; j < i + s1.length() && j < s2.length(); j++) {
                if (map.containsKey(s2.charAt(j))) {
                    Integer integer = map.get(s2.charAt(j));
                    map.put(s2.charAt(j), integer - 1);
                    if (j != i) {
                        begin = Math.min(begin, j);
                    }
                }
                if (j == i + s1.length() - 1 || j == s2.length() - 1) {
                    boolean b = true;
                    for (Map.Entry<Character, Integer> en : map.entrySet()) {
                        if (!en.getValue().equals(0)) {
                            b = false;
                        }
                        en.setValue(initMap.get(en.getKey()));

                    }
                    if (b) {
                        return true;
                    }
                    i = begin;

                    break;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        //"ab"
        //"eidboaoo"
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

}
