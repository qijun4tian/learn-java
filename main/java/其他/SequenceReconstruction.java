package 其他;

import java.util.*;

/**
 * @author qijun
 * @Description
 * @Date 15:59 2022/7/23
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        List<List<Integer>> edge = new ArrayList();
        Set<Integer> set = new HashSet();
        int max = -1;
        for(int[] intn : sequences){
            for(int i : intn){
                set.add(i);
            }

        }
        if(set.size() != nums.length){
            return false;
        }
        int size = set.size() + 1;
        for(int i =0 ;i < size;i++){
            edge.add(new ArrayList());
        }

        int[] indegree = new int[size];
        indegree[0] = -1;
        for(int[] intn : sequences){
            for(int i =0; i< intn.length; i++){
                if(i != intn.length -1) {
                    List<Integer> temp = edge.get(intn[i]);
                    if (temp == null) {
                        temp = new ArrayList();
                        temp.add(intn[i + 1]);
                        edge.set(intn[i], temp);

                    } else {
                        edge.get(intn[i]).add(intn[i + 1]);
                    }
                }
                if(i != 0){
                    indegree[intn[i]]++;
                }
            }

        }

        List<Integer> result =  topSort(edge,  indegree);
        if(result == null || result.size() != nums.length){
            return false;
        }
        for(int i = 0; i< nums.length; i++){

            if(nums[i] != result.get(i)){
                return false;
            }
        }
        return true;



    }

    private List<Integer> topSort(List<List<Integer>> edges, int[] indegree){
        Deque<Integer> deque = new LinkedList();
        List<Integer> result= new ArrayList();
        for(int i =0; i < indegree.length; i++){
            if(indegree[i] == 0){
                deque.add(i);
            }

        }
        while(deque.size() != 0){
            if(deque.size() != 1){
                return null;
            }
            Integer temp = deque.poll();
            result.add(temp);
            List<Integer> edge = edges.get(temp);
            for(int dian : edge){
                indegree[dian]--;
                if(indegree[dian] == 0){
                    deque.add(dian);
                }
            }

        }
        return result;


    }

    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        sequenceReconstruction.sequenceReconstruction(new int[]{1,2,3},new int[][]{{1,2},{1,3},{2,3}});
        //sequenceReconstruction.sequenceReconstruction(new int[]{4,1,5,2,3,6},new int[][]{{5,2,3,6},{4de,1,5,2}});


    }
}
