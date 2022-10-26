package 字符串;

/**
 * @Author:qijun
 * @Description
 * @Date 17:05 2021/12/5
 */
public class 字符串转换整数 {
    public static int myAtoi(String s) {

        char fuhao = ' ';
        int begin = -1;
        boolean isTrim = false;
        boolean isFuhao = false;
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        boolean hafuhao = false;
        hafuhao = s.charAt(0) == '-' || s.charAt(0) == '+';
        int begin1 = hafuhao ? 1 : 0;
        double result = 0L;
         for(int i = begin1; i< s.length();i++){
            if(!Character.isDigit(s.charAt(i)) && result == 0){
                return 0;
            }
            if(Character.isDigit(s.charAt(i)) && s.charAt(i) != '0' && begin == -1){
                begin = i;
            }
            if(begin != -1 && i>=begin ){
                if(Character.isDigit(s.charAt(i))) {
                    result =  result * 10 + (s.charAt(i) - '0');
                }else{
                    break;
                }
            }
        }
       result = s.charAt(0) == '-' ? -result : result;
        if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;


    }

    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }
}
