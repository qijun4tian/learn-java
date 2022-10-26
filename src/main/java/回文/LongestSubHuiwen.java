package 回文;

/**
 * @author qijun
 * @date 2022/6/21 19:30
 */
public class LongestSubHuiwen {

    public String longestPalindrome(String s) {
        int max = 1;
        String result = s.substring(0,1);
        for(int i =1; i<= s.length() -2; i++){

            int temp1 = getMaxLength(i,i+1,s);
            int temp2 = getMaxLength(i,i,s);
            int temp = Math.max(temp1,temp2);
            if(temp > max){

                result = s.substring(i - (temp-1)/2,i+ temp/2 + 1);

            }

        }

        return result;

    }

    public int getMaxLength(int begin, int end,String s){

        while(begin >=0 && end <= s.length() -1){
            if(s.charAt(begin) == s.charAt(end)){
                begin--;;
                end++;
            }else {
                break;
            }

        }
        return begin + 1  - (end - 1)  + 1;

    }
    public static void main(String[] args) {
        LongestSubHuiwen longestSubHuiwen  = new LongestSubHuiwen();
        System.out.println(longestSubHuiwen.longestPalindrome("babad"));
    }
}
