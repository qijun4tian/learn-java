package java.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qijun
 * @date 2021/12/7 20:24
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        result.add(list1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list2 = result.get(i - 1);

            List<Integer> temp = new ArrayList<>();

            for (int i1 = -1; i1 < list2.size(); i1++) {
                if(i1 == -1){
                    temp.add(list2.get(0));
                }else if(i1 == list2.size() -1) {
                    temp.add(list2.get(i1));
                }
                else {
                    temp.add(list2.get(i1) + list2.get(i1+1));
                }
            }

            result.add(temp);

        }
        return result;
    }
}
