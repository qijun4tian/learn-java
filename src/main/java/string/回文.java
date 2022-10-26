package string;

import java.util.ArrayList;
import java.util.List;

public class 回文 {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            if (Character.isDigit(aChar) || Character.isAlphabetic(aChar)) {
                characters.add(Character.toLowerCase(aChar));
            }
        }
        if (characters.size() == 0) {
            return true;
        }
        for (int i = 0; i <= characters.size() / 2; i++) {
            if (!characters.get(i).equals(characters.get(characters.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome1(s));


    }

    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s) {
        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
