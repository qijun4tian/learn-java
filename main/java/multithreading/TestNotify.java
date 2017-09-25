package multithreading;

import sun.security.util.Length;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import javax.sound.midi.Soundbank;

/**
 * Created by qijun123 on 2017/9/25.
 */


public class TestNotify {

    static Object object = new Object();
    static boolean flag = true;
    static int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static String[] strings = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    static int length1 = 10;
    static int length2 = 10;


    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (object) {
                        if (flag) {
                            System.out.println(ints[10 - length1--]);
                            if (length1 == 0) {
                                length1 = 10;
                            }
                            flag = false;

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            object.notifyAll();

                        } else {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (object) {
                    if (!flag) {
                        System.out.println(strings[10 - length2--]);
                        if (length2 == 0) {
                            length2 = 10;
                        }
                        flag = true;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        object.notifyAll();

                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

        thread1.start();
        thread2.start();
    }


}
