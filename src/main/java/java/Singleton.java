package java;

/**
 * Created by qijun123 on 2017/5/8.
 */
//public class Singleton {
//    private static volatile Singleton singleton;
//    private Singleton(){}
//    public static Singleton getSingleton()
//    {
//        if(singleton == null)
//        {
//            synchronized (Singleton.class)
//            {
//        }
//                if(singleton == null)
//                {
//                    singleton =  new Singleton();
//                }
//            }
//
//        return singleton;
//    }
//
//    public static void main(String[] args) {
//
//        System.out.println(Singleton.getSingleton()+"<<<<<<"+singleton);
//        System.out.println(singleton.equals(Singleton.getSingleton()));
//    }
//}

public class Singleton{
    private Singleton(){

    }

    private static class classHoder{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){

        return classHoder.singleton;
    }
}