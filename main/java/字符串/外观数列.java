package 字符串;

import java.util.zip.CheckedOutputStream;

/**
 * @Author:qijun
 * @Description
 * @Date 17:07 2021/12/4
 */
public class 外观数列 {

    public static String countAndSay(int n) {
        if(n ==1){
            return "1";
        }
        if( n ==2){
            return "11";
        }
        String s = "11";
        for (int k = 3; k<=n; k++) {
            StringBuilder stringBuilder = new StringBuilder();
            char a = s.charAt(0);
            int count = 1;
            for (int i = 1; i < s.length(); i++) {

                if (s.charAt(i) == a) {
                    count++;
                } else {
                    stringBuilder.append(count).append(a);
                    a = s.charAt(i);
                    count = 1;
                }
                if(i == s.length() -1){
                    stringBuilder.append(count).append(a);
                }
            }
            s = stringBuilder.toString();
        }
        return s;

    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));

    }
}
