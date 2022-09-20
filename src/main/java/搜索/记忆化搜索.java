package 搜索;

import java.util.Arrays;

/**
 * @author qijun
 * @Description
 * @Date 22:45 2022/5/15
 */
public class 记忆化搜索 {

    public int minStickers(String[] stickers, String target) {
        int length = target.length();
        int[] result = new int[1 << length];
        Arrays.fill(result, -1);
        result[0] = 0;
        int min = dp(stickers, 1 << length - 1, target, result);
        return min <= length ? min : -1;

    }

    private int dp(String[] stickers, int num, String target, int[] result) {
        int m = target.length();
        if (result[num] < 0) {
            int res = m + 1;
            for (String sticker : stickers) {
                int left = num;
                int a[] = new int[26];
                for (int i = 0; i < sticker.length(); i++) {
                    a[sticker.charAt(i) - 'a']++;
                }
                for (int i = 0; i < target.length(); i++) {
                    char tempChar = target.charAt(i);
                    if (((num >> i) & 1) == 1 && a[tempChar - 'a'] > 0) {
                        a[tempChar - 'a']--;
                        left = left ^ 1 << i;
                    }
                }
                if (left < num) {
                    res = Math.min(res, dp(stickers, left, target, result) + 1);
                }

            }
            result[num] = res;

        }
        return result[num];

    }
}
