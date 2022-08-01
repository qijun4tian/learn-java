package java;

/**
 * Created by qijun123 on 2017/5/11.
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = Integer.MAX_VALUE;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(a+1);
        Thread thread= new Thread(()-> System.out.println("123"));


    }
}
