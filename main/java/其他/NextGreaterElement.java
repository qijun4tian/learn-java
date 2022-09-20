package 其他;

/**
 * @author qijun
 * @Description
 * @Date 15:38 2022/7/3
 */
public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        if(s.length() == 1){
            return -1;
        }
        long result = (long)n;
        char[] chars = s.toCharArray();
        a:
        for(int i = s.length() -2; i >= 0; i--){
            for(int j = s.length() - 1; j > i; j--){
                if(chars[j] > chars[i]){
                    char tmp = chars[j];
                    chars[j] =   chars[i];
                    chars[i] = tmp;
                    sort(chars,i+1, s.length()-1);
                    break a;
                }

            }
        }
        result = getResult(chars);
        if(result > Integer.MAX_VALUE){
            return -1;
        }
        if(result >  n){
            return (int)result;
        }
        return -1;

    }

    public void  sort(char[] chars, int begin, int end){
        for(int i = begin; i <= end; i++){

            for(int j = begin; j<= end -1; j++){

                if(chars[j + 1] < chars[j] ){
                    char temp = chars[j+1];
                    chars[j +1] = chars[j];
                    chars[j] = temp;

                }
            }
        }

    }
    public long getResult(char[] chars){
        long result = 0;
        for(int i = 0; i < chars.length; i++){
            int a = chars[i] - '0';
            result = (result) *10 + a;

        }
        return result;

    }
    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        char[] a = {'9','4','0','2'};
        System.out.println(nextGreaterElement.nextGreaterElement(
                21));
    }
}
