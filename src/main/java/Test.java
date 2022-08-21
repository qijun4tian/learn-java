//import lombok.Data;
//import lombok.NonNull;
//
//import javax.sound.midi.Soundbank;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * Created by qijun123 on 2017/4/26.
// */
//@Data
//public class Test implements TestInterface{
//
//    @NonNull
//    private int a;
//
//    private int b;
//    static int a1;
//    private newThread newThread;
//    @Override
//    public void test(int a,int b) {
//        System.out.println("a="+a+" "+"b="+b);
//    }
//    public void testTest(TestInterface t)
//    {
//        t.test(3,4);
//    }
//
//    @Override
//    public String toString() {
//        return "testis "+super.toString();
//    }
//
//    public static void main(String[] args) {
//
////        HashMap<String,String> map = new HashMap<String, String>();
////        try {
////            Class c = Class.forName("Test");
////            try {
////                Test test  = (Test)c.newInstance();
////                System.out.println(test);
////            } catch (InstantiationException e) {
////                e.printStackTrace();
////            } catch (IllegalAccessException e) {
////                e.printStackTrace();
////            }
////        } catch (ClassNotFoundException e) {
////            e.printStackTrace();
////        }
////
////
////        final  Test1 test1 = new Test1();
//        Test test = new Test(3);
//        Runnable runnable = ()-> System.out.println("goodbye");
//        Runnable runnable1 = new Thread();
//        runnable.run();
//        int a = 12;
//
//        test.testTest((a1,b)-> System.out.println("goodbye"));
//        test.testTest(test);
//        System.out.println(test.a+"..."+test.b);
//        System.out.println(Test.a1);
//
//        Test test1 = new Test(5);
//        Test test2 = test1;
//        test1 = new Test(7);
//        System.out.println(test1.a);
//        System.out.println(test2.a);
//        Integer[] a1 = {1,2,3};
//
//
//
//    }
//
//}
//class Test1{
//
//    public void print()
//    {
//        System.out.println("goodbye");
//    }
//
//}