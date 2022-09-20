package 其他;

import java.util.*;

/**
 * @author qijun
 * @Description
 * @Date 21:29 2022/7/22
 */
public class IntersectionSizeTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        TreeMap<Integer,int[]> treeMap = new TreeMap<Integer,int[]>((a1,a2)->a2-a1);
        for(int[] temp : intervals){
            int i = temp[0];
            if(treeMap.containsKey(i)){
                int[] ints = treeMap.get(i);
                if(temp[temp.length -1] < ints[ints.length-1]){
                    treeMap.put(i, temp);
                }
            }else {
                treeMap.put(i, temp);
            }

        }
        TreeSet<Integer> set = new TreeSet<>((a0,a1)->a1-a0);
        for (Map.Entry<Integer, int[]> entry : treeMap.entrySet()) {
            if(set.size() == 0){
                set.add(entry.getKey()+1);
                set.add(entry.getKey());
            }else {
                Integer last = set.last();
                Integer max = set.first();
                int[] value = entry.getValue();
                if(value[value.length -1] < last){
                    set.add(entry.getKey());
                    set.add(entry.getKey() +1);
                }else if(value[value.length -1] == last){
                    set.add(value[value.length -2]);
                }
                else if(value[value.length -1] < max){
                    Integer tmp = last;
                    int count = 0;
                    while (tmp != null && tmp >= value[0] && tmp <= value[value.length -1]){
                        count++;
                        tmp = set.lower(tmp);
                    }
                    if(count < 2){
                        set.add(value[0]);
                    }
                }
            }

        }
        return  set.size();


    }

    public static void main(String[] args) {
        IntersectionSizeTwo intersectionSizeTwo  = new IntersectionSizeTwo();
        //System.out.println(intersectionSizeTwo.intersectionSizeTwo(new int[][]{{2,10},{3,7},{3,15},{4,11},{6,12},{6,16},{7,8},{7,11},{7,15},{11,12}}));


        System.out.println(intersectionSizeTwo.intersectionSizeTwo(new int[][]{{2,15},{9,17},{0,6},{17,25},{0,25}}));
    }


}
