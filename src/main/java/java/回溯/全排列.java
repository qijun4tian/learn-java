package java.回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        Deque<List<Integer>> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                for (int num : nums) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(num);
                    deque.add(temp);
                }
            }else {
                int size = deque.size();
                for (int i1 = 0; i1 < size; i1++) {
                    List<Integer> list = deque.poll();
                    List<Integer> cha = cha(list, nums);
                    for (Integer integer : cha) {
                        List<Integer> temp = new ArrayList<>(list);
                        temp.add(integer);
                        deque.add(temp);
                    }
                }

            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!deque.isEmpty()){
            result.add(deque.poll());
        }

        return result;
    }

    private List<Integer> cha(List<Integer> list, int[] nums){
        List<Integer> cha = new ArrayList<>();
        for (int num : nums) {
            if(!list.contains(num)){
                cha.add(num);
            }
        }
        return cha;

    }


}
