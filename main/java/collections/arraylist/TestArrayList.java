package collections.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by qijun123 on 2017/9/25.
 */
public class TestArrayList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    /*下面这段代码会报错,但break不会报错*/

    /*
    for(Integer i :list){
    if (i == 5)
    {
    list.remove(list.indexOf(5));

    }
    }
    */
        for (Integer i : list) {
            if (i == 5) {
                list.remove(list.indexOf(5));
                break;
            }
        }
    /**/
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(4)) {
                iterator.remove();
            }
        }


        char a = 'a';
        System.out.println(a);

        list.forEach(System.out::println);


    }
}
