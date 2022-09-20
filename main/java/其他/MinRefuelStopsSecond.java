package 其他;

import java.util.SimpleTimeZone;

/**
 * @author qijun
 * @Description
 * @Date 13:59 2022/7/2
 */
public class MinRefuelStopsSecond {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        if (stations == null || stations.length == 0) {
            if (startFuel < target) {
                return -1;
            }
        }
        if (startFuel < stations[0][0]) {
            return -1;
        }
        return min(target,startFuel,stations,0,0);

    }
    public int min(int target, int fule, int[][] stations, int beginIndx, int begin){
        if (fule >= target) {
            return 0;
        }
        if(beginIndx == stations.length){
            if(fule < target){
                return  -1;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = beginIndx; i< stations.length; i++){
            if(stations[i][0] -begin <= fule){
                int tempMin =  min(target - stations[i][0] + begin,fule+ stations[i][1] - stations[i][0]  + begin,stations,i+1,stations[i][0]);
                if(tempMin != -1 && tempMin != Integer.MAX_VALUE){
                    min = Math.min(min,tempMin +1);
                }

            }else {
                break;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        MinRefuelStopsSecond minRefuelStopsSecond = new MinRefuelStopsSecond();
        int i = minRefuelStopsSecond.minRefuelStops(100, 83, new int[][]{{47,220},{65,1},{98,113},{126,196},{186,218},{320,205},{686,317},{707,325},{754,104},{781,105}});
        System.out.println(i);
    }
}
