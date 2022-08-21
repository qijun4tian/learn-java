package java.数学;

/**
 * @Author:qijun
 * @Description
 * @Date 21:01 2021/12/2
 */
public class 计数质数 {
    public int countPrimes(int n) {
        boolean flags[] = new boolean[n];
        int cnt = 0;
        for(int i= 2;i<n ;i++){
            if(flags[i]){
                continue;
            }
            cnt++;
            for(int j = i*2;j< n;j=j+i){
                flags[j] = true;
             }
        }
        return cnt;

    }
}
