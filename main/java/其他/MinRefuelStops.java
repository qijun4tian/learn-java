package 其他;

/**
 * @author qijun
 * @Description
 * @Date 12:10 2022/7/2
 */
public class MinRefuelStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target){
            return 0;
        }
        if(stations == null || stations.length == 0){
            if(startFuel < target){
                return -1;
            }
        }
        if(startFuel < stations[0][0]){
            return -1;
        }
        int begin =0;
        int count = 0;
        int[] result = getStation(startFuel,stations,0,0);
        while(true){
            if(result[0] == -1){
                return -1;
            }
            count++;
            if(stations[result[0]][0] + result[1] >= target){
                break;
            }else {
                result = getStation(result[1],stations,result[0] + 1, stations[result[0]][0]);
            }
        }
        return count;
    }

    public int[] getStation(int fuel, int[][] stations, int begin, int way){
        int[] result = new int[2];
        if(begin > stations.length -1){
            result[0] = -1;
            return  result;
        }
        int pos = -1;
        for(int i = begin; i < stations.length; i++){
            if(stations[i][0] == fuel){
                pos = i;
                break;
            }
            if(stations[i][0] > fuel){
                pos = i-1;
                break;
            }
        }
        if(pos == -1){
            pos = stations.length -1;
        }
        fuel = fuel - (stations[pos][0]- way) + stations[pos][1];
        result[0] = pos;
        result[1] = fuel;
        return result;

    }

    public static void main(String[] args) {
        MinRefuelStops minRefuelStops = new MinRefuelStops();
        System.out.println(minRefuelStops.minRefuelStops(100,50,new int[][]{{25,50},{50,25}}));


        System.out.println('9'-'1');
    }
}
