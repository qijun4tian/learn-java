package 队列和广度搜索;

import java.util.*;

/**
 * @author:qijun
 * @Description https://leetcode-cn.com/leetbook/read/queue-stack/g7pyt/
 * @Date 12:52 2022/1/23
 */
public class 矩阵 {
    private int k1;
    private int k2;

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[][] v = new int[m][n];
                getLeastStep(result, i, j, m, n, mat, v);

            }
        }
        return result;
    }

    public static Integer getLeastStep(int[][] result, int i, int j, int m, int n, int[][] mat, int[][] v) {
        v[i][j] = 1;
        if (mat[i][j] == 0) {
            result[i][j] = 0;
            return result[i][j];
        } else {
            if (result[i][j] != -1) {
                return result[i][j];
            } else {
                int temp1 = 10000;
                int temp2 = 10000;
                int temp3 = 10000;
                int temp4 = 10000;
                if (i - 1 >= 0 && (v[i - 1][j] == 0)) {
                    temp1 = getLeastStep(result, i - 1, j, m, n, mat, v) + 1;
                }
                if (i + 1 < m && v[i + 1][j] == 0) {
                    temp2 = getLeastStep(result, i + 1, j, m, n, mat, v) + 1;
                }
                if (j + 1 < n && v[i][j + 1] == 0) {
                    temp3 = getLeastStep(result, i, j + 1, m, n, mat, v) + 1;
                }
                if (j - 1 >= 0 && v[i][j - 1] == 0) {
                    temp4 = getLeastStep(result, i, j - 1, m, n, mat, v) + 1;
                }
                result[i][j] = Math.min(Math.min(Math.min(temp1, temp2), temp3), temp4);

            }
        }
        return result[i][j];

    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}};
        updateMatrix(a);
    }


    public int[][] updateMatrix1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = bfs(i, j, mat, m, n);
                }
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
