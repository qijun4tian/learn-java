package java.概率;

import java.util.*;

/**
 * @author qijun
 * @date 2022/6/29 21:16
 */
public class BlackList {
    private int bound = 0;

    Random random = new Random();

    private  int[] blacklist = null;


    private int n = 0;

    Map<Integer,Integer> map = new HashMap();


    public BlackList(int n, int[] blacklist) {
        Arrays.sort(blacklist);
        bound = n - blacklist.length;
        this.n = bound;
        int k = bound;
        for(int i = 0; i < bound; i++){
            if(isIn(blacklist, i)){
                for(int j = k; k < n; j++){
                    if(!isIn(blacklist,j)){
                        map.put(i,j);
                        k = j+1;
                        break;
                    }
                }

            }else{
                map.put(i,i);

            }

        }

    }

    public int pick() {
        int n = random.nextInt(this.n);
        return map.getOrDefault(n,n);

    }

    public boolean isIn(int[] blacklist, int result){
        if(blacklist.length == 0){
            return false;
        }
        int begin = 0;
        int end = blacklist.length - 1;
        int big = -1;
        while(begin <= end){
            int middle = begin + (end-begin)/2;
            if(blacklist[middle] == result){
                return true;
            }else if(blacklist[middle] > result){
                end = middle -1;
            }else{
                begin =middle + 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        BlackList blackList = new BlackList(5, new int[]{2,1,0});
        blackList.pick();
        List<Integer> list = new ArrayList<>();
        list.contains(1);
    }
}

