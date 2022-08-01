package java.数学;

/**
 * @Author:qijun
 * @Description
 * @Date 21:00 2021/12/11
 */
public class isPowerOfThree {
    public boolean isPowerOfThree(int n) {

        if(n == 0){
            return false;
        }
        while (n != 1){
            if(n %3 != 0 ){
                return false;
            }else {
                n = n/3;
            }
        }
        return true;
    }
}
