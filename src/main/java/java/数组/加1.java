package java.数组;

/**
 * @Author:qijun
 * @Description
 * @Date 15:18 2021/11/21
 */
public class 加1 {
    //public static int[] plusOne(int[] digits) {
    //    int length = digits.length;
    //    int result = 0;
    //    for (int i = 0; i < digits.length; i++) {
    //        result += digits[i] * (Math.pow(10,length-i -1));
    //    }
    //    result = result + 1;
    //    String s = String.valueOf(result);
    //    int[] resultArray = new int[s.length()];
    //    for (int i = 0; i < s.length(); i++) {
    //        char c = s.charAt(i);
    //        Integer integer = Character.getNumericValue(c);
    //        resultArray[i] = integer;
    //    }
    //    return resultArray;
    //
    //
    //}

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] ints = plusOne(nums);
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        if (digits[length - 1] < 9) {
            digits[length - 1] = digits[length - 1] + 1;
            return digits;
        } else {
            boolean flag = false;
            int end = length - 1;
            while (end >= 0 && digits[end] == 9) {
                digits[end] = 0;
                end = end - 1;
            }
            if (digits[0] == 0) {
                flag = true;
            } else {
                digits[end] = digits[end] + 1;
            }
            if (flag) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                for (int i = 0; i < digits.length; i++) {
                    result[i + 1] = digits[i];
                }
                return result;

            } else {
                return digits;
            }

        }
    }


}
