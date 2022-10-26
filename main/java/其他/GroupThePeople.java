package 其他;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qijun
 * @date 2022/8/12 17:38
 */
public class GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList();
        Map<Integer,List<Integer>> map = new HashMap();
        for(int i =0; i < groupSizes.length; i++){
            map.putIfAbsent(groupSizes[i],new ArrayList());
            List<Integer> temp = map.get(groupSizes[i]);
            temp.add(i);
            if(temp.size() == groupSizes[i]){
                result.add(temp);
                map.remove(groupSizes[i]);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        GroupThePeople groupThePeople = new GroupThePeople();
        //groupThePeople.groupThePeople(new int[]{2, 1, 3, 3, 3, 2})
    }
}
