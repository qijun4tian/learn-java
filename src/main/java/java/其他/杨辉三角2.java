package java.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:qijun
 * @Description
 * @Date 22:45 2021/12/16
 */
public class 杨辉三角2 {

    public static List<Integer> getRow(int rowIndex) {
        int last = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= rowIndex + 1; i++) {
            int tow = getN(rowIndex, i);
            result.add(tow + last);
            last = tow;
        }

        return result;

    }


    public static Integer getN(int rowIndex, int i) {
        if (rowIndex == 0) {
            return 1;
        }
        System.out.println("rowIndex=" + rowIndex + "i=" + i);
        if (rowIndex < 1 || i > rowIndex) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i == rowIndex) {
            return 1;
        }
        return getN(rowIndex - 1, i - 1) + getN(rowIndex - 1, i);
    }

    public static void main(String[] args) {
        List<Integer> row = getRow1(3);
        row.forEach(System.out::println);

        System.out.println(111);

    }

    class Solution {
        public List getRow(int rowIndex) {
            List res = new ArrayList<>(rowIndex + 1);
            long index = 1;
            for (int i = 0; i <= rowIndex; i++) {
                res.add((int) index);
                index = index * (rowIndex - i) / (i + 1);
            }
            return res;
        }
    }

    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(j, 1);
                } else {
                    cur.add(j, pre.get(j) + pre.get(j - 1));
                }
            }
            pre = cur;
        }
        return pre;
    }


}
