package 数学;

/**
 * https://leetcode.cn/problems/fraction-addition-and-subtraction/submissions/
 * @author qijun
 * @date 2022/7/27 11:26
 */
public class MostYueShu {

    private static int biggestYueshu(int a, int b){
        int r = -1;
        if(a < b){
            int temp = b;
            b = a;
            a = temp;
        }
        while (true){
            r = a % b;
            if(r == 0){
                return b;
            }
            a = b;
            b = r;
        }
    }


    public static int smallestBeishu(int a, int b){
        return a*b / biggestYueshu(a,b);
    }

    public static void main(String[] args) {
        //System.out.println(smallestBeishu(4,5));
        //System.out.println(-4/2);

        MostYueShu mostYueShu = new MostYueShu();
        //System.out.println(mostYueShu.fractionAddition("-1/2+1/2"));

        System.out.println(mostYueShu.fractionAddition("1/3-1/2"));
    }



    public String fractionAddition(String expression) {
        int a[] = new int[2];
        int b[] = new int[2];
        a[0] = 0;
        a[1] = 1;
        int i = 0;
        if(expression.charAt(0) != '-'){

            expression  = "+" + expression;
        }
        while (i < expression.length()) {
            if (expression.charAt(i) == '-'
                    || expression.charAt(i) == '+' || i == expression.length() -1) {
                for (int j = i + 1; j < expression.length(); j++) {
                    if (expression.charAt(j) == '-'
                            || expression.charAt(j) == '+' || j == expression.length() - 1) {
                        if(j == expression.length() -1){
                            j = expression.length();
                        }
                        String subString = expression.substring(i + 1, j);
                        b[0] = Integer.parseInt(subString.split("/")[0]);
                        b[1] = Integer.parseInt(subString.split("/")[1]);
                        a = add(a,b, expression.charAt(i));
                        i = j - 1;
                        break;

                    }

                }
            }
            i++;

        }
        if(a[0] == 0){

            return "0/1";
        }else {

            return String.valueOf(a[0]) + "/" + String.valueOf(a[1]);
        }
    }

    private int[] add(int a[], int b[], char operate){
        int[] result = new int[2];

        result[1] = a[1] * b[1];

        if(operate == '+') {
            result[0] = a[0] * b[1] + b[0] * a[1];
        }else {
            result[0] = a[0] * b[1] - b[0] * a[1];
        }
        if(result[0] == 0){
            result[1] = 1;
            return result;
        }

        int i = biggestYueshu(Math.abs(result[0]), result[1]);

        while (i != 1){
            result[0] /= i;
            result[1] /= i;
            i = biggestYueshu(Math.abs(result[0]),result[1]);
        }

        return  result;
    }


}
