package 其他;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:qijun
 * @Description
 * @Date 22:45 2021/12/16
 */
public class 杨辉三角2 {

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(getN(rowIndex + 1, i));
        }

        return result;

    }


    public static Integer getN(int rowIndex, int i) {
        if (i == -1) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        if (i == rowIndex - 1) {
            return 1;
        }
        return getN(rowIndex - 1, i - 1) + getN(rowIndex - 1, i);
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(4);

        System.out.println(111);

    }
}
