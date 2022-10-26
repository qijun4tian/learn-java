import java.io.IOException;

/**
 * Created by qijun123 on 2017/8/1.
 */
public class MachineBlocked  extends Thread{
    //private static StringBuffer log=new StringBuffer();
//private static int count=0;
    public void run(){
        for(int a=0;a<50;a++){
            System.out.println(currentThread().getName()+":"+a);
        }
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        MachineBlocked mb=new MachineBlocked();
        mb.start();
        try {
            int date=System.in.read();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        mb.run();
    }

}