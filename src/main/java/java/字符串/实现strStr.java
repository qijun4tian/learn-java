package java.字符串;

/**
 * @Author:qijun
 * @Description
 * @Date 21:55 2021/12/3
 */
public class 实现strStr {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        int n = 0;

        for(int i= 0; i<= haystack.length() -needle.length();i++){
                n = i;
            boolean allMatch = true;
                for(int j = 0; j<needle.length();j++){
                    if(needle.charAt(j) != haystack.charAt(i+j)){
                        allMatch = false;
                        break;
                    }
                }
                if(allMatch){
                    return n;
                }
        }
        return -1;
    }


    public int strStr1(String haystack, String needle) {
        int windowSize = needle.length();
        if (windowSize == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == windowSize - 1) {
                    return i - windowSize + 1;
                }
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }

        return -1;
    }


}
