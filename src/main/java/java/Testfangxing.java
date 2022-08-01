package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

/**
 * Created by qijun123 on 2017/8/26.
 */
public class Testfangxing<A> {

    private class  Node<B>{
        private B  item;
        private Node<B> next;

        public Node(B item, Node<B> next) {
            this.item = item;
            this.next = next;
        }
    }

    Node<A> firstNode = new Node<>(null,null);
    public void push(A item) {
        Node<A> tempNode = new Node<>(item,firstNode);
        firstNode = tempNode;
    }

    public A pop() {
        A item = firstNode.item;
        if (!(firstNode.next == null && firstNode.item == null)) {
            firstNode = firstNode.next;
            }
        return item;
        }

    public Testfangxing() {
    }

    public static  <T> T getClass(T t) {
        return t;
    }

    public static void  writeTo(List<? super Integer> list) {

    }

    static class Fruit{
        public Fruit() {
        }
    };
    static class Apple extends Fruit{

    };
    static class Apple1 extends Apple{};

    static void getApple (List<? super Apple> a){

        System.out.println(a.get(0));

    }

    public void write(List<?super Apple> list){
        list.add(new Apple());
        list.add(new Apple1());
        // FIXME: 2017/8/27
//        list.add(new Fruit());
    }

    public static Integer getNum(List<Integer>list,int length){

        if(length ==1)
        {
            return list.get(0);
        }
        else
        {
            return list.get(length-1)+getNum(list,length-1);
        }


    }

    public static void main(String[] args) {
        Testfangxing<String> testfangxing = new Testfangxing<>();

        testfangxing.push("1");
        testfangxing.push("2");
        testfangxing.push("3");
        testfangxing.push("4");
        String s = testfangxing.pop();
        while (s != null) {
            System.out.println(s);
            s = testfangxing.pop();
        }

        String a = getClass("10");
        List<? extends Integer> list = new ArrayList<Integer>();
//        list.add((Integer)111);

        Apple1 apple1 = new Apple1();
        getApple(Arrays.asList(apple1));

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);

//        Iterable<Integer> iterator = list;
        /*for(Integer i :iterator){

        }
*/

        List<Integer> list31 = Arrays.asList(1,3,4,16,18);

        List<? extends Number> list2 = new ArrayList<Number>(Arrays.asList(11,2.1,3.5,4));
        System.out.println(list2.get(1).getClass());
//        list2.remove(1);
//        Integer i = 1;
        //list2.add(1);


        List<? super Number> list3 = new ArrayList<>(Arrays.asList(111111111111111L,111111111,1.1));
        list3.get(1);
        list3.set(1,4);
        list3.add(5);
        System.out.println("<<<<<<<<<<<<<<<");
        list3.set(2,3.411111111111111111111111f);
        Object i1 = list3.get(0);
        System.out.println(i1.getClass());

        System.out.println(getNum(list31,list31.size()));
        System.out.println(list31.stream().collect(reducing(0,(i, j)->i+j)));

        List<String> stringList = Arrays.asList("123","456","789");
        System.out.println(stringList.stream().collect(Collectors.joining()));
        String [] strings = "1,2,3,4,5".split("");
        System.out.println(strings[0]+"   "+strings[1]);
    }

}

