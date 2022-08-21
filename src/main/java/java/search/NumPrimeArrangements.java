package java.search;

/**
 * @author qijun
 * @date 2022/6/30 19:43
 */
public class NumPrimeArrangements {
    public int numPrimeArrangements(int n) {
        int max = (int) Math.pow(10, 9) + 7;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if(isPrime(i)){
                count++;
            }
        }
        System.out.println("count=" + count);
        int sum = 1;
        for(int i = count; i > 1; i--){

            sum  = (sum % max) * i;
        }

        for(int i = n- count; i > 1; i--){

            sum  = (sum % max) * i;
        }
        return sum;


    }

    public boolean isPrime(int n){
        int i = 2;
        while (i < n){
            if(n % i == 0){
                return  false;
            }
            i++;
        }
        return true;

    }

    public static void main(String[] args) {
        NumPrimeArrangements numPrimeArrangements = new NumPrimeArrangements();
        numPrimeArrangements.numPrimeArrangements(100);
    }
}
