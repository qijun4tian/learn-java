package 其他;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author qijun
 * @Description
 * @Date 18:29 2022/7/30
 */
public class LargestComponentSize {
    int total = 0;
    public int largestComponentSize(int[] nums) {
        List<List<Integer>> list = new ArrayList();

        boolean[] booleans = new boolean[nums.length];
        List<Integer> tempList = new ArrayList();
        tempList.add(nums[0]);
        booleans[0] = true;
        total = 1;
        list.add(tempList);
        int listIndex = 0;
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        numList.remove(0);
        while (total < nums.length){
            List<Integer> list1 = list.get(listIndex);
            addByList(list1,numList,booleans);
            Iterator<Integer> iterator = numList.iterator();
            while (iterator.hasNext()) {
                List<Integer> temp = new ArrayList<>();
                temp.add(iterator.next());
                total++;
                iterator.remove();
                list.add(temp);
                break;
            }
            listIndex++;
        }

        int count =0;
        for(List tempset : list){
            count = Math.max(tempset.size(), count);
        }
        return count;
    }

    private void addByList(List<Integer> list, List<Integer> nums, boolean[] booleans){
        if(nums.size() == 0){
            return;
        }
        boolean isAdd = true;
        while (isAdd){
            isAdd  = false;
            Iterator<Integer> iterator = nums.iterator();
            while (iterator.hasNext()){
                int tempVal = iterator.next();
                for (Integer integer : list) {
                    if(gcd(integer,tempVal) > 1){
                        list.add(tempVal);
                        iterator.remove();
                        total++;
                        isAdd = true;
                        break;
                    }
                }

            }

        }
    }


    private int gcd(int a, int b){
        int c = a%b;

        while(c != 0){
            a = b;
            b = c;
            c = a %b;
        }
        return b;

    }

    public static void main(String[] args) {
        LargestComponentSize largestComponentSize = new LargestComponentSize();
        System.out.println(largestComponentSize.largestComponentSize(new int[]{99,68,70,77,35,52,53,25,62}));

        System.out.println((int) 1e5 + 7);

        //System.out.println(largestComponentSize.largestComponentSize(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}
