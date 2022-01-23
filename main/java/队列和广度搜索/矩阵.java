package 队列和广度搜索;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:qijun
 * @Description https://leetcode-cn.com/leetbook/read/queue-stack/g7pyt/
 * @Date 12:52 2022/1/23
 */
public class 矩阵 {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = bfs(i, j, mat, m, n);
            }
        }
        return result;
    }

    private Integer bfs(int i, int j, int[][] mat, int m, int n) {
        Deque<List<Integer>> deque = new LinkedList<>();
        int min = -1;
        int[][] visited = new int[m][n];
        addDequeu(i, j, deque, visited);
        while (!deque.isEmpty()) {
            int size = deque.size();
            min++;
            for (int i1 = 0; i1 < size; i1++) {
                List<Integer> pop = deque.pop();
                int tempi = pop.get(0);
                int tempj = pop.get(1);
                if (mat[tempi][tempj] == 0) {
                    return min;
                } else {
                    if (tempi - 1 >= 0 && visited[tempi - 1][tempj] == 0) {
                        addDequeu(tempi - 1, tempj, deque, visited);
                    }
                    if (tempi + 1 < m && visited[tempi + 1][tempj] == 0) {
                        addDequeu(tempi + 1, tempj, deque, visited);
                    }
                    if (tempj + 1 < n && visited[tempi][tempj + 1] == 0) {
                        addDequeu(tempi, tempj + 1, deque, visited);
                    }
                    if (tempj - 1 >= 0 && visited[tempi][tempj - 1] == 0) {
                        addDequeu(tempi, tempj - 1, deque, visited);
                    }

                }
            }
        }
        return 0;


    }
    //[[0],[1]]

    private void addDequeu(int i, int j, Deque<List<Integer>> deque, int[][] visited) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        deque.add(list);
        visited[i][j] = 1;
    }


}
