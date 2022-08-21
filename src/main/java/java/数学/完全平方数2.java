package java.数学;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author:qijun
 * @Description 广度优先搜索 数学 动态规划
 * @Date 21:25 2022/1/9
 */
public class 完全平方数2 {
    public static int numSquares(int n) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(n);
        int step = 0;
        if (isSquare(n)) {
            return 1;
        }
        while (!deque.isEmpty()) {
            step++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer pop = deque.pop();
                for (Integer integer = 1; integer <= pop / 2; integer++) {
                    if (isSquare(integer)) {
                        System.out.println(integer);
                        if (isSquare(pop - integer)) {
                            System.out.println(pop - integer);
                            step++;
                            return step;
                        } else {
                            deque.add(pop - integer);
                        }

                    }
                }
            }


        }
        return step;
    }


    /**
     * 1,2,3,4,5,6,7,8,9
     * 判断一个数是不是完全平方
     *
     * @param n
     * @return
     */
    public static boolean isSquare(int n) {
        //double temp = Math.floor(Math.sqrt(n));
        //return Math.pow(temp, 2) == n;

        return (Math.sqrt(n) % 1) == 0;

    }

    public static void main(String[] args) {
        System.out.println(isSquare(8));
    }
}
