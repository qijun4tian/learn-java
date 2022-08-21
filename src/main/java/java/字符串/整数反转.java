package java.字符串;

/**
 * @Author:qijun
 * @Description
 * @Date 21:13 2021/11/24
 */
public class 整数反转 {

    public static int reverse(int x) {
        String s = String.valueOf(x);
        if(s.length() == 1){
            return Integer.parseInt(s);
        }
        char[] chars = s.toCharArray();
        StringBuilder s1 = new StringBuilder();
        int begin = 0;
        int end = chars.length -1;
        if(chars[0] == '-'){
            begin = 1;
            s1.append("-");
        }
        boolean isBegin = false;
        for (int i = end; i >= begin; i--) {
            if(!isBegin && chars[i] != '0'){
                isBegin = true;
            }
            if(isBegin) {
                s1.append(chars[i]);
            }
        }
        if((s1.toString().length() == String.valueOf(Integer.MAX_VALUE).length() && s1.toString().compareTo(String.valueOf(Integer.MAX_VALUE)) > 0)
        ||( s1.toString().length() == String.valueOf(Integer.MIN_VALUE).length() && s1.toString().compareTo(String.valueOf(Integer.MIN_VALUE)) > 0)) {
          return 0;
        }
        return Integer.parseInt(s1.toString());
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
