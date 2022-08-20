package 其他;

public class SolveEquation {

        public String solveEquation(String equation) {
            String s[] = equation.split("=");
            String s0 = s[0] + "+";
            String s1 = s[1] + "+";

            int[] result1 = getResult(s0);
            int[] result2 = getResult(s1);
            if(result1[0] == result2[0] && result1[1] == result2[1]){
                return "Infinite solutions";
            }
            if(result1[0] == result2[0]){
                return  "No solution";

            }

            return  "x=" + -(result1[1] - result2[1])/ (result1[0] - result2[0]);



        }

        private int[] getResult(String s0){
            int i = 0;
            char temp = '+';
            if(s0.charAt(0) == '-'){
                s0 = s0.substring(1);
                temp = '-';
            }
            int xcount1 = 0;
            int count1 = 0;
            int last = 0;
            int [] result = new int[2];
            while(i < s0.length()){
                if(s0.charAt(i) == '+' ||
                        s0.charAt(i) == '-') {
                        if (temp == '+') {
                            if (s0.charAt(i - 1) == 'x') {
                                if (last != i - 1) {
    //                            System.out.println("last=" + last + "i=" + i);
    //                            System.out.println(s0.substring(last, i - 1));
                                    xcount1 += Integer.parseInt(s0.substring(last, i - 1));
                                } else {
                                    xcount1 += 1;
                                }
                            } else {
                                count1 += Integer.parseInt(s0.substring(last, i));
                            }
                        } else {
                            if (s0.charAt(i - 1) == 'x') {
                                if (last != i - 1) {
                                    xcount1 -= Integer.parseInt(s0.substring(last, i - 1));
                                } else {
                                    xcount1 -= 1;
                                }
                            } else {
                                count1 -= Integer.parseInt(s0.substring(last, i));
                            }

                        }
                        temp = s0.charAt(i);
                        last = i + 1;

                    }

                i++;
            }
            result[0] = xcount1;
            result[1] = count1;
            return result;

        }

    public static void main(String[] args) {
        SolveEquation solveEquation = new SolveEquation();
        System.out.println(solveEquation.solveEquation("2x=x"));
    }
}
