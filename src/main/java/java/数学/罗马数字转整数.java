package java.数学;

/**
 * @Author:qijun
 * @Description
 * @Date 22:02 2021/12/8
 */
public class 罗马数字转整数 {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'I'){
                if(i != chars.length -1 ) {
                    if(chars[i+1] == 'V'){
                        result += 4;
                        i++;
                    }
                    else if(chars[i+1] == 'X'){
                        result += 9;
                        i++;
                    }
                    else {
                        result +=1;
                    }
                }else {
                    result +=1;
                }
            }else if(chars[i] == 'V'){
                result +=5;
            }else if(chars[i] == 'X'){
                if(i != chars.length -1 ) {
                    if(chars[i+1] == 'L'){
                        result += 40;
                        i++;
                    }
                    else if(chars[i+1] == 'C'){
                        result += 90;
                        i++;
                    }
                    else {
                        result +=10;
                    }
                }else {
                    result +=10;
                }

            }else if(chars[i] == 'L'){
                result +=50;
            }else if(chars[i] == 'C'){
                if(i != chars.length -1 ) {
                    if(chars[i+1] == 'D'){
                        result += 400;
                        i++;
                    }
                    else if(chars[i+1] == 'M'){
                        result += 900;
                        i++;
                    }
                    else {
                        result +=100;
                    }
                }else {
                    result +=100;
                }
            }else if(chars[i] == 'D'){
                result +=500;
            }else {
                result +=1000;
            }
        }

        return result;
    }
}
