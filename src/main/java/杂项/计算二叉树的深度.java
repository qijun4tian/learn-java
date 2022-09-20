package 杂项;

import java.util.Arrays;
import java.util.List;

/**
 * [1,2,3,null,null,4,5] 的深度，序列化方式是leetcode序列化的方式
 *
 * @author qijun
 * @Description
 * @Date 21:55 2022/4/22
 */
public class 计算二叉树的深度 {
    public static int getLength(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        int deep = 1;
        int length = list.size();
        int begin = 0;
        int end = 1;
        while (end < length) {
            int count = 0;
            for (int i = begin; i < end; i++) {
                if (list.get(i) != null) {
                    count++;
                }
            }
            begin = end;
            end = end + count * 2;
            deep++;
        }
        return deep;

    }

    public static void main(String[] args) {
        System.out.println(getLength(Arrays.asList(1, 2, 3, null, null, 4, 5, 4)));
    }
}
