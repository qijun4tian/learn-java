package 其他;

import com.sun.javafx.scene.control.behavior.TwoLevelFocusBehavior;

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
        for (int i = 0; i < rowIndex + 1; i++) {
            int tow = getN(rowIndex, i);
            result.add(tow + last);
            last = tow;
        }

        return result;

    }


    public static Integer getN(int rowIndex, int i) {
        System.out.println("rowIndex=" + rowIndex + "i=" + i);
        if (rowIndex < 0 || i > rowIndex) {
            return 0;
        }
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
        List<Integer> row = getRow(0);

        System.out.println(111);

    }
}
