package search.二分;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qijun
 * @date 2022/7/5 21:32
 */
public class MyCalendar {
    private List<Integer> list;
    public MyCalendar() {
        this.list = new ArrayList();
    }

    public boolean book(int start, int end) {
        if(list.size() == 0){
            list.add(start);
            list.add(end);
            return true;
        }
        // System.out.println("list=" + list.size());
        int first = getFirstBig(list,start);
        // System.out.println("first=" + first);
        // System.out.println(Arrays.toString(list.toArray()));
        if(first == -1){
            if(start < list.get(0)){
                if(end <= list.get(0)){
                    list.add(0, start);
                    list.add(1, end);
                    return true;
                }else{
                    return false;
                }

            }
        }else {
            if((first + 1) % 2 == 0){
                if(first  == list.size() -1){
                    list.add(start);
                    list.add(end);
                    return true;

                }else {
                    if(list.get(first + 1) >= end){
                        list.add(first + 1, start);
                        list.add(first + 2, end);
                        return true;
                    }else {
                        return false;
                    }

                }

            }else {

                return false;

            }

        }
        return false;
    }

    private int getFirstBig(List<Integer> list, int start){
        int left = 0;
        int right = list.size() -1;
        int least = -1;
        while(left <= right){
            int middle = left + (right - left) /2;
            if(list.get(middle) > start){
                right = middle - 1;

            }else if(list.get(middle) == start){
                return middle;

            }else {
                least = middle;
                left = middle + 1;
            }


        }
        return least;

    }
    public static void main(String[] args) {

    }
}

