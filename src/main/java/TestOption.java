import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by qijun123 on 2017/8/24.
 */
public class TestOption {


    public static void testMethod() {


    }

    public static void main(String[] args) {

        ArrayList<Integer> arrayList3=new ArrayList<Integer>();
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer
        try {
            arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}

