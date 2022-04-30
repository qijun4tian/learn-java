package 其他;

/**
 * @author qijun
 * @Description
 * @Date 15:21 2022/4/30
 */
public class 二进制加法 {
    public static String addBinary(String a, String b) {
        int lengtha = a.length();
        int lengthb = b.length();
        int length = Math.max(lengtha, lengthb);
        StringBuilder s = new StringBuilder();
        int j = 0;
        for (int i = 0; i < length; i++) {
            char temp1 = '0';
            char temp2 = '0';
            if (lengtha - 1 - i >= 0) {
                temp1 = a.charAt(lengtha - 1 - i);
            }
            if (lengthb - 1 - i >= 0) {
                temp2 = b.charAt(lengthb - 1 - i);
            }
            int a1 = temp1 - '0';
            int b1 = temp2 - '0';
            if (a1 + b1 + j == 0) {
                s.append("0");
                j = 0;
            } else if (a1 + b1 + j == 1) {
                s.append("1");
                j = 0;
            } else if (a1 + b1 + j == 2) {
                s.append("0");
                j = 1;
            } else if (a1 + b1 + j == 3) {
                s.append("1");
                j = 1;
            }

        }
        if (j != 0) {
            s.append(j);
        }
        String s3 = s.toString();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s3.length(); i++) {
            s2.append(s.charAt(s3.length() - 1 - i));
        }
        return s2.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "10"));
    }

}
