package ali;

import java.util.*;
import java.util.concurrent.Semaphore;

/**
 * 求数组连续子数组之和等于某个数的最短数组
 */
public class AliTest {


    public static List<Integer> getLeastList(List<Integer> nums, Integer s) {
        Integer temp = 0;
        Map<Integer, Integer> result = new HashMap<>();
        Integer minLength = nums.size();
        for (int i = 0; i < nums.size(); i++) {
            temp = nums.get(i);
            if (temp >= s) {
                result.put(i, i);
                minLength = 0;
                continue;
            }
            for (int j = i + 1; j < nums.size(); j++) {
                temp = temp + nums.get(j);
                if (temp >= s) {
                    result.put(i, j);
                    if (j - i < minLength) {
                        minLength = j - i;
                    }
                    break;
                }
            }

        }
        if (result.isEmpty()) {
            return null;
        }
        int start = 0;
        int end = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            Integer size = entry.getValue() - entry.getKey();
            if (size.equals(minLength)) {
                start = entry.getKey();
                end = entry.getValue();
                break;
            }
        }

        return nums.subList(start, end + 1);

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 1, 2, 4, 3);

        List<Integer> list1 = getLeastList(list, 9);

        if (!list.isEmpty()) {
            for (Integer integer : list1) {
                System.out.println(integer);
            }
        }
        Semaphore s = new Semaphore(3);
    }


}