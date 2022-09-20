package 优先队列;

import java.util.PriorityQueue;

/**
 * 最少加油次数
 * @author qijun
 * @Description https://leetcode.cn/problems/minimum-number-of-refueling-stops/
 * @Date 7:26 2022/7/13
 */
public class MinRefuelStops {
    /**
     * 100
     * 1
     * [[10,100]]
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)-> b- a);
        int allgas = startFuel;
        int i = 0;
        int ans = 0;
        while(allgas < target){
            if(i < stations.length &&  allgas >= stations[i][0]){
                priorityQueue.offer(stations[i][1]);
                i++;
            }else {
                if(priorityQueue.size() == 0){
                    return -1;
                }else {
                    allgas += priorityQueue.poll();
                    ans++;

                }

            }


        }

        return ans;
    }

    public static void main(String[] args) {
        MinRefuelStops minRefuelStops= new MinRefuelStops();
        minRefuelStops.minRefuelStops(100,1 , new int[][]{{10,100}});
    }
}
